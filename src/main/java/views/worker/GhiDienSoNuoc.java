
package views.worker;

import controllers.Worker.WorkerController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.BillModel;
import models.PersonData;
import models.PersonModel;
import models.worker.DetailPrice;


public class GhiDienSoNuoc extends javax.swing.JPanel {
    
    private workerMain wMain;
    private PersonModel personModel;
    private WorkerController workerController = new WorkerController();

    public GhiDienSoNuoc(workerMain wMain) {
        this.wMain = wMain;
        initComponents();
        setDefault();
    }

    public void setDefault(){
        lb_branch.setText("Chi nhánh "+PersonData.getInstance().getBranch());
        jDateChooser1.setDate(new Date());
        if(personModel != null){
            lb_idUser.setText(personModel.getPersonId());
            lb_nameUser.setText(personModel.getNamePerson());
            lb_address.setText(personModel.getAddressPerson());
            lb_phoneNo.setText(personModel.getPhoneNumber());
            text_currentIndex.setText("");
            //----- set value of PrevIndex ----
            try {
                String addressCollectId = workerController.getDetailAddressIdbyNameAddress(personModel.getAddressPerson());
                text_preIndex.setText(String.valueOf(new WorkerController().getCurrentIndex(personModel.getPersonId(),addressCollectId)));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lb_branch = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lb_idUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_nameUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        text_currentIndex = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_address = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lb_phoneNo = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        text_preIndex = new javax.swing.JTextField();
        button_save = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 720));

        jPanel1.setBackground(new java.awt.Color(235, 239, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jPanel7.setBackground(new java.awt.Color(235, 239, 254));

        lb_branch.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lb_branch.setForeground(new java.awt.Color(5, 205, 153));
        lb_branch.setText("Chi nhánh Tân Phú");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lb_branch)
                .addGap(0, 40, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 54, 116));
        jLabel1.setText("Trang chủ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_back)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(button_back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 239, 254));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(544, 250));

        jLabel3.setText("User ID:");

        lb_idUser.setText("CH001");

        jLabel5.setText("Họ và tên:");

        lb_nameUser.setText("Lê Văn A");

        jLabel7.setText("Số nước cũ:");

        jLabel9.setText("Số nước mới:");

        text_currentIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_currentIndexActionPerformed(evt);
            }
        });

        jLabel10.setText("Thời gian ghi:");

        jLabel2.setText("Địa chỉ ghi nước:");

        lb_address.setText("acb, Tân Phú, Tp HCM");

        jLabel12.setText("Số điện thoại:");

        lb_phoneNo.setText("0121243423");

        text_preIndex.setText("100");
        text_preIndex.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel12)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(19, 19, 19)))
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_nameUser)
                    .addComponent(lb_address)
                    .addComponent(lb_idUser)
                    .addComponent(lb_phoneNo)
                    .addComponent(text_currentIndex)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(text_preIndex))
                .addGap(102, 102, 102))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_idUser)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nameUser)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_address)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_phoneNo)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_preIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_currentIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(17, 17, 17))
        );

        button_save.setBackground(new java.awt.Color(134, 140, 255));
        button_save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button_save.setForeground(new java.awt.Color(255, 255, 255));
        button_save.setText("Lưu");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_save))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_save)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void text_currentIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_currentIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_currentIndexActionPerformed

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        wMain.setVisibleAllFalse();
        wMain.setVisibleManagerUser();
    }//GEN-LAST:event_button_backActionPerformed
    
    private String renderIdBill(){
        String id_bill = "";
        try {
            id_bill = workerController.getIdBill();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id_bill.equals("")){
            id_bill = "MD1";
        }else{
            int newNumber = Integer.parseInt(id_bill.substring(2)) + 1;
            id_bill = "MD" + String.valueOf(newNumber);
        }
        return id_bill;
    }
    private boolean checkInput(){
        if(text_currentIndex.equals("")){
            JOptionPane.showMessageDialog(this, "Mã số nước mới không được để trống!", "Thông báo",JOptionPane.OK_OPTION);
            return false;
        }

        if (!(text_currentIndex.getText().matches("[0-9]+(\\.[0-9]+)?"))) {
            JOptionPane.showMessageDialog(this, "Số nước nhập vào phải là số!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        if(Integer.parseInt(String.valueOf(text_preIndex.getText())) >= Integer.parseInt(String.valueOf(text_currentIndex.getText()))){
            JOptionPane.showMessageDialog(this, "Số nước mới không hợp lệ!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        Date newestDate = null;
        try {
            newestDate = workerController.getDateNewest(personModel.getPersonId(),workerController.getDetailAddressIdbyNameAddress(personModel.getAddressPerson()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( newestDate != null && jDateChooser1.getDate().compareTo(newestDate) <0 ){
            JOptionPane.showMessageDialog(this, "Ngày chọn không hợp lệ!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        return true;
    }
    
    private int calculateMoney(){
        List<DetailPrice> lsDetailPrices = new ArrayList<>();
        try {
            lsDetailPrices = workerController.getDetailPrices(personModel.getPersonId(), personModel.getAddressPerson());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        int soGia = Integer.parseInt(String.valueOf(text_currentIndex.getText())) - Integer.parseInt(String.valueOf(text_preIndex.getText()));
        for(DetailPrice dp: lsDetailPrices){
            if(dp.getStartIndex() <= (soGia) && dp.getEndIndex() > (soGia)){
                return (int)(soGia * (dp.getPrice()));
            }
        }
        return -1;
    }
    
    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        if(checkInput()){
            String addressCollectID = "";
            try {
                addressCollectID = workerController.getDetailAddressIdbyNameAddress(personModel.getAddressPerson());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
            BillModel billModel = new BillModel(
                    renderIdBill(),
                    PersonData.getInstance().getPersonInfo().getPersonId(),
                    personModel.getPersonId(),
                    Integer.parseInt(String.valueOf(text_preIndex.getText())),
                    Integer.parseInt(String.valueOf(text_currentIndex.getText())),
                    jDateChooser1.getDate(),
                    calculateMoney(),
                    addressCollectID,
                    false,
                    null
            );
            try {
                workerController.recordBillUser(billModel);
                setDefault();
                wMain.setBillsUser_DienSoNuoc(personModel);
                wMain.setVisibleAllFalse();
                wMain.setVisibleDienSoNuoc(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_back;
    private javax.swing.JButton button_save;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_branch;
    private javax.swing.JLabel lb_idUser;
    private javax.swing.JLabel lb_nameUser;
    private javax.swing.JLabel lb_phoneNo;
    private javax.swing.JTextField text_currentIndex;
    private javax.swing.JTextField text_preIndex;
    // End of variables declaration//GEN-END:variables
}
