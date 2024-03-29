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
import models.DataGlobal;

import models.PersonModel;

/**
 *
 * @author GIANG
 */
public class WorkerCtrl {
    
    PersonModel personModel = DataGlobal.getDataGLobal.dataGlobal.getCurrentEditPerson();

    public static void themNhanVien(PersonModel person) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO Person (PasswordAcc, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "0972652335");
            statement.setString(2, person.getRolePerson());
            statement.setString(3, person.getNamePerson());
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getPhoneNumber());
            statement.setString(6, person.getAddressPerson());

//            String hashedPassword = PasswordHashing.hashPassword(nv.getMatKhau());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<PersonModel> timTatCaNhanVien() throws ClassNotFoundException {
        List<PersonModel> dsNhanvien = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Person where RolePerson = 'R1' OR RolePerson = 'R2'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String personId = resultSet.getString("PersonId");
                String roleCode = resultSet.getString("RolePerson");
                String name = resultSet.getString("NamePerson");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String addressPerson = resultSet.getString("AddressPerson");
                
                PersonModel personWorker = new PersonModel(personId,name, roleCode, email, addressPerson, phoneNumber);
                dsNhanvien.add(personWorker);
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

        return dsNhanvien;
    }
    
      public static void XoaNhanVien(String PersonId) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM Person WHERE PersonId=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, PersonId);

            statement.executeUpdate();

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
    }
      
      public static void CapNhatNhanVien(PersonModel person) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Person SET RolePerson=?, NamePerson=?, Email=?, PhoneNumber=?, AddressPerson=? WHERE PersonId=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, person.getRolePerson());
            statement.setString(2, person.getNamePerson());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getPhoneNumber());
            statement.setString(5, person.getAddressPerson());
            statement.setString(6, person.getPersonId());

            statement.executeUpdate();
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
    }
}