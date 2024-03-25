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
import models.AssignmentEmpoylerModel;
import models.PersonModel;
import models.RoleCodeModel;

/**
 *
 * @author GIANG
 */
public class UpdateAssignmentEmployDetailCtrl {

    public static AssignmentEmpoylerModel timThongTinHienThiUpdateAssignmentEmpoylerModel(String UserId, String EmployId, String detailAddresId, String TimeAssign) throws ClassNotFoundException {

        AssignmentEmpoylerModel assignmentEmpoylerModel = new AssignmentEmpoylerModel();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT     Us.PersonId AS IDNguoiSuDung, \n"
                    + "                     Us.NamePerson AS TenNguoiSuDung,\n"
                    + "                 DA.NameDetailAddress AS TenDiaChiSuDung,\n"
                    + "                   RLC.ValueRole AS LoaiNuocSuDung,\n"
                    + "                     EM.PersonId AS IDNhanVien,\n"
                    + "                      EM.NamePerson AS TenNhanVien,\n"
                    + "                     DA.DetailAddressId AS IDDiaChiSuDung,\n"
                    + "					 Us.Email AS EmailNguoiSuDung,\n"
                    + "					 Us.PhoneNumber AS SoDienThoaiNguoiSuDung,\n"
                    + "					 EM.Email AS EmailNhanVien,\n"
                    + "                                  ASM.TimeAssign AS ThoiGianPhanCong                           ,\n"
                    + "					 EM.PhoneNumber AS SoDienThoaiNhanVien\n"
                    + "                  FROM \n"
                    + "                      DetailAddress DA\n"
                    + "                 JOIN \n"
                    + "                      Person Us ON Us.PersonId = DA.PersonId\n"
                    + "               JOIN \n"
                    + "                     RoleCode RC ON DA.RoleArea = RC.KeyCode\n"
                    + "               JOIN \n"
                    + "                Assignment ASM ON ASM.DetailAddressId = DA.DetailAddressId\n"
                    + "            JOIN \n"
                    + "               Person EM ON EM.PersonId = ASM.EmployId\n"
                    + "              JOIN \n"
                    + "                RoleCode RLC ON RLC.KeyCode = DA.RoleMoneyCategory\n"
                    + "               WHERE \n"
                    + "                      DA.DetailAddressId = ? AND ASM.TimeAssign LIKE ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, detailAddresId);
            statement.setString(2, "%" + TimeAssign + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String IDNguoiSuDung = resultSet.getString("IDNguoiSuDung");
                String TenNguoiSuDung = resultSet.getString("TenNguoiSuDung");
                String TenDiaChiSuDung = resultSet.getString("TenDiaChiSuDung");
                String LoaiNuocSuDung = resultSet.getString("LoaiNuocSuDung");
                String IDNhanVien = resultSet.getString("IDNhanVien");
                String TenNhanVien = resultSet.getString("TenNhanVien");
                String IDDiaChiSuDung = resultSet.getString("IDDiaChiSuDung");
                String EmailNguoiSuDung = resultSet.getString("EmailNguoiSuDung");
                String SoDienThoaiNguoiSuDung = resultSet.getString("SoDienThoaiNguoiSuDung");
                String EmailNhanVien = resultSet.getString("EmailNhanVien");

                String SoDienThoaiNhanVien = resultSet.getString("SoDienThoaiNhanVien");


                assignmentEmpoylerModel = new AssignmentEmpoylerModel(IDNguoiSuDung, TenNguoiSuDung, TenDiaChiSuDung, LoaiNuocSuDung, IDNhanVien, TenNhanVien, IDDiaChiSuDung, EmailNguoiSuDung, SoDienThoaiNguoiSuDung, EmailNhanVien, SoDienThoaiNhanVien);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return assignmentEmpoylerModel;
    }

    public static List<AssignmentEmpoylerModel> timTatCaNhanVienTrucThuocKhuVuc(String roleArea) throws ClassNotFoundException {
        List<AssignmentEmpoylerModel> assignmentEmpoylerModels = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "Select P.PersonId, P.NamePerson, P.Email, P.PhoneNumber\n"
                    + "from Person P\n"
                    + "join AreaEmployer AEE on AEE.EmployId = P.PersonId where AEE.RoleArea = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, roleArea);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String personId = resultSet.getString("PersonId");
                String name = resultSet.getString("NamePerson");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");

                AssignmentEmpoylerModel assignmentEmpoylerModel = new AssignmentEmpoylerModel(personId, name, email, phoneNumber);
                assignmentEmpoylerModels.add(assignmentEmpoylerModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return assignmentEmpoylerModels;
    }

    public static void capNhatThongTinPhanCongNhanVienChiTiet(String detailAddressId, String employId, String TimeAssign) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement updateStatement = null;

        try {
            connection = ConnectDB.getConnection();

            String updateQuery = "UPDATE Assignment SET EmployId = ?  WHERE DetailAddressId = ? AND TimeAssign LIKE ?";
            updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, employId);
            updateStatement.setString(2, detailAddressId);
            updateStatement.setString(3, "%" + TimeAssign + "%");

            updateStatement.executeUpdate();
        } catch (SQLException ex) {
            // Xử lý ngoại lệ khi thực hiện truy vấn SQL
            Logger.getLogger(UpdateAssignmentEmployDetailCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
