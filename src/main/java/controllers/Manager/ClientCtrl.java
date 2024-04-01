/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * @author hoang
 */

public class ClientCtrl {
    
    PersonModel personModel = DataGlobal.getDataGLobal.dataGlobal.getCurrentEditPerson();

    // Thêm chủ hộ vào cơ sở dữ liệu
    public static void themChuHo(PersonModel person) throws ClassNotFoundException {
        // Chuỗi SQL để chèn dữ liệu vào bảng Person
        String insertPersonSQL = "INSERT INTO dbo.Person (PersonId, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson) VALUES (?, ?, ?, ?, ?, ?)";

        // Chuỗi SQL để chèn dữ liệu vào bảng Account
        String insertAccountSQL = "INSERT INTO dbo.Account (Email, PasswordAcc) VALUES (?, ?)";

        Connection connection = null;
        try {
            // Lấy kết nối từ lớp ConnectDB
            connection = ConnectDB.getConnection();

            // Tắt tự động commit để có thể quản lý giao dịch
            connection.setAutoCommit(false);

            // Thêm dữ liệu vào bảng Person
            try (PreparedStatement psPerson = connection.prepareStatement(insertPersonSQL)) {
                psPerson.setString(1, person.getPersonId());
                psPerson.setString(2, person.getRolePerson());
                psPerson.setString(3, person.getNamePerson());
                psPerson.setString(4, person.getEmail());
                psPerson.setString(5, person.getPhoneNumber());
                psPerson.setString(6, person.getAddressPerson());
                psPerson.executeUpdate();
            }

            // Thêm dữ liệu vào bảng Account
            try (PreparedStatement psAccount = connection.prepareStatement(insertAccountSQL)) {
                psAccount.setString(1, person.getEmail());
                psAccount.setString(2, person.getPasswordAcc());
                psAccount.executeUpdate();
            }

            // Commit giao dịch
            connection.commit();
        } catch (SQLException ex) {
            // Xử lý lỗi SQL
            ex.printStackTrace();
            try {
                // Rollback giao dịch nếu có lỗi
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            // Đóng kết nối
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static List<PersonModel> timTatCaChuHo() throws ClassNotFoundException {
        List<PersonModel> dsChuHo = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT Person.PersonId, Person.RolePerson, Person.NamePerson, Person.Email, Person.PhoneNumber, Person.AddressPerson, Account.PasswordAcc "
                    + "FROM Person "
                    + "JOIN Account ON Account.Email = Person.Email "
                    + "WHERE Person.RolePerson = 'R3' AND Account.StatusAcc = 'True'";

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
                
                PersonModel personClient = new PersonModel(personId, PasswordAcc, roleCode, name, email, phoneNumber, addressPerson);
                dsChuHo.add(personClient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsChuHo;
    }
    
      public static void XoaChuHo(String PersonId) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM Person WHERE PersonId=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, PersonId);

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
      
      public static void CapNhatChuHo(PersonModel person) throws ClassNotFoundException {
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
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
      
    public static List<PersonModel> kiemTraTinhTrangThanhToan() throws ClassNotFoundException {
        List<PersonModel> overdueClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM CollectMoney WHERE DATEDIFF(WEEK, TimeCollect, GETDATE()) >= 5 AND StatusCollect = 0";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String personId = resultSet.getString("PersonId");
                // Lấy thông tin của người dùng từ PersonId và thêm vào danh sách overdueClients
                PersonModel person = layThongTinNguoiDung(personId);
                if (person != null) {
                    overdueClients.add(person);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return overdueClients;
    }

    // Phương thức này để lấy thông tin của người dùng từ PersonId
    private static PersonModel layThongTinNguoiDung(String personId) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        PersonModel person = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Person WHERE PersonId = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, personId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String rolePerson = resultSet.getString("RolePerson");
                String namePerson = resultSet.getString("NamePerson");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String addressPerson = resultSet.getString("AddressPerson");
                // Tạo đối tượng PersonModel từ thông tin lấy được
                person = new PersonModel(personId, rolePerson, namePerson, email, phoneNumber, addressPerson);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return person;
    }

    
    public static void capNhatTrangThaiTaiKhoan(String personId, boolean status) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Person SET StatusAcc = ? WHERE PersonId = ?";
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, status);
            statement.setString(2, personId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
