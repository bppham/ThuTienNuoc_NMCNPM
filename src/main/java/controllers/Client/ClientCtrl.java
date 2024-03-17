package controllers.Client;

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
import models.Client.ClientBillModel;
import models.Client.ClientHouseholdModel;
import models.Client.ClientInfoModel;
import models.PersonData;
import models.PersonModel;

/**
 *
 * @author Phu Bao
 */
public class ClientCtrl {

    public static String currentEmail = null;

    // Home
    public static List<ClientBillModel> hienThiCacHoaDonChuaTra() throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT CM.CollectMoneyId, CM.UserId, CM.EmployCollectId, DA.RoleMoneyCategory, DA.DetailAddressId, "
                + "DA.NameDetailAddress, EMP.NamePerson, RC.ValueRole, CM.PrevIndex, CM.CurrentIndex, CM.MoneyToPay, CM.TimeCollect "
                + "FROM CollectMoney AS CM  "
                + "JOIN Person AS USR ON CM.UserId = USR.PersonId "
                + "JOIN Person AS EMP ON CM.EmployCollectId = EMP.PersonId "
                + "JOIN DetailAddress AS DA ON DA.DetailAddressId = CM.AddressCollectId "
                + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                + "WHERE USR.RolePerson = 'R3' AND CM.StatusCollect = 0 "
                + "AND USR.Email = ? "
                + "ORDER BY CM.TimeCollect ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("CollectMoneyId"),
                        resultSet.getString("EmployCollectId"),
                        resultSet.getString("UserId"),
                        resultSet.getString("RoleMoneyCategory"),
                        resultSet.getString("DetailAddressId"),
                        resultSet.getString("NameDetailAddress"),
                        resultSet.getString("NamePerson"),
                        resultSet.getString("ValueRole"),
                        resultSet.getInt("PrevIndex"),
                        resultSet.getInt("CurrentIndex"),
                        resultSet.getInt("MoneyToPay"),
                        resultSet.getDate("TimeCollect"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static void thanhToan(String maHoaDon) throws ClassNotFoundException {
        String sql = "UPDATE CollectMoney SET StatusCollect = ? WHERE CollectMoneyId = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, maHoaDon);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Info
    public static ClientInfoModel hienThiChuHo() throws ClassNotFoundException {
        String sql = "SELECT PS.PersonId, PS.NamePerson, PS.AddressPerson, PS.PhoneNumber, PS.Email "
                + "FROM Person AS PS "
                + "JOIN RoleCode AS RC ON RC.KeyCode = PS.RolePerson "
                + "WHERE RC.KeyCode = 'R3' AND PS.Email =?";
        ClientInfoModel ch = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ch = new ClientInfoModel(
                        resultSet.getString("PersonId"),
                        resultSet.getString("NamePerson"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("AddressPerson"));
                return ch;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<ClientHouseholdModel> hienThiCacHoDangSuDungDichVu() throws ClassNotFoundException {
        List<ClientHouseholdModel> dsCacHo = new ArrayList<>();
        String sql = "SELECT DA.DetailAddressId, DA.NameDetailAddress, RC.ValueRole, DA.RoleArea, RC1.ValueRole AS DetailArea "
                + "FROM DetailAddress AS DA "
                + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                + "JOIN Person AS PS ON PS.PersonId = DA.PersonId "
                + "JOIN RoleCode AS RC1 ON DA.RoleArea = RC1.KeyCode "
                + "WHERE PS.Email = ? "
                + "ORDER BY DA.DetailAddressId ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientHouseholdModel house = new ClientHouseholdModel(
                        resultSet.getString("DetailAddressId"),
                        resultSet.getString("NameDetailAddress"),
                        resultSet.getString("ValueRole"),
                        resultSet.getString("RoleArea"),
                        resultSet.getString("DetailArea"));
                dsCacHo.add(house);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCacHo;
    }

    //Log in
    public static String dangNhap(String password) throws ClassNotFoundException {
        String sql = "SELECT PasswordAcc,RolePerson FROM Person WHERE Email = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("PasswordAcc");
                if (rightPassword.equals(password)) {
                    return resultSet.getString("RolePerson");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        //  RolePerson = 'R3' AND
        String sql = "SELECT Email FROM Person  "
                + "WHERE Email = ? ";
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

    public static void taoMatKhauMoi(String password, String email) throws ClassNotFoundException {
        String sql = "UPDATE Person SET PasswordAcc=? WHERE Email=? AND RolePerson='R3' ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, password);
            statement.setString(2, email);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Bill
    public static List<ClientBillModel> hienThiHoaDon() throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT CM.CollectMoneyId, CM.UserId, CM.EmployCollectId, DA.RoleMoneyCategory, DA.DetailAddressId, "
                + "DA.NameDetailAddress, EMP.NamePerson, RC.ValueRole, CM.PrevIndex, CM.CurrentIndex, CM.MoneyToPay, CM.TimeCollect "
                + "FROM CollectMoney AS CM  "
                + "JOIN Person AS USR ON CM.UserId = USR.PersonId "
                + "JOIN Person AS EMP ON CM.EmployCollectId = EMP.PersonId "
                + "JOIN DetailAddress AS DA ON DA.DetailAddressId = CM.AddressCollectId "
                + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                + "WHERE USR.RolePerson = 'R3' AND CM.StatusCollect = 1 "
                + "AND USR.Email = ? "
                + "ORDER BY CM.TimeCollect ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("CollectMoneyId"),
                        resultSet.getString("EmployCollectId"),
                        resultSet.getString("UserId"),
                        resultSet.getString("RoleMoneyCategory"),
                        resultSet.getString("DetailAddressId"),
                        resultSet.getString("NameDetailAddress"),
                        resultSet.getString("NamePerson"),
                        resultSet.getString("ValueRole"),
                        resultSet.getInt("PrevIndex"),
                        resultSet.getInt("CurrentIndex"),
                        resultSet.getInt("MoneyToPay"),
                        resultSet.getDate("TimeCollect"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    // Change Password
    public static boolean kiemTraMatKhauHienTai(String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT PasswordAcc FROM Person  "
                + "WHERE RolePerson = 'R3' AND Email = ? AND PasswordAcc = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, currentEmail);
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
        String sql = "UPDATE Person SET PasswordAcc=? WHERE Email=? AND RolePerson='R3' ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, password);
            statement.setString(2, currentEmail);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------
    public static PersonModel getInforPersonbyEmail(String email) throws ClassNotFoundException {
        String sql = """
                     select p.PersonId,p.NamePerson,p.RolePerson, p.Email,p.PhoneNumber, p.AddressPerson, p.PasswordAcc, rc.ValueRole
                     from Person as p
                     join Assignment as a
                     on p.PersonId = a.EmployId
                     join RoleCode as rc
                     on rc.KeyCode = a.RoleArea
                     where Email = ?
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
}
