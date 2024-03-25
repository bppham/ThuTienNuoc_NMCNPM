/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PersonModel;
import models.AssignmentEmpoylerModel;

/**
 *
 * @author GIANG
 */
public class DetailAssignmentCtrl {

    public static List<AssignmentEmpoylerModel> timTatCaDuLieuThuocKhuVuc(String AreaId, String TimeLine) throws ClassNotFoundException {
        List<AssignmentEmpoylerModel> dsDetailArea = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    Us.PersonId AS IDNguoiSuDung, \n"
                    + "    Us.NamePerson AS TenNguoiSuDung,\n"
                    + "    DA.NameDetailAddress AS TenDiaChiSuDung,\n"
                    + "    RLC.ValueRole AS LoaiNuocSuDung,\n"
                    + "    EM.PersonId AS IDNhanVien,\n"
                    + "    EM.NamePerson AS TenNhanVien,\n"
                    + "    DA.DetailAddressId AS IDDiaChiSuDung\n"
                    + "FROM \n"
                    + "    DetailAddress DA\n"
                    + "JOIN \n"
                    + "    Person Us ON Us.PersonId = DA.PersonId\n"
                    + "JOIN \n"
                    + "    RoleCode RC ON DA.RoleArea = RC.KeyCode\n"
                    + "JOIN \n"
                    + "    Assignment ASM ON ASM.DetailAddressId = DA.DetailAddressId\n"
                    + "JOIN \n"
                    + "    Person EM ON EM.PersonId = ASM.EmployId\n"
                    + "JOIN \n"
                    + "    RoleCode RLC ON RLC.KeyCode = DA.RoleMoneyCategory\n"
                    + "JOIN \n"
                    + "    Account ACC ON ACC.Email = Us.Email\n"
                    + "WHERE \n"
                    + "    RC.KeyCode = ? AND ASM.TimeAssign LIKE ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, AreaId);
            statement.setString(2, "%" + TimeLine + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String IDNguoiSuDung = resultSet.getString("IDNguoiSuDung");
                String TenNguoiSuDung = resultSet.getString("TenNguoiSuDung");
                String TenDiaChiSuDung = resultSet.getString("TenDiaChiSuDung");
                String LoaiNuocSuDung = resultSet.getString("LoaiNuocSuDung");
                String IDNhanVien = resultSet.getString("IDNhanVien");
                String TenNhanVien = resultSet.getString("TenNhanVien");
                String IDDiaChiSuDung = resultSet.getString("IDDiaChiSuDung");

                AssignmentEmpoylerModel assignmentEmpoylerModel = new AssignmentEmpoylerModel(IDNguoiSuDung, TenNguoiSuDung, TenDiaChiSuDung, LoaiNuocSuDung, IDNhanVien, TenNhanVien, IDDiaChiSuDung);
                dsDetailArea.add(assignmentEmpoylerModel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsDetailArea;
    }

    public static List<PersonModel> timTatCaNhanVienTrucThuocKhuVuc(String roleArea) throws ClassNotFoundException {
        List<PersonModel> dsNhanvienTrucThuocKhuVuc = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "Select P.PersonId, P.NamePerson, P.AddressPerson\n"
                    + "from Person P\n"
                    + "join AreaEmployer AEE on AEE.EmployId = P.PersonId where AEE.RoleArea = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, roleArea);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String personId = resultSet.getString("PersonId");
                String name = resultSet.getString("NamePerson");
                String addressPerson = resultSet.getString("AddressPerson");

                PersonModel personWorker = new PersonModel(personId, name, addressPerson);
                dsNhanvienTrucThuocKhuVuc.add(personWorker);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkerCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkerCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsNhanvienTrucThuocKhuVuc;
    }

    public static void capNhatTatCaDuLieuThuocKhuVuc(String AreaId, List<AssignmentEmpoylerModel> assignmentEmpoylerModels, List<AssignmentEmpoylerModel> changeAssignmentEmpoylerModels, String TimeAssign) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement updateStatement = null;

        try {
            connection = ConnectDB.getConnection(); // Thiết lập kết nối đến cơ sở dữ liệu

            for (AssignmentEmpoylerModel changeAssignment : changeAssignmentEmpoylerModels) {
                String changeEmployerId = changeAssignment.getEmployId();
                String detailAddressId = changeAssignment.getDetailAddressId();

                // Thực hiện truy vấn UPDATE để cập nhật dữ liệu
                String updateQuery = "UPDATE Assignment SET EmployId = ?  WHERE DetailAddressId = ? AND TimeAssign LIKE ?";
                updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, changeEmployerId);
                updateStatement.setString(2, detailAddressId);
                updateStatement.setString(3, "%" + TimeAssign + "%");

                updateStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý ngoại lệ khi thực hiện truy vấn SQL
        } finally {
            // Đóng tài nguyên sau khi hoàn thành công việc
            if (updateStatement != null) {
                updateStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static List<AssignmentEmpoylerModel> timTatCaDuLieuThuocKhuVucTheoThoiGian(String AreaId, String timeLine) throws ClassNotFoundException {
        List<AssignmentEmpoylerModel> dsDetailArea = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    Us.PersonId AS IDNguoiSuDung, \n"
                    + "    Us.NamePerson AS TenNguoiSuDung,\n"
                    + "    DA.NameDetailAddress AS TenDiaChiSuDung,\n"
                    + "    RLC.ValueRole AS LoaiNuocSuDung,\n"
                    + "    EM.PersonId AS IDNhanVien,\n"
                    + "    EM.NamePerson AS TenNhanVien,\n"
                    + "    DA.DetailAddressId AS IDDiaChiSuDung\n"
                    + "FROM \n"
                    + "    DetailAddress DA\n"
                    + "JOIN \n"
                    + "    Person Us ON Us.PersonId = DA.PersonId\n"
                    + "JOIN \n"
                    + "    RoleCode RC ON DA.RoleArea = RC.KeyCode\n"
                    + "JOIN \n"
                    + "    Assignment ASM ON ASM.DetailAddressId = DA.DetailAddressId\n"
                    + "JOIN \n"
                    + "    Person EM ON EM.PersonId = ASM.EmployId\n"
                    + "JOIN \n"
                    + "    RoleCode RLC ON RLC.KeyCode = DA.RoleMoneyCategory\n"
                    + "WHERE \n"
                    + "    RC.KeyCode = ? AND ASM.TimeAssign LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, AreaId);
            statement.setString(2, "%" + timeLine + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String IDNguoiSuDung = resultSet.getString("IDNguoiSuDung");
                String TenNguoiSuDung = resultSet.getString("TenNguoiSuDung");
                String TenDiaChiSuDung = resultSet.getString("TenDiaChiSuDung");
                String LoaiNuocSuDung = resultSet.getString("LoaiNuocSuDung");
                String IDNhanVien = resultSet.getString("IDNhanVien");
                String TenNhanVien = resultSet.getString("TenNhanVien");
                String IDDiaChiSuDung = resultSet.getString("IDDiaChiSuDung");

                AssignmentEmpoylerModel assignmentEmpoylerModel = new AssignmentEmpoylerModel(IDNguoiSuDung, TenNguoiSuDung, TenDiaChiSuDung, LoaiNuocSuDung, IDNhanVien, TenNhanVien, IDDiaChiSuDung);
                dsDetailArea.add(assignmentEmpoylerModel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsDetailArea;
    }

    public static void autoPhanCongNhanVien(String AreaId, String TimeAssign, String Timeline) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "select ASM.EmployId AS IDNhanVien, ASM.DetailAddressId AS IDDiaChi\n"
                    + "from DetailAddress DTA \n"
                    + "join Assignment ASM on ASM.DetailAddressId = DTA.DetailAddressId\n"
                    + "where DTA.RoleArea = ? AND DTA.StatusService = 'True' AND ASM.TimeAssign LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, AreaId);
            statement.setString(2, "%" + Timeline + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String employId = resultSet.getString("IDNhanVien");
                String detailAddressId = resultSet.getString("IDDiaChi");
                String SQL2 = "INSERT INTO Assignment (EmployId, DetailAddressId, TimeAssign) VALUES (?,?,?)";

                System.out.println("Nhanvien" + employId);

                PreparedStatement insertStatement = connection.prepareStatement(SQL2);
                insertStatement.setString(1, employId);
                insertStatement.setString(2, detailAddressId);
                insertStatement.setString(3, TimeAssign);

                insertStatement.executeUpdate(); // Thực thi câu lệnh INSERT

                // Đóng statement insertStatement
                insertStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean kiemTraLichPhanCong(String TimeAssign) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "Select * from Assignment where TimeAssign LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + TimeAssign + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailAssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
