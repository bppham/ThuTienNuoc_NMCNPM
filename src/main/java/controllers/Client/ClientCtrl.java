package controllers.Client;

import database.ConnectDB;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import models.Client.ClientBillModel;
import models.Client.ClientChartModel;
import models.Client.ClientHouseholdModel;
import models.Client.ClientInfoModel;
import models.PersonData;
import models.PersonModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Phu Bao
 */
public class ClientCtrl {

    public static String maChuHo;

    // Home
    public static List<ClientBillModel> hienThiCacHoaDonChuaTra() throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = 0 " // Fix mising space before WHERE
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getBoolean("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<ClientBillModel> hienThiCacHoaDonChuaTraTheoDiaChi(String DetailAddressId) throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = 0 " 
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getBoolean("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<ClientBillModel> sapXepTheoGiaTien(List<ClientBillModel> dsHoaDon, boolean tangDan) {
        if (tangDan) {
            Collections.sort(dsHoaDon, Comparator.comparing(ClientBillModel::getTongTien));
        } else {
            Collections.sort(dsHoaDon, Comparator.comparing(ClientBillModel::getTongTien).reversed());
        }
        return dsHoaDon;
    }

    public static void thanhToan(String maHoaDon) throws ClassNotFoundException {
        Date ngayHomNay = new Date();
        java.sql.Date ngayHomNaySQL = new java.sql.Date(ngayHomNay.getTime());
        String sql = "UPDATE HOADON SET THANHTOAN = ?, NGAYTRA = ? WHERE MAHOADON = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setDate(2, ngayHomNaySQL);
            statement.setString(3, maHoaDon);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Info
    public static ClientInfoModel hienThiChuHo() throws ClassNotFoundException {
        String sql = "SELECT CH.MACH, CH.HOTEN, CH.SDT, CH.CCCD, "
                + "CH.DIACHITT, CH.GIOITINH, TK.EMAIL  "
                + "FROM CHUHO AS CH "
                + "JOIN TAIKHOAN AS TK ON TK.MATK = CH.MACH "
                + "WHERE CH.MACH = ?";
        ClientInfoModel ch = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ch = new ClientInfoModel(
                        resultSet.getString("MACH"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("SDT"),
                        resultSet.getString("CCCD"),
                        resultSet.getString("DIACHITT"),
                        resultSet.getString("GIOITINH"),
                        resultSet.getString("EMAIL"));
                return ch;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<ClientHouseholdModel> hienThiCacHoDangSuDungDichVu() throws ClassNotFoundException {
        List<ClientHouseholdModel> dsCacHo = new ArrayList<>();
        String sql = "SELECT CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI "
                + "FROM CHITIETKHUVUC AS CTKV "
                + "JOIN KHUVUC AS KV ON CTKV.MAKHUVUC = KV.MAKHUVUC "
                + "JOIN DONGHO AS DH ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN CHUHO AS CH ON CH.MACH = DH.MACH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "WHERE CH.MACH = ? "
                + "ORDER BY CTKV.MACTKV";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientHouseholdModel house = new ClientHouseholdModel(
                        resultSet.getString("MACTKV"), 
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getString("MADH"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"));
                dsCacHo.add(house);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCacHo;
    }
    
    //Log in
    public static String dangNhap(String email, String matKhau) throws ClassNotFoundException {
        String sql = "SELECT MATKHAU, MAPQ FROM TAIKHOAN AS TK "
                + "WHERE EMAIL = ? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("MATKHAU");
                if (rightPassword.equals(matKhau)) {
                    return resultSet.getString("MAPQ");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void ganMaChuHo(String email) throws ClassNotFoundException{
        String sql = "SELECT * FROM TAIKHOAN WHERE EMAIL = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                maChuHo = resultSet.getString("MATK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        //  RolePerson = 'R3' 
        String sql = "SELECT EMAIL FROM TAIKHOAN WHERE EMAIL = ? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static boolean kiemTraMatKhauCoChinhXac(String email, String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM TAIKHOAN "
                + "WHERE EMAIL = ? AND MATKHAU = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void taoMatKhauMoi(String matKhau, String email) throws ClassNotFoundException {
        String sql = "UPDATE MATKHAU SET TAIKHOAN=? WHERE EMAIL=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matKhau);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Bill
    public static List<ClientBillModel> hienThiHoaDon() throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = 1 " 
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getBoolean("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<ClientBillModel> hienThiHoaDonTheoDiaChi(String maDiaChi) throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = 1 AND CTKV.MACTKV = ? " 
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, maDiaChi);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getBoolean("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<ClientBillModel> sapXepTheoTienTangDan(List<ClientBillModel> dsHoaDon) throws ClassNotFoundException {
        dsHoaDon.sort(Comparator.comparing(ClientBillModel::getTongTien));
        return dsHoaDon;
    }

    public static List<ClientBillModel> sapXepTheoTienGiamDan(List<ClientBillModel> dsHoaDon) throws ClassNotFoundException {
        dsHoaDon.sort(Comparator.comparing(ClientBillModel::getTongTien).reversed());
        return dsHoaDon;
    }

    // Change Password
    public static boolean kiemTraMatKhauHienTai(String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT TK.MATKHAU FROM TAIKHOAN AS TK "
                + "JOIN CHUHO AS CH ON TK.MATK = CH.MACH "
                + "WHERE CH.MACH = ? AND TK.MATKHAU = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void doiMatKhau(String password) throws ClassNotFoundException {
        String sql = "UPDATE TAIKHOAN SET MATKHAU=? WHERE MATK=? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, password);
            statement.setString(2, maChuHo);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------
    public static PersonModel getInforPersonbyEmail(String email) throws ClassNotFoundException {
        String sql = """
                     select p.PersonId,p.NamePerson,p.RolePerson, p.Email,p.PhoneNumber, p.AddressPerson, a.PasswordAcc, rc.ValueRole
                    from Person as p
                    join AreaEmployer as ae
                    on p.PersonId = ae.EmployId
                    join Account as a
                    on a.Email = p.Email
                    join RoleCode as rc
                    on rc.KeyCode = ae.RoleArea
                    where p.Email = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PersonModel personModel = new PersonModel(
                        resultSet.getString("PersonId"),
                        resultSet.getString("PasswordAcc"),
                        resultSet.getString("RolePerson"),
                        resultSet.getString("NamePerson"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("AddressPerson"));
                PersonData.getInstance().setBranch(resultSet.getString("ValueRole"));
                return personModel;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Chart
    public static List<ClientChartModel> layDuLieuThongKe(String maDiaChi) throws ClassNotFoundException {
        List<ClientChartModel> list = new ArrayList<>();
        String sql = "SELECT GN.CSC, GN.CSM, GN.KI, HD.TONGTIEN "
                + "FROM HOADON AS HD "
                + "JOIN GHINUOC AS GN ON HD.MAGHI = GN.MAGHI "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "WHERE CH.MACH = ? AND DH.MADIACHI = ? "
                + "ORDER BY GN.KI DESC ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, maDiaChi);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next() && count < 6) {
                ClientChartModel chart = new ClientChartModel();
                int chiSoCu = resultSet.getInt("CSC");
                int chiSoMoi = resultSet.getInt("CSM");
                int soNuocTieuThu = chiSoMoi - chiSoCu;
                chart.setKi(resultSet.getString("KI"));
                chart.setSoTienPhaiTra(resultSet.getInt("TONGTIEN"));
                chart.setSoNuocTieuThu(soNuocTieuThu);
                list.add(chart);
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.reverse(list);
        return list;
    }

    public static void thongKe(JPanel jpnItem1, JPanel jpnItem2, String maDiaChi) {
        try {
            List<ClientChartModel> listItem = layDuLieuThongKe(maDiaChi);
            if (listItem != null && !listItem.isEmpty()) {
                DefaultCategoryDataset datasetWater = new DefaultCategoryDataset();
                DefaultCategoryDataset datasetMoney = new DefaultCategoryDataset();

                for (ClientChartModel item : listItem) {
                    datasetWater.addValue(item.getSoNuocTieuThu(), "Số nước tiêu thụ", item.getKi());
                    datasetMoney.addValue(item.getSoTienPhaiTra(), "Số tiền phải trả", item.getKi());
                }

                // Create water consumption chart (bar chart)
                JFreeChart chartWater = ChartFactory.createBarChart(
                        "Thống kê số nước", // Tiêu đề biểu đồ
                        "Thời gian", // Nhãn của trục ngang
                        "Số lượng", // Nhãn của trục dọc
                        datasetWater, // Dataset cho dữ liệu của biểu đồ
                        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Hướng của biểu đồ (vertical)
                        true, // Có hiển thị legend không
                        true, // Có tạo tooltips không
                        false // Có tạo URLs không
                );
                ChartPanel chartPanel1 = new ChartPanel(chartWater);
                chartPanel1.setPreferredSize(new Dimension(jpnItem1.getWidth(), 300));

                CategoryPlot plot1 = chartWater.getCategoryPlot();
                plot1.setBackgroundPaint(Color.WHITE);
                BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
                renderer1.setSeriesPaint(0, new Color(173, 216, 230));

                renderer1.setMaximumBarWidth(0.1);

                jpnItem1.removeAll();
                jpnItem1.setLayout(new CardLayout());
                jpnItem1.add(chartPanel1);
                jpnItem1.validate();
                jpnItem1.repaint();

                // Create money to pay chart (line chart)
                JFreeChart chartMoney = ChartFactory.createLineChart(
                        "Thống kê tiền phải trả", // Tiêu đề biểu đồ
                        "Thời gian", // Nhãn của trục ngang
                        "Tiền", // Nhãn của trục dọc
                        datasetMoney, // Dataset cho dữ liệu của biểu đồ
                        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Hướng của biểu đồ (vertical)
                        true, // Có hiển thị legend không
                        true, // Có tạo tooltips không
                        false // Có tạo URLs không
                );
                CategoryPlot plot2 = chartMoney.getCategoryPlot();
                plot2.setBackgroundPaint(Color.WHITE);
                LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
                plot2.setRenderer(renderer2);
                renderer2.setDefaultShapesVisible(true);
                renderer2.setDefaultShape(new Ellipse2D.Double(-2, -2, 4, 4));
                renderer2.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator());

                // Update JPanel with the money to pay chart
                ChartPanel chartPanel2 = new ChartPanel(chartMoney);
                chartPanel2.setPreferredSize(new Dimension(jpnItem2.getWidth(), 300));
                jpnItem2.removeAll();
                jpnItem2.setLayout(new CardLayout());
                jpnItem2.add(chartPanel2);
                jpnItem2.validate();
                jpnItem2.repaint();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
