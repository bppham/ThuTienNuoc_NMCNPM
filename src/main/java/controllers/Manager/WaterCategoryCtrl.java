package controllers.Manager;

import static controllers.Client.ClientCtrl.maChuHo;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client.ClientBillModel;
import models.ConsumptionQuotaModel;
import models.WaterCategoryModel;
import utils.GenerateCode;

public class WaterCategoryCtrl {

    // Loại nước 
    public static List<WaterCategoryModel> hienThiLoaiNuoc() throws ClassNotFoundException {
        List<WaterCategoryModel> dsLoaiNuoc = new ArrayList<>();
        String sql = "SELECT * FROM LOAI";
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    WaterCategoryModel loai = new WaterCategoryModel(
                            resultSet.getString("MALOAI"),
                            resultSet.getString("TENLOAI"),
                            resultSet.getInt("PHITRE"));
                    dsLoaiNuoc.add(loai);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, "Error fetching water categories", ex);
        }
        return dsLoaiNuoc;
    }

    public static void themLoaiNuoc(WaterCategoryModel loai) throws ClassNotFoundException {
        String sql = "INSERT INTO LOAI(MALOAI, TENLOAI, PHITRE) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String maLoai = GenerateCode.generateMa("LN");
            statement.setString(1, maLoai);
            statement.setString(2, loai.getTenLoai());
            statement.setInt(3, loai.getPhiTre());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatLoaiNuoc(WaterCategoryModel loai) throws ClassNotFoundException {
        String sql = "UPDATE LOAI SET TENLOAI=?, PHITRE=? WHERE MALOAI=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, loai.getTenLoai());
            statement.setInt(2, loai.getPhiTre());
            statement.setString(3, loai.getMaLoai());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaLoaiNuoc(String maLoaiNuoc) throws ClassNotFoundException {
        String sql = "DELETE FROM LOAI WHERE MALOAI=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maLoaiNuoc);
            xoaDinhMucTheoMaLoai(maLoaiNuoc);
            statement.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Định mức
    public static List<ConsumptionQuotaModel> hienThiDinhMuc(String maLoai) throws ClassNotFoundException {
        List<ConsumptionQuotaModel> dsLoaiNuoc = new ArrayList<>();
        String sql = "SELECT D.MADINHMUC, D.MALOAI, L.TENLOAI, D.SODAU, "
                + "D.SOCUOI, D.THUE, D.DONGIA FROM DINHMUC AS D "
                + "JOIN LOAI AS L ON D.MALOAI = L.MALOAI "
                + "WHERE D.MALOAI = ? "
                + "ORDER BY SODAU";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maLoai);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ConsumptionQuotaModel dinhMuc = new ConsumptionQuotaModel(
                        resultSet.getString("MADINHMUC"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getInt("SODAU"),
                        resultSet.getInt("SOCUOI"),
                        resultSet.getInt("THUE"),
                        resultSet.getInt("DONGIA"));
                dsLoaiNuoc.add(dinhMuc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, "Error fetching water categories", ex);
        }
        return dsLoaiNuoc;
    }

    public static int hienThiSoLuongDinhMuc(String maLoai) throws ClassNotFoundException {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) AS row_count FROM DINHMUC AS D "
                + "JOIN LOAI AS L ON D.MALOAI = L.MALOAI "
                + "WHERE D.MALOAI = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maLoai);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rowCount = resultSet.getInt("row_count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, "Error fetching row count", ex);
        }
        return rowCount;
    }

    public static int hienThiChiSoCuoiLonNhat(String maLoai) throws ClassNotFoundException {
        int chiSoCuoi = 0;
        if (hienThiSoLuongDinhMuc(maLoai) == 0) {
            return chiSoCuoi;
        } else {
            String sqlMaxValue = "SELECT MAX(SOCUOI) AS max_value FROM DINHMUC AS D "
                    + "JOIN LOAI AS L ON D.MALOAI = L.MALOAI "
                    + "WHERE D.MALOAI = ?";
            try (Connection connection = ConnectDB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlMaxValue)) {
                preparedStatement.setString(1, maLoai);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    chiSoCuoi = resultSet.getInt("max_value");
                }
            } catch (SQLException ex) {
                Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, "Error fetching max value", ex);
            }
            return chiSoCuoi;
        }
    }

    public static void themDinhMuc(ConsumptionQuotaModel dinhMuc) throws ClassNotFoundException {
        String sql = "INSERT INTO DINHMUC(MADINHMUC, MALOAI, SODAU, SOCUOI, THUE, DONGIA) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String maDinhMuc = GenerateCode.generateMa("DM");
            statement.setString(1, maDinhMuc);
            statement.setString(2, dinhMuc.getMaLoai());
            statement.setInt(3, dinhMuc.getSoDau());
            statement.setInt(4, dinhMuc.getSoCuoi());
            statement.setInt(5, dinhMuc.getThue());
            statement.setInt(6, dinhMuc.getDonGia());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaDinhMucTheoMaLoai(String maLoai) throws ClassNotFoundException {
        String sqlDelete = "DELETE FROM DINHMUC WHERE MALOAI = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
            preparedStatement.setString(1, maLoai);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Số lượng hàng đã bị xóa: " + rowsAffected);
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, "Error deleting consumption quotas", ex);
        }
    }

    public static boolean kiemTraChisoSauLonNhat(ConsumptionQuotaModel dinhMuc) throws ClassNotFoundException {
        int chiSoCuoiMax = hienThiChiSoCuoiLonNhat(dinhMuc.getMaLoai());
        return dinhMuc.getSoCuoi() == chiSoCuoiMax;
    }
    
    public static void capNhatDinhMuc(ConsumptionQuotaModel dinhMuc) throws ClassNotFoundException {
        String sql = "UPDATE DINHMUC SET SOCUOI=?, THUE=?, DONGIA=? WHERE MADINHMUC=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dinhMuc.getSoCuoi());
            statement.setInt(2, dinhMuc.getThue());
            statement.setInt(3, dinhMuc.getDonGia());
            statement.setString(4, dinhMuc.getMaDinhMuc());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaDinhMuc(String maDinhMuc) throws ClassNotFoundException {
        String sql = "DELETE FROM DINHMUC WHERE MADINHMUC=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maDinhMuc);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(controllers.Manager.WaterCategoryCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
