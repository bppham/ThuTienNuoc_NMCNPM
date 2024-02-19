package controllers.Client;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client.ClientInfoModel;

/**
 *
 * @author Phu Bao
 */
public class ClientCtrl {
    
    public static ClientInfoModel hienThiChuHo(String email) throws ClassNotFoundException {
        ClientInfoModel ch = null;
        String sql = "SELECT PS.PersonId, PS.NamePerson, PS.AddressPerson, PS.PhoneNumber, PS.Email, MC.NameCategoryMoney "
                    + "FROM Person AS PS "
                    + "JOIN MoneyCategory AS MC ON PS.CategoryMoneyId = MC.MoneyCategoryId "
                    + "JOIN RoleCode AS RC ON RC.KeyCode = PS.RolePerson "
                    + "WHERE RC.KeyCode = 'CH' AND PS.Email =?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ch = new ClientInfoModel(
                        resultSet.getString("PersonId"), 
                        resultSet.getString("NamePerson"),
                        resultSet.getString("Email"), 
                        resultSet.getString("PhoneNumber"), 
                        resultSet.getString("AddressPerson"),
                        resultSet.getString("NameCategoryMoney"));                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return ch;
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
}
