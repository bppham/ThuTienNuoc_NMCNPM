
package controllers.Worker;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.BillModel;
import models.PersonModel;
import models.worker.DetailPrice;

public class WorkerController {
    public PersonModel getInforPersonbyID(String id) throws SQLException, ClassNotFoundException{
        String sql = "select * from Person where PersonId = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id);
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
                return personModel;              
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public void changePassword(String newPassword, String id_person) throws ClassNotFoundException, SQLException{
        String sql = "Update Person set PasswordAcc = ? where PersonId = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, newPassword);
            statement.setString(2, id_person);
            int rs = statement.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveEditProfile(PersonModel personModel) throws ClassNotFoundException,SQLException{
        String sql = "Update Person set NamePerson = ?, AddressPerson = ?, PhoneNumber = ?, Email = ? where PersonId = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, personModel.getNamePerson());
            statement.setString(2, personModel.getAddressPerson());
            statement.setString(3, personModel.getPhoneNumber());
            statement.setString(4, personModel.getEmail());
            statement.setString(5, personModel.getPersonId());

            int rs = statement.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getBranchWork(String personId) throws ClassNotFoundException,SQLException{
        String sql = """
                     select *
                     from Assignment as a
                     join RoleCode as rc
                     on a.RoleArea = rc.KeyCode
                     where a.EmployId = ?;
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, personId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("ValueRole");              
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<PersonModel> getInforUsersByBranch(String branch, String where, Object ... search) throws ClassNotFoundException{
        List<PersonModel> lsPersons = new ArrayList<>();
        branch = "%" + branch +"%";
        String sql = """
                     select p.PersonId,p.NamePerson,p.RolePerson, p.Email,p.PhoneNumber, da.NameDetailAddress, p.PasswordAcc, rc.ValueRole
                     from Person as p
                     join DetailAddress as da
                     on p.PersonId = da.PersonId
                     join RoleCode as rc
                     on rc.KeyCode = da.RoleMoneyCategory
                     where da.NameDetailAddress like ?
                     """ + where;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, branch);
            for(int i = 0; i< search.length; i++){
                statement.setObject(i+2, search[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PersonModel personModel = new PersonModel(
                        resultSet.getString("PersonId"), 
                        resultSet.getString("PasswordAcc"), 
                        resultSet.getString("RolePerson"), 
                        resultSet.getString("NamePerson"),
                        resultSet.getString("Email"), 
                        resultSet.getString("PhoneNumber"), 
                        resultSet.getString("NameDetailAddress")); 
                personModel.setRoleValue(resultSet.getString("ValueRole"));
                lsPersons.add(personModel);
                              
            }
            return lsPersons;
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public void recordBillUser(BillModel billModel) throws ClassNotFoundException{
        String sql = """
                     INSERT INTO CollectMoney (CollectMoneyId, EmployCollectId, UserId, PrevIndex, CurrentIndex, TimeCollect, MoneyToPay, AddressCollectId, StatusCollect)
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, billModel.getCollectMoneyId());
            statement.setString(2, billModel.getEmployCollectId());
            statement.setString(3, billModel.getUserId());
            statement.setInt(4, billModel.getPreIndex());
            statement.setInt(5, billModel.getCurrentIndex());
            statement.setDate(6, new java.sql.Date(billModel.getTimeCollect().getTime()));
            statement.setDouble(7, billModel.getMoneyToPay());
            statement.setString(8, billModel.getAddressCollectId());
            statement.setBoolean(9, billModel.isStatusCollect());


            int rs = statement.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<BillModel> getBillsUser(String id_user, String addressCollect) throws ClassNotFoundException{
        List<BillModel> lsBillModels = new ArrayList<>();
        String sql = """
                     select * 
                     from CollectMoney as cm
                     where cm.UserId = ? and cm.AddressCollectId = ?
                     order by cm.TimeCollect DESC, PrevIndex  DESC
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id_user);
            statement.setString(2, addressCollect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BillModel billModel = new BillModel(
                        resultSet.getString("CollectMoneyId"), 
                        resultSet.getString("EmployCollectId"), 
                        resultSet.getString("UserId"), 
                        resultSet.getInt("PrevIndex"),
                        resultSet.getInt("CurrentIndex"), 
                        resultSet.getDate("TimeCollect"), 
                        resultSet.getDouble("MoneyToPay"),
                        resultSet.getString("AddressCollectId"),
                        resultSet.getBoolean("StatusCollect"),
                        resultSet.getDate("TimePay")
                );
                lsBillModels.add(billModel);
                              
            }
            return lsBillModels;
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lsBillModels;
    }
    public int getCurrentIndex(String id_user, String addressCollect) throws ClassNotFoundException{
        int currentIndex = 0;
        String sql = """
                    select *
                    from CollectMoney as cm
                    where cm.UserId = ? and AddressCollectId =? and cm.TimeCollect = (
                    select MAX(cm1.TimeCollect)
                    from CollectMoney as cm1
                    where cm.UserId = ? and AddressCollectId =?
                    )
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id_user);
            statement.setString(2, addressCollect);
            statement.setString(3, id_user);
            statement.setString(4, addressCollect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                currentIndex = resultSet.getInt("CurrentIndex");
                              
            }
            return currentIndex;
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return currentIndex;
    }
    
    public Date getDateNewest(String id_user,String addressCollect) throws ClassNotFoundException{
        Date date = null;
        String sql = """
                     select *
                     from CollectMoney as cm
                     where cm.UserId = ? and AddressCollectId =? and cm.TimeCollect = (
                     	select MAX(cm1.TimeCollect)
                     	from CollectMoney as cm1
                     	where cm1.TimeCollect <= GETDATE()
                     )
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id_user);
            statement.setString(2, addressCollect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                date = resultSet.getDate("TimeCollect");
                              
            }
            return date;
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public String getIdBill() throws ClassNotFoundException{
        String idBill = "";
        String sql = """
                     SELECT TOP 1 cm.CollectMoneyId
                     FROM CollectMoney AS cm
                     order by cm.TimeCollect DESC, PrevIndex  DESC
                    """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                idBill = resultSet.getString("CollectMoneyId");
                              
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return idBill;
    }
    
    public List<DetailPrice> getDetailPrices(String id_user, String addressCollect) throws ClassNotFoundException{
        List<DetailPrice> lsDetailPrices = new ArrayList<>();
        String sql = """
                     select *
                     from DetailAddress as da
                     join RoleCode as rc
                     on da.RoleMoneyCategory = rc.KeyCode
                     join DetailPrice as dp
                     on rc.KeyCode = dp.RoleMoneyCategory
                     where da.PersonId = ? and da.NameDetailAddress = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, id_user);
            statement.setString(2, addressCollect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DetailPrice detailPrice = new DetailPrice(
                        resultSet.getInt("StartIndex"),
                        resultSet.getInt("EndIndex"),
                        resultSet.getDouble("Price"),
                        resultSet.getString("DetailName"),
                        resultSet.getString("RoleMoneyCategory")
                );
                lsDetailPrices.add(detailPrice);
            }
            return lsDetailPrices;
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public String getDetailAddressIdbyNameAddress(String nameDetailAddress) throws ClassNotFoundException{
        String sql = """
                     select DetailAddressId
                     from DetailAddress as da
                     where da.NameDetailAddress = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, nameDetailAddress);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("DetailAddressId");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
}
