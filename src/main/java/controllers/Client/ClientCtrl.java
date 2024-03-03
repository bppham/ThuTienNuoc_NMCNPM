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
        String sql = "SELECT CM.CollectMoneyId, CM.UserId, CM.PrevIndex, CM.CurrentIndex, CM.TimeCollect, RC.ValueRole, "
                    + "CM.MoneyToPay, DA.DetailAddressId, DA.NameDetailAddress, EMP.PersonId, EMP.NamePerson, DA.RoleMoneyCategory "
                    + "FROM Person AS P "
                    + "JOIN DetailAddress AS DA ON P.PersonId = DA.PersonId "
                    + "JOIN CollectMoney AS CM ON CM.UserId = P.PersonId AND CM.AddressCollectId = DA.DetailAddressId "
                    + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                    + "JOIN Person AS EMP ON CM.EmployCollectId = EMP.PersonId "
                    + "WHERE P.RolePerson = 'R3' AND CM.StatusCollect = 0 "
                    + "AND P.Email = ? "
                    + "ORDER BY CM.TimeCollect ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("CollectMoneyId"),
                        resultSet.getString("PersonId"),
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
    
    
    //Info
    public static ClientInfoModel hienThiChuHo() throws ClassNotFoundException {
        String sql = "SELECT PS.PersonId, PS.NamePerson, PS.AddressPerson, PS.PhoneNumber, PS.Email "
                    + "FROM Person AS PS "
                    + "JOIN RoleCode AS RC ON RC.KeyCode = PS.RolePerson "
                    + "WHERE RC.KeyCode = 'R3' AND PS.Email =?";
        ClientInfoModel ch = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
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
    
    //Log in
    public static String dangNhap(String password) throws ClassNotFoundException {
        String sql = "SELECT PasswordAcc,RolePerson FROM Person WHERE Email = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){           
            statement.setString(1, currentEmail);           
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("PasswordAcc");
                if(rightPassword.equals(password)){
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
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

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
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){                  
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
        String sql = "SELECT CM.CollectMoneyId, CM.UserId, CM.PrevIndex, CM.CurrentIndex, CM.TimeCollect, RC.ValueRole, "
                    + "CM.MoneyToPay, DA.DetailAddressId, DA.NameDetailAddress, EMP.PersonId, EMP.NamePerson, DA.RoleMoneyCategory "
                    + "FROM Person AS P "
                    + "JOIN DetailAddress AS DA ON P.PersonId = DA.PersonId "
                    + "JOIN CollectMoney AS CM ON CM.UserId = P.PersonId AND CM.AddressCollectId = DA.DetailAddressId "
                    + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                    + "JOIN Person AS EMP ON CM.EmployCollectId = EMP.PersonId "
                    + "WHERE P.RolePerson = 'R3' AND CM.StatusCollect = 1 "
                    + "AND P.Email = ? "
                    + "ORDER BY CM.TimeCollect ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getString("CollectMoneyId"),
                        resultSet.getString("PersonId"),
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
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

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
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){                  
            statement.setString(1, password);
            statement.setString(2, currentEmail);  
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    //----------
    public static PersonModel getInforPersonbyEmail(String email) throws ClassNotFoundException{
        String sql = """
                     select p.PersonId,p.NamePerson,p.RolePerson, p.Email,p.PhoneNumber, p.AddressPerson, p.PasswordAcc, rc.ValueRole
                     from Person as p
                     join Assignment as a
                     on p.PersonId = a.EmployId
                     join RoleCode as rc
                     on rc.KeyCode = a.RoleArea
                     where Email = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
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
        }
        catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
