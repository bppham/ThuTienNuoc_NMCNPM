/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import java.util.Random;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DataGlobal;

import models.PersonModel;
import models.RoleCodeModel;

/**
 *
 * @author GIANG
 */
public class WorkerCtrl {

    PersonModel personModel = DataGlobal.getDataGLobal.dataGlobal.getCurrentEditPerson();

    public static void themNhanVien(PersonModel person, String keyCode) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = dateFormat.format(currentDate);
        String maNV = "NV" + dateString;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO Person (PersonId, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maNV);
            statement.setString(2, person.getRolePerson());
            statement.setString(3, person.getNamePerson());
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getPhoneNumber());
            statement.setString(6, person.getAddressPerson());

//            String hashedPassword = PasswordHashing.hashPassword(nv.getMatKhau());
            statement.executeUpdate();

            // Câu lệnh SQL chèn dữ liệu vào bảng Account
            String sql2 = "INSERT INTO Account (Email, PasswordAcc) VALUES (?, ?)";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, person.getEmail());
            statement2.setString(2, person.getPhoneNumber()); // hashedPassword là chuỗi mật khẩu đã được băm
            statement2.executeUpdate();

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

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO AreaEmployer (EmployId, RoleArea) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maNV);
            statement.setString(2, keyCode);

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
            String sql = "SELECT Person.PersonId, Person.RolePerson, Person.NamePerson, Person.Email, Person.PhoneNumber, Person.AddressPerson, Account.PasswordAcc "
                    + "FROM Person "
                    + "JOIN Account ON Account.Email = Person.Email "
                    + "WHERE Person.RolePerson = 'R1' OR Person.RolePerson = 'R2' AND Account.StatusAcc = 'True'";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String personId = resultSet.getString("PersonId");
                String roleCode = resultSet.getString("RolePerson");
                String name = resultSet.getString("NamePerson");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String addressPerson = resultSet.getString("AddressPerson");
                String PasswordAcc = resultSet.getString("PasswordAcc");

                PersonModel personWorker = new PersonModel(personId, PasswordAcc, roleCode, name, email, phoneNumber, addressPerson);
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
<<<<<<< HEAD
    
      public static void XoaNhanVien(String PersonId) throws ClassNotFoundException {
=======

    public static List<RoleCodeModel> timTatCaKhuvuc() throws ClassNotFoundException {
        List<RoleCodeModel> dsKhuvuc = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM RoleCode  where TypeCode = 'RoleArea' ";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String valueRole = resultSet.getString("ValueRole");
                String keyCode = resultSet.getString("KeyCode");
                String TypeCode = resultSet.getString("TypeCode");

                RoleCodeModel roleCodeModel = new RoleCodeModel(keyCode, TypeCode, valueRole);
                dsKhuvuc.add(roleCodeModel);
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

        return dsKhuvuc;
    }

    public static void XoaNhanVien(String Email) throws ClassNotFoundException {
>>>>>>> cd0e407ab47b902f5cbcab54ce6d5f537c94fab8
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Account SET StatusAcc = ? WHERE Email = ?";

            statement = connection.prepareStatement(sql);

<<<<<<< HEAD
            statement.setString(1, PersonId);
=======
            statement.setString(1, "False");
            statement.setString(2, Email);
>>>>>>> cd0e407ab47b902f5cbcab54ce6d5f537c94fab8

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
        
        System.out.println("Cập nhật: " + person.getPersonId());
        
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Person SET RolePerson=?, NamePerson=?, Email=?, PhoneNumber=?, AddressPerson=? WHERE PersonId=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, person.getRolePerson());
            statement.setString(2, person.getNamePerson());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getPhoneNumber());
            statement.setString(5, person.getAddressPerson());
            statement.setString(6, person.getPersonId());

            statement.executeUpdate();
           

            System.out.println("Thông tin nhân viên đã được cập nhật thành công.");
        } catch (SQLException ex) {
            System.err.println("Lỗi khi cập nhật thông tin nhân viên: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi đóng câu lệnh: " + ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi đóng kết nối: " + ex.getMessage());
            }
        }
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> cd0e407ab47b902f5cbcab54ce6d5f537c94fab8
