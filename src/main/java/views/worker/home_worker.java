
package views.worker;

import controllers.Worker.WorkerController;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.PersonData;
import models.PersonModel;
import views.worker.JTableCustom.Table.TableCustom;
import views.worker.JTableCustomButton.TableActionCellEditor;
import views.worker.JTableCustomButton.TableActionCellRender;
import views.worker.JTableCustomButton.TableActionEvent;
import views.worker.JtextFieldCustom.SearchOptinEvent;
import views.worker.JtextFieldCustom.SearchOption;
import views.worker.chart.BarChart.LegendItem;
import views.worker.chart.BarChart.ModelChart;
import views.worker.chart.BarChart.ModelLegend;
import views.worker.chart.PieChart.ModelPieChart;
import views.worker.chart.PieChart.PieChart;


public class home_worker extends javax.swing.JPanel {

    private PersonModel personModel = PersonData.getInstance().getPersonInfo();
    private WorkerController workerController = new WorkerController();
    private DefaultTableModel tblModel_userPendingPay = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            if(column == 5){
                return true;
            }
            return false;
        }
    };
    private int priceCurrentMonth = 0;
    private workerMain wMain;

    public home_worker(workerMain wMain) {
        this.wMain = wMain;
        initComponents();
        setDefault();
    }

    public void setDefault(){
        try {
            lb_branch.setText("Chi nhánh " + workerController.getBranchWork(personModel.getPersonId()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(home_worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        lb_month.setText(convertNumberToMonth(calendar.get(Calendar.MONTH) + 1));
        button_pre.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-previous-24.png"));
        button_next.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-next-24.png"));
        button_pre.setEnabled(true);
        button_next.setEnabled(false);
        LocalDate currentDate = LocalDate.now();
        lb_year.setText("Năm " + currentDate.getYear());
        lb_totalUser.setText(String.valueOf(workerController.getTotalUser(PersonData.getInstance().getBranch())));
        lb_payYear.setText(String.valueOf(workerController.getTotalPriceYear(PersonData.getInstance().getBranch())) + " vnd");
        lb_diachicty.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-home-24.png"));
        lb_emailcty.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-mail-24.png"));
        lb_www.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-www-24.png"));
        lb_sdt.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-phone-24.png"));
        lb_copyright.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-copyright-24.png"));
        
        lb_imgUser.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-group-48.png"));
        lb_imgDollar.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-dollar-48.png"));
        
        comboBox_TotalMoney.removeAllItems();
        comboBox_TotalMoney.addItem("Năm " + calendar.get(Calendar.YEAR));
        comboBox_TotalMoney.addItem("Tháng " + (calendar.get(Calendar.MONTH) +1));
        
        setDefaultBarchart();
        setDefaultPieChart(calendar.get(Calendar.MONTH) + 1);
        
        initTable_userPendingPay();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        fillTableInforUser("");
        setingUITable();
        
        txt_search.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txt_search.setHint("Tìm kiếm theo " + option.getName() + "...");
            }
        });
        txt_search.removeAllOption();
        txt_search.addOption(new SearchOption("Tên", new ImageIcon(("src\\main\\java\\images\\Worker\\user_1.png"))));
        txt_search.addOption(new SearchOption("Địa chỉ", new ImageIcon(("src\\main\\java\\images\\Worker\\address.png"))));
        txt_search.addOption(new SearchOption("Nhóm", new ImageIcon(("src\\main\\java\\images\\Worker\\icons8-group-24.png"))));
    }
    
    
    private void setDefaultBarchart(){
        chart.clear();
        chart.addLegend("Income", new Color(245, 189, 135));
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        
        Map<Integer, Double> pricePerMonthMap = workerController.getSumPricePerMonth(PersonData.getInstance().getBranch());
        if(pricePerMonthMap.get(currentMonth) != null){
            priceCurrentMonth = pricePerMonthMap.get(currentMonth).intValue();
        }else{
             priceCurrentMonth = 0;
        }
        
        Set<Integer> keys =  pricePerMonthMap.keySet();
        for(int month = 1; month <= 12; month ++){
            if (!keys.contains(month)){
                chart.addData(new ModelChart(String.valueOf(month), new double[]{0}));
            }
            else{
                chart.addData(new ModelChart(String.valueOf(month), new double[]{pricePerMonthMap.get(month)}));
            }
        }
        chart.start();
    }
    
    private void setDefaultPieChart(int month){
        pieChart1.clearData();
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);

        Map<String,Double> donePay = workerController.getPayDone(PersonData.getInstance().getBranch(), month);
        Map<String,Double> pendingPay = workerController.getPayPending(PersonData.getInstance().getBranch(), month);
        Double totalPay = pendingPay.get("PendingPay") + donePay.get("DonePay");
        pieChart1.addData(new ModelPieChart("PendingPay", pendingPay.get("PendingPay")*100/totalPay,new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("PayDone", 100-pendingPay.get("PendingPay")*100/totalPay,new Color(23, 126, 238)));
    }
    public String convertNumberToMonth(int number) {
        String monthName = "";
        monthName = switch (number) {
            case 1 -> "Tháng Một";
            case 2 -> "Tháng Hai";
            case 3 -> "Tháng Ba";
            case 4 -> "Tháng Tư";
            case 5 -> "Tháng Năm";
            case 6 -> "Tháng Sáu";
            case 7 -> "Tháng Bảy";
            case 8 -> "Tháng Tám";
            case 9 -> "Tháng Chín";
            case 10 -> "Tháng Mười";
            case 11 -> "Tháng Mười Một";
            case 12 -> "Tháng Mười Hai";
            default -> "Số không hợp lệ";
        }; // Nếu số không nằm trong khoảng từ 1 đến 12
        return monthName;
    }
    
    public static int convertMonthToNumber(String monthName) {
        return switch (monthName) {
            case "Tháng Một" -> 1;
            case "Tháng Hai" -> 2;
            case "Tháng Ba" -> 3;
            case "Tháng Tư" -> 4;
            case "Tháng Năm" -> 5;
            case "Tháng Sáu" -> 6;
            case "Tháng Bảy" -> 7;
            case "Tháng Tám" -> 8;
            case "Tháng Chín" -> 9;
            case "Tháng Mười" -> 10;
            case "Tháng Mười Một" -> 11;
            case "Tháng Mười Hai" -> 12;
            default -> -1;
        }; // Trả về -1 nếu tên tháng không hợp lệ
    }
    private void initTable_userPendingPay() {
        String[] header = new String[]{"ID","Họ Và Tên", "Địa Chỉ","Ngày ghi", "Nhóm"," "};
        tblModel_userPendingPay.setColumnIdentifiers(header);
        table.setModel(tblModel_userPendingPay);
        table.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
    }
    private void fillTableInforUser(String where, Object ... text){
        tblModel_userPendingPay.setRowCount(0);
        List<PersonModel> lsPesonInfor;
        try {
            lsPesonInfor = workerController.getInforUsersPendingByBranch(PersonData.getInstance().getBranch(),where,text);
            PersonData.getInstance().setLsPersonInfor(lsPesonInfor);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            for (PersonModel pm : lsPesonInfor) {
                tblModel_userPendingPay.addRow(new String[]{
                    String.valueOf(pm.getPersonId()),
                    pm.getNamePerson(),
                    pm.getAddressPerson(), 
                    sdf.format(pm.getTimeCollect()),
                    pm.getRoleValue()}
                );
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managerUser_worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblModel_userPendingPay.fireTableDataChanged();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String idUserSelected = String.valueOf(table.getValueAt(row, 0));
                for(PersonModel pm: PersonData.getInstance().getLsPersonInfor()){
                    if(pm.getPersonId().equals(idUserSelected)){
                        int choice = JOptionPane.showConfirmDialog(home_worker.this,"Bạn có chắc người này đã thanh toán?", "Ghi tiền",JOptionPane.YES_NO_OPTION);
                        if(choice == JOptionPane.OK_OPTION){
                            int result = workerController.setUserHadPayDone(
                                idUserSelected, 
                                String.valueOf(table.getValueAt(row, 3)),
                                String.valueOf(table.getValueAt(row, 2)));
                            if(result == 1){
                                JOptionPane.showMessageDialog(home_worker.this, "Thành Công", "Thông báo", JOptionPane.OK_OPTION);
                            }else{
                                JOptionPane.showMessageDialog(home_worker.this, "Thất bại", "Thông báo", JOptionPane.OK_OPTION);
                            }
                        }else{
                            return;
                        }
                        break;
                    }
                }
                PersonData.getInstance().setStack("TRANGCHU");
                wMain.setVisibleAllFalse();
                wMain.setVisibleHome(true);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
                String idUserSelected = String.valueOf(table.getValueAt(row, 0));
                for(PersonModel pm: PersonData.getInstance().getLsPersonInfor()){
                    if(pm.getPersonId().equals(idUserSelected)){
                        wMain.setBillsUser_DienSoNuoc(pm);
                        break;
                    }
                }
                PersonData.getInstance().setStack("TRANGCHU");
                wMain.setVisibleAllFalse();
                wMain.setVisibleDienSoNuoc(true);
            }
        };
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        // ----- end table -----
    }
    
        private void setingUITable(){
        TableColumn column1 = table.getColumnModel().getColumn(0);
        column1.setPreferredWidth(10);
        TableColumn column2 = table.getColumnModel().getColumn(1);
        column2.setPreferredWidth(100);
        TableColumn column3 = table.getColumnModel().getColumn(2);
        column3.setPreferredWidth(150);
        TableColumn column4 = table.getColumnModel().getColumn(3);
        column4.setPreferredWidth(50);
        TableColumn column5 = table.getColumnModel().getColumn(4);
        column5.setPreferredWidth(50);
        TableColumn column6 = table.getColumnModel().getColumn(5);
        column6.setPreferredWidth(30);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_branch = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lb_imgUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_totalUser = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lb_imgDollar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_payYear = new javax.swing.JLabel();
        comboBox_TotalMoney = new views.worker.ComboBoxCustom.Combobox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lb_year = new javax.swing.JLabel();
        chart = new views.worker.chart.BarChart.Chart();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pieChart1 = new views.worker.chart.PieChart.PieChart();
        panelLegend = new javax.swing.JPanel();
        labelColor1 = new views.worker.chart.BarChart.LabelColor();
        labelColor2 = new views.worker.chart.BarChart.LabelColor();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lb_month = new javax.swing.JLabel();
        button_pre = new javax.swing.JButton();
        button_next = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_search = new views.worker.JtextFieldCustom.TextFieldSearchOption();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lb_diachicty = new javax.swing.JLabel();
        lb_emailcty = new javax.swing.JLabel();
        lb_www = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        lb_copyright = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBackground(new java.awt.Color(235, 239, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jPanel7.setBackground(new java.awt.Color(235, 239, 254));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 54, 116));
        jLabel1.setText("Trang chủ");

        lb_branch.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lb_branch.setForeground(new java.awt.Color(5, 205, 153));
        lb_branch.setText("Chi nhánh Tân Phú");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_branch)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(235, 239, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lb_imgUser.setPreferredSize(new java.awt.Dimension(48, 48));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel4.setText("User");

        lb_totalUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_totalUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_totalUser.setText("100");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(lb_imgUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_totalUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_totalUser))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lb_imgUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lb_imgDollar.setPreferredSize(new java.awt.Dimension(48, 48));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel7.setText("Tổng tiền đã trả");

        lb_payYear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_payYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_payYear.setText("100.000.000 vnd");

        comboBox_TotalMoney.setLabeText("");
        comboBox_TotalMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_TotalMoneyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lb_imgDollar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_payYear, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox_TotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_TotalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(7, 7, 7)
                                .addComponent(lb_payYear))
                            .addComponent(lb_imgDollar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(235, 239, 254));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        lb_year.setBackground(new java.awt.Color(255, 255, 255));
        lb_year.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_year.setForeground(new java.awt.Color(0, 255, 255));
        lb_year.setText("Năm 2024");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lb_year))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_year, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 255));
        jLabel10.setText("Phân tích thanh toán");

        panelLegend.setBackground(new java.awt.Color(255, 255, 255));

        labelColor1.setBackground(new java.awt.Color(23, 126, 238));
        labelColor1.setText("labelColor1");

        labelColor2.setBackground(new java.awt.Color(221, 65, 65));
        labelColor2.setText("labelColor2");

        jLabel2.setText("Đã Thanh Toán");

        jLabel12.setText("Chưa thanh toán");

        javax.swing.GroupLayout panelLegendLayout = new javax.swing.GroupLayout(panelLegend);
        panelLegend.setLayout(panelLegendLayout);
        panelLegendLayout.setHorizontalGroup(
            panelLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLegendLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLegendLayout.createSequentialGroup()
                        .addComponent(labelColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(panelLegendLayout.createSequentialGroup()
                        .addComponent(labelColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLegendLayout.setVerticalGroup(
            panelLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLegendLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)))
        );

        jPanel10.setBackground(new java.awt.Color(0, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(80, 24));

        lb_month.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lb_month.setForeground(new java.awt.Color(255, 255, 255));
        lb_month.setText("March");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lb_month)
                .addGap(20, 20, 20))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_month))
        );

        button_pre.setPreferredSize(new java.awt.Dimension(24, 24));
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });

        button_next.setPreferredSize(new java.awt.Dimension(24, 24));
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });

        jLabel8.setText("Số đơn:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(69, 69, 69))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ Và Tên", "Địa Chỉ", "Nhóm", ""
            }
        ));
        table.setRowHeight(30);
        jScrollPane1.setViewportView(table);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Bảng người dùng chưa thanh toán");

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CÔNG TY CỔ PHẦN CẤP NƯỚC THỦ ĐỨC");

        lb_diachicty.setText("08 Khổng Tử, P. Bình Thọ, Tp.Thủ Đức, Tp.HCM.");

        lb_emailcty.setText("cntd@capnuocthuduc.vn ");

        lb_www.setText("www.capnuocthuduc.vn");

        lb_sdt.setText("TỔNG ĐÀI: 19001012");

        lb_copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_copyright.setText("2018 BẢN QUYỀN THUỘC VỀ CÔNG TY CỔ PHẦN CẤP NƯỚC THỦ ĐỨC. ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_diachicty, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(lb_emailcty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_www, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69))
                    .addComponent(lb_copyright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lb_diachicty)
                .addGap(18, 18, 18)
                .addComponent(lb_emailcty)
                .addGap(18, 18, 18)
                .addComponent(lb_www)
                .addGap(18, 18, 18)
                .addComponent(lb_sdt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(lb_copyright)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_TotalMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TotalMoneyActionPerformed
        int index = comboBox_TotalMoney.getSelectedIndex();
        if(index == 0){
            lb_payYear.setText(String.valueOf(workerController.getTotalPriceYear(PersonData.getInstance().getBranch())) + " vnd");
        }else{
            lb_payYear.setText(String.valueOf(priceCurrentMonth));
        }
    }//GEN-LAST:event_comboBox_TotalMoneyActionPerformed

    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_preActionPerformed
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int showMonth = convertMonthToNumber(lb_month.getText());
        if(showMonth == 1){
            button_pre.setEnabled(false);
            return;
        }
        int minMonth = currentMonth - 2;
        int maxMonth = currentMonth;
        if(showMonth >= minMonth && showMonth <= maxMonth){
            button_pre.setEnabled(true);
            lb_month.setText(convertNumberToMonth(showMonth-1));
            button_next.setEnabled(true);
            if(showMonth -2  < minMonth || showMonth -1 == 1){
                button_pre.setEnabled(false);
            }
        }else{
            button_pre.setEnabled(false);
        }
        setDefaultPieChart(showMonth -1);
    }//GEN-LAST:event_button_preActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int showMonth = convertMonthToNumber(lb_month.getText());
        if(showMonth == 12){
            button_next.setEnabled(false);
            return;
        }
        int minMonth = currentMonth - 2;
        int maxMonth = currentMonth;
        if(showMonth >= minMonth && showMonth <= maxMonth){
            button_next.setEnabled(true);
            lb_month.setText(convertNumberToMonth(showMonth+1));
            button_pre.setEnabled(true);
            if(showMonth +2  > maxMonth || showMonth+1 == 12){
                button_next.setEnabled(false);
            }
        }else{
            button_next.setEnabled(false); 
        }
        setDefaultPieChart(showMonth +1);
    }//GEN-LAST:event_button_nextActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        if(txt_search.isSelected()){
            int option = txt_search.getSelectedIndex();
            String text = "%" + txt_search.getText().trim() +"%";
            switch (option) {
                case 0 -> fillTableInforUser("and NamePerson like ?", text);
                case 1 -> fillTableInforUser("and NameDetailAddress like ?", text);
                case 3 -> fillTableInforUser("and ValueRole like ?", text);
                default -> {
                }
            }
        }
    }//GEN-LAST:event_txt_searchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private views.worker.chart.BarChart.Chart chart;
    private views.worker.ComboBoxCustom.Combobox comboBox_TotalMoney;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private views.worker.chart.BarChart.LabelColor labelColor1;
    private views.worker.chart.BarChart.LabelColor labelColor2;
    private javax.swing.JLabel lb_branch;
    private javax.swing.JLabel lb_copyright;
    private javax.swing.JLabel lb_diachicty;
    private javax.swing.JLabel lb_emailcty;
    private javax.swing.JLabel lb_imgDollar;
    private javax.swing.JLabel lb_imgUser;
    private javax.swing.JLabel lb_month;
    private javax.swing.JLabel lb_payYear;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JLabel lb_totalUser;
    private javax.swing.JLabel lb_www;
    private javax.swing.JLabel lb_year;
    private javax.swing.JPanel panelLegend;
    private views.worker.chart.PieChart.PieChart pieChart1;
    private javax.swing.JTable table;
    private views.worker.JtextFieldCustom.TextFieldSearchOption txt_search;
    // End of variables declaration//GEN-END:variables
}
