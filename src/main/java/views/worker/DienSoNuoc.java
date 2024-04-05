
package views.worker;

import controllers.Worker.WorkerController;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.BillModel;
import models.PersonData;
import models.PersonModel;
import views.worker.JTableCustom.Table.TableCustom;
import views.worker.JtextFieldCustom.SearchOptinEvent;
import views.worker.JtextFieldCustom.SearchOption;


public class DienSoNuoc extends javax.swing.JPanel {

    private workerMain wMain;
    private PersonModel personModel;
    private WorkerController workerController = new WorkerController();
    private DefaultTableModel tblModel = new DefaultTableModel(){
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            if(column == 6){
//                return true;
//            }
//            return false;
//        }
        
    };
    
    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    public DienSoNuoc(workerMain wMain) {
        this.wMain = wMain;
        initComponents();
        initTable();
        fillTableBillUser();
        setDefault();
        
    }

    public void setDefault(){
        lb_branch.setText("Chi nhánh "+PersonData.getInstance().getBranch());
        if(personModel != null){
            lb_name.setText(personModel.getNamePerson());
            lb_group.setText(personModel.getRoleValue());
        }
        fillTableBillUser();
        setingUITable();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        
    }
    
    private void setingUITable(){
        TableColumn column1 = table.getColumnModel().getColumn(0);
        column1.setPreferredWidth(25);
        TableColumn column2 = table.getColumnModel().getColumn(1);
        column2.setPreferredWidth(75);
        TableColumn column3 = table.getColumnModel().getColumn(2);
        column3.setPreferredWidth(50);
        TableColumn column4 = table.getColumnModel().getColumn(3);
        column4.setPreferredWidth(35);
        TableColumn column5 = table.getColumnModel().getColumn(4);
        column5.setPreferredWidth(60);
        TableColumn column6 = table.getColumnModel().getColumn(5);
        column6.setPreferredWidth(80);
        TableColumn column7 = table.getColumnModel().getColumn(6);
        column7.setPreferredWidth(80);
        TableColumn column8 = table.getColumnModel().getColumn(7);
        column8.setPreferredWidth(15);
    }
    
    private void initTable() {
        String[] header = new String[]{"ID","Người ghi", "CS Trước", "CS Sau", "Giá tiền", "Thời gian thu", "Thời gian trả","TT"};
        tblModel.setColumnIdentifiers(header);
        table.setModel(tblModel);
        table.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
    }
    public void fillTableBillUser(){
        tblModel.setRowCount(0);
        try {
            if(personModel != null){
                List<BillModel> lsBillModels = workerController.getBillsUser(personModel.getPersonId(),workerController.getDetailAddressIdbyNameAddress(personModel.getAddressPerson()));
                if(lsBillModels != null){
                    for(BillModel bm: lsBillModels){
                    PersonModel workerBill = null;
                    try {
                        workerBill = workerController.getInforPersonbyID(bm.getEmployCollectId());
                    } catch (SQLException ex) {
                        Logger.getLogger(DienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String thanhToan = "";
                    if(bm.isStatusCollect()){
                        thanhToan = "Đã Thanh Toán";
                    }else{
                        thanhToan = "Chưa Thanh Toán";
                    }
                    String timePay = "";
                    if(bm.getTimePay() != null){
                        timePay = String.valueOf(bm.getTimePay());
                    }
                    tblModel.addRow(new String[]{
                        String.valueOf(bm.getCollectMoneyId()),
                        workerBill.getNamePerson(),
                        String.valueOf(bm.getPreIndex()),
                        String.valueOf(bm.getCurrentIndex()),
                        String.valueOf(bm.getMoneyToPay()),
                        String.valueOf(bm.getTimeCollect()),
                        timePay,
                        thanhToan
                        });
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_branch = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        button_rendarBill = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_group = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(235, 239, 254));
        setPreferredSize(new java.awt.Dimension(1000, 720));

        jPanel1.setBackground(new java.awt.Color(235, 239, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 54, 116));
        jLabel1.setText("Hóa đơn chủ hộ");

        lb_branch.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lb_branch.setForeground(new java.awt.Color(5, 205, 153));
        lb_branch.setText("Chi nhánh Tân Phú");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_branch)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_branch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button_back.setBackground(new java.awt.Color(134, 140, 255));
        button_back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button_back.setForeground(new java.awt.Color(255, 255, 255));
        button_back.setText("Quay lại");
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_back)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_back)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(235, 239, 254));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Hóa Đơn Chi Tiết");

        button_rendarBill.setBackground(new java.awt.Color(134, 140, 255));
        button_rendarBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button_rendarBill.setForeground(new java.awt.Color(255, 255, 255));
        button_rendarBill.setText("Ghi số nước mới");
        button_rendarBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rendarBillActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("Tên Chủ Hộ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Nhóm:");

        lb_name.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lb_name.setText("jLabel5");

        lb_group.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lb_group.setText("lb_group");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_rendarBill))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_group)
                            .addComponent(lb_name))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(button_rendarBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lb_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_group)))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ và tên", "Địa chỉ", "Nhóm", "Email", "Số điện thoại", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        wMain.setVisibleAllFalse();
        wMain.setVisibleStack();
        
    }//GEN-LAST:event_button_backActionPerformed

    private void button_rendarBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_rendarBillActionPerformed
        wMain.setVisibleAllFalse();
        PersonData.getInstance().setStack("DIENSONUOC");
        wMain.setUserInfor_DienSoNuoc(personModel);
        wMain.setVisibleGhiDienSoNuoc(true);
    }//GEN-LAST:event_button_rendarBillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_back;
    private javax.swing.JButton button_rendarBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_branch;
    private javax.swing.JLabel lb_group;
    private javax.swing.JLabel lb_name;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
