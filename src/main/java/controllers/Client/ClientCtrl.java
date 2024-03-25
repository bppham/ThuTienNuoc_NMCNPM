package controllers.Client;

import database.ConnectDB;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import models.Client.ClientBillModel;
import models.Client.ClientChartModel;
import models.Client.ClientHouseholdModel;
import models.Client.ClientInfoModel;
import models.PersonData;
import models.PersonModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Phu Bao
 */
public class ClientCtrl {

    public static String currentEmail ;

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

    public static List<ClientBillModel> hienThiCacHoaDonChuaTraTheoDiaChi(String DetailAddressId) throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT CM.CollectMoneyId, CM.UserId, CM.EmployCollectId, DA.RoleMoneyCategory, DA.DetailAddressId, "
                + "DA.NameDetailAddress, EMP.NamePerson, RC.ValueRole, CM.PrevIndex, CM.CurrentIndex, CM.MoneyToPay, CM.TimeCollect "
                + "FROM CollectMoney AS CM  "
                + "JOIN Person AS USR ON CM.UserId = USR.PersonId "
                + "JOIN Person AS EMP ON CM.EmployCollectId = EMP.PersonId "
                + "JOIN DetailAddress AS DA ON DA.DetailAddressId = CM.AddressCollectId "
                + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                + "WHERE USR.RolePerson = 'R3' AND CM.StatusCollect = 0 "
                + "AND USR.Email = ? AND DA.DetailAddressId = ? "
                + "ORDER BY CM.TimeCollect ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            statement.setString(2, DetailAddressId);
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

    public static List<ClientBillModel> sapXepTheoGiaTien(List<ClientBillModel> dsHoaDon, boolean tangDan) {
        if (tangDan) {
            Collections.sort(dsHoaDon, Comparator.comparing(ClientBillModel::getMoneyToPay));
        } else {
            Collections.sort(dsHoaDon, Comparator.comparing(ClientBillModel::getMoneyToPay).reversed());
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
        String sql = "SELECT PS.Email, PS.RolePerson, AC.PasswordAcc "
                + "FROM Person AS PS JOIN Account AS AC ON PS.Email = AC.Email "
                + "WHERE PS.Email = ?";
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
        String sql = "SELECT Email FROM Person WHERE Email = ? ";
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
        String sql = "UPDATE Account SET PasswordAcc=? WHERE Email=? ";
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
    
    public static List<ClientBillModel> hienThiHoaDonTheoDiaChi(String DetailAddressId) throws ClassNotFoundException {
        List<ClientBillModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT CM.CollectMoneyId, CM.UserId, CM.EmployCollectId, DA.RoleMoneyCategory, DA.DetailAddressId, "
                + "DA.NameDetailAddress, EMP.NamePerson, RC.ValueRole, CM.PrevIndex, CM.CurrentIndex, CM.MoneyToPay, CM.TimeCollect "
                + "FROM CollectMoney AS CM  "
                + "JOIN Person AS USR ON CM.UserId = USR.PersonId "
                + "JOIN Person AS EMP ON CM.EmployCollectId = EMP.PersonId "
                + "JOIN DetailAddress AS DA ON DA.DetailAddressId = CM.AddressCollectId "
                + "JOIN RoleCode AS RC ON DA.RoleMoneyCategory = RC.KeyCode "
                + "WHERE USR.RolePerson = 'R3' AND CM.StatusCollect = 1 "
                + "AND USR.Email = ? AND DA.DetailAddressId = ? "
                + "ORDER BY CM.TimeCollect ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            statement.setString(2, DetailAddressId);
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
    
    public static List<ClientBillModel> sapXepTheoTienTangDan(List<ClientBillModel> dsHoaDon) throws ClassNotFoundException {
        dsHoaDon.sort(Comparator.comparing(ClientBillModel::getMoneyToPay));
        return dsHoaDon;
    }
    
    public static List<ClientBillModel> sapXepTheoTienGiamDan(List<ClientBillModel> dsHoaDon) throws ClassNotFoundException {
        dsHoaDon.sort(Comparator.comparing(ClientBillModel::getMoneyToPay).reversed());
        return dsHoaDon;
    }

    // Change Password
    public static boolean kiemTraMatKhauHienTai(String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT PasswordAcc FROM Person AS PS "
                + "JOIN Account AS AC ON PS.Email = AC.Email "
                + "WHERE PS.Email = ? AND AC.PasswordAcc = ?";
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
        String sql = "UPDATE Account SET PasswordAcc=? WHERE Email=? ";
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
                     select p.PersonId,p.NamePerson,p.RolePerson, p.Email,p.PhoneNumber, p.AddressPerson, a.PasswordAcc, rc.ValueRole
                    from Person as p
                    join AreaEmployer as ae
                    on p.PersonId = ae.EmployId
                    join Account as a
                    on a.Email = p.Email
                    join RoleCode as rc
                    on rc.KeyCode = ae.RoleArea
                    where p.Email = ?
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

    // Chart
    public static List<ClientChartModel> layDuLieuThongKe(String idDetailAddress) throws ClassNotFoundException {
        List<ClientChartModel> list = new ArrayList<>();
        String sql = "SELECT CM.PrevIndex, CM.CurrentIndex, CM.MoneyToPay, PS.Email, "
                + "CM.TimeCollect, DA.DetailAddressId, DA.NameDetailAddress "
                + "FROM CollectMoney AS CM "
                + "JOIN Person AS PS ON CM.UserId = PS.PersonId AND PS.RolePerson = 'R3' "
                + "JOIN DetailAddress AS DA ON DA.DetailAddressId = CM.AddressCollectId "
                + "WHERE PS.Email = ? AND DA.DetailAddressId = ? "
                + "ORDER BY CM.TimeCollect DESC ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currentEmail);
            statement.setString(2, idDetailAddress);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next() && count < 6) {
                ClientChartModel chart = new ClientChartModel();
                int prevIndex = resultSet.getInt("PrevIndex");
                int currIndex = resultSet.getInt("CurrentIndex");
                int waterConsumption = currIndex - prevIndex;
                Date date = resultSet.getDate("TimeCollect");
                DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
                String monthYearString = dateFormat.format(date);
                chart.setMonth(monthYearString);
                chart.setMoneyToPay(resultSet.getInt("MoneyToPay"));
                chart.setWaterConsumption(waterConsumption);
                list.add(chart);
                count++; // Tăng biến đếm sau khi thêm dữ liệu vào danh sách
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.reverse(list);
        return list;
    }

    public static void thongKe(JPanel jpnItem1, JPanel jpnItem2, String idDetailAddress) {
        try {
            List<ClientChartModel> listItem = layDuLieuThongKe(idDetailAddress);
            if (listItem != null && !listItem.isEmpty()) {
                DefaultCategoryDataset datasetWater = new DefaultCategoryDataset();
                DefaultCategoryDataset datasetMoney = new DefaultCategoryDataset();

                for (ClientChartModel item : listItem) {
                    datasetWater.addValue(item.getWaterConsumption(), "Số nước tiêu thụ", item.getMonth());
                    datasetMoney.addValue(item.getMoneyToPay(), "Số tiền phải trả", item.getMonth());
                }

                // Create water consumption chart (bar chart)
                JFreeChart chartWater = ChartFactory.createBarChart(
                        "Thống kê số nước", // Tiêu đề biểu đồ
                        "Thời gian", // Nhãn của trục ngang
                        "Số lượng", // Nhãn của trục dọc
                        datasetWater, // Dataset cho dữ liệu của biểu đồ
                        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Hướng của biểu đồ (vertical)
                        true, // Có hiển thị legend không
                        true, // Có tạo tooltips không
                        false // Có tạo URLs không
                );
                ChartPanel chartPanel1 = new ChartPanel(chartWater);
                chartPanel1.setPreferredSize(new Dimension(jpnItem1.getWidth(), 300));

                CategoryPlot plot1 = chartWater.getCategoryPlot();
                plot1.setBackgroundPaint(Color.WHITE);
                BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
                renderer1.setSeriesPaint(0, new Color(173, 216, 230));

                renderer1.setMaximumBarWidth(0.1);

                jpnItem1.removeAll();
                jpnItem1.setLayout(new CardLayout());
                jpnItem1.add(chartPanel1);
                jpnItem1.validate();
                jpnItem1.repaint();

                // Create money to pay chart (line chart)
                JFreeChart chartMoney = ChartFactory.createLineChart(
                        "Thống kê tiền phải trả", // Tiêu đề biểu đồ
                        "Thời gian", // Nhãn của trục ngang
                        "Tiền", // Nhãn của trục dọc
                        datasetMoney, // Dataset cho dữ liệu của biểu đồ
                        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Hướng của biểu đồ (vertical)
                        true, // Có hiển thị legend không
                        true, // Có tạo tooltips không
                        false // Có tạo URLs không
                );
                CategoryPlot plot2 = chartMoney.getCategoryPlot();
                plot2.setBackgroundPaint(Color.WHITE);
                LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
                plot2.setRenderer(renderer2);
                renderer2.setDefaultShapesVisible(true);
                renderer2.setDefaultShape(new Ellipse2D.Double(-2, -2, 4, 4));
                renderer2.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator());

                // Update JPanel with the money to pay chart
                ChartPanel chartPanel2 = new ChartPanel(chartMoney);
                chartPanel2.setPreferredSize(new Dimension(jpnItem2.getWidth(), 300));
                jpnItem2.removeAll();
                jpnItem2.setLayout(new CardLayout());
                jpnItem2.add(chartPanel2);
                jpnItem2.validate();
                jpnItem2.repaint();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
