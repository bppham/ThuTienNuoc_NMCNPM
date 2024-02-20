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

/**
 *
 * @author Phu Bao
 */
public class ClientCtrl {
    public static String currentEmail = null;
    
    //Account
    public static ClientInfoModel hienThiChuHo() throws ClassNotFoundException {
        String sql = "SELECT PS.PersonId, PS.NamePerson, PS.AddressPerson, PS.PhoneNumber, PS.Email, MC.NameCategoryMoney "
                    + "FROM Person AS PS "
                    + "JOIN MoneyCategory AS MC ON PS.CategoryMoneyId = MC.MoneyCategoryId "
                    + "JOIN RoleCode AS RC ON RC.KeyCode = PS.RolePerson "
                    + "WHERE RC.KeyCode = 'CH' AND PS.Email =?";
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
                        resultSet.getString("AddressPerson"),
                        resultSet.getString("NameCategoryMoney")); 
                return ch;              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    //Login
    public static boolean dangNhap(String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT PasswordAcc FROM Person WHERE Email = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){           
            statement.setString(1, currentEmail);           
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("PasswordAcc");
                if(rightPassword.equals(password)){
                    flag = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT Email FROM Person  "
                    + "WHERE RolePerson = 'CH' AND Email = ? ";
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
    
    //Bills
    public static List<ClientBillModel> hienThiHoaDon() throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT CM.CollectMoneyId, EMP.PersonId, CM.UserId, CM.PrevIndex, CM.CurrentIndex, "
                    + "CM.TimeCollect, MC.MoneyCategoryId, CM.MoneyToPay, CM.AddressCollectId, EMP.NamePerson "
                    + "FROM Person AS P "
                    + "JOIN MoneyCategory AS MC ON P.CategoryMoneyId = MC.MoneyCategoryId "
                    + "JOIN CollectMoney AS CM ON CM.UserId = P.PersonId "
                    + "JOIN PERSON AS EMP ON CM.EmployCollectId = EMP.PersonId "
                    + "WHERE P.Email = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientBillModel bill = new ClientBillModel(
                        resultSet.getInt("CollectMoneyId"),
                        resultSet.getInt("PersonId"),
                        resultSet.getInt("UserId"),
                        resultSet.getInt("PrevIndex"), 
                        resultSet.getInt("CurrentIndex"),
                        resultSet.getInt("MoneyCategoryId"),
                        resultSet.getInt("MoneyToPay"),
                        resultSet.getInt("AddressCollectId"),
                        resultSet.getString("TimeCollect"),
                        resultSet.getString("NamePerson"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }
}
