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
import models.RoleCodeModel;
import models.DataGlobal;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author GIANG
 */
public class AssignmentCtrl {
    
     
    
    public static List<RoleCodeModel> timTatCaKhuVuc() throws ClassNotFoundException {
        List<RoleCodeModel> dsKhuvuc = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM RoleCode where TypeCode = 'RoleArea'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String keyCode = resultSet.getString("KeyCode");
                String valueRole = resultSet.getString("ValueRole");
                
                
                RoleCodeModel roleCodeModel = new RoleCodeModel(keyCode, valueRole);
                dsKhuvuc.add(roleCodeModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsKhuvuc;
    }
    
    public static void themKhuvuc(String nameArea) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        // Lấy ngày giờ hiện tại
        LocalDateTime currentTime = LocalDateTime.now();

        // Định dạng ngày giờ
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

        // Chuyển đổi ngày giờ hiện tại thành chuỗi
        String formattedDateTime = formatter.format(currentTime);

        // Lấy 5 ký tự cuối của chuỗi ngày giờ
        String lastFiveCharacters = formattedDateTime.substring(formattedDateTime.length() - 5);

        // Tạo một số ngẫu nhiên
        Random random = new Random();
        int randomNumber = random.nextInt(10000); // Số ngẫu nhiên có thể có tối đa 4 chữ số

        // Tạo chuỗi kết quả
        String resultString = lastFiveCharacters + randomNumber;

        String maKhuvuc = "AE" + resultString;
        
        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO RoleCode (KeyCode, TypeCode, ValueRole) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maKhuvuc);
            statement.setString(2, "RoleArea");
            statement.setString(3, nameArea);

//            String hashedPassword = PasswordHashing.hashPassword(nv.getMatKhau());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void XoaKhuvuc(String RoleCodeId) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM RoleCode WHERE KeyCode = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, RoleCodeId);

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void CapNhatKhuvuc(String idArea,String nameArea) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE RoleCode SET ValueRole = ? WHERE KeyCode=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, nameArea);
            statement.setString(2, idArea);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
