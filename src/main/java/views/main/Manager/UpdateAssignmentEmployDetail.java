/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main.Manager;

import controllers.Manager.DetailAssignmentCtrl;
import controllers.Manager.UpdateAssignmentEmployDetailCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.DataGlobal;
import models.AssignmentEmpoylerModel;

/**
 *
 * @author GIANG
 */
public class UpdateAssignmentEmployDetail extends javax.swing.JFrame {

    /**
     * Creates new form UpdateAssignmentEmployDetail
     */
    List<AssignmentEmpoylerModel> assignmentEmpoylerModels = new ArrayList<>();

    AssignmentEmpoylerModel updatAssignmentEmpoylerModel = new AssignmentEmpoylerModel();

    DefaultTableModel tableModel;

    public UpdateAssignmentEmployDetail() {
        try {
            initComponents();

            setLabelDisplay();

            tableModel = (DefaultTableModel) tableAssignmentEmployer.getModel();

            hienThiDSNhanVien(DataGlobal.getDataGLobal.dataGlobal.getRoleCodeModel().getKeyCode());
        } catch (Exception e) {
            Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setLabelDisplay() {
        String nonphancong = DataGlobal.getDataGLobal.dataGlobal.getEmployerNon();

        if (nonphancong.equals("AC")) {
            try {
                AssignmentEmpoylerModel assignmentEmpoylerModel = UpdateAssignmentEmployDetailCtrl.timThongTinHienThiUpdateAssignmentEmpoylerModelChuaPhanCong(DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getPersonId(), DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getEmployId(), DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getDetailAddressId(), DataGlobal.getDataGLobal.dataGlobal.getTimeAssign());

                System.out.println("Id address " + DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getDetailAddressId());

                currentNameUser.setText(assignmentEmpoylerModel.getNamePerson());
                currentIDUser.setText(assignmentEmpoylerModel.getPersonId());
                currentDetailAddressUser.setText(assignmentEmpoylerModel.getDetailAddress());
                currentPhoneNumberUser.setText(assignmentEmpoylerModel.getPhoneNumberPerson());
                currentUserEmail.setText(assignmentEmpoylerModel.getEmailPerson());
                currentTypeWaterUser.setText(assignmentEmpoylerModel.getTypeWater());
                currentNameEmployer.setText(assignmentEmpoylerModel.getNameEmploy());
                currentIDEmployer.setText(assignmentEmpoylerModel.getEmployId());
                currentEmailEmployer.setText(assignmentEmpoylerModel.getEmailEmploy());
                currentPhoneNumberEmployer.setText(assignmentEmpoylerModel.getPhoneNumberEmploy());
            } catch (Exception ex) {
                Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                AssignmentEmpoylerModel assignmentEmpoylerModel = UpdateAssignmentEmployDetailCtrl.timThongTinHienThiUpdateAssignmentEmpoylerModel(DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getPersonId(), DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getEmployId(), DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getDetailAddressId(), DataGlobal.getDataGLobal.dataGlobal.getTimeAssign());

                System.out.println("Id address " + DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getDetailAddressId());

                currentNameUser.setText(assignmentEmpoylerModel.getNamePerson());
                currentIDUser.setText(assignmentEmpoylerModel.getPersonId());
                currentDetailAddressUser.setText(assignmentEmpoylerModel.getDetailAddress());
                currentPhoneNumberUser.setText(assignmentEmpoylerModel.getPhoneNumberPerson());
                currentUserEmail.setText(assignmentEmpoylerModel.getEmailPerson());
                currentTypeWaterUser.setText(assignmentEmpoylerModel.getTypeWater());
                currentNameEmployer.setText(assignmentEmpoylerModel.getNameEmploy());
                currentIDEmployer.setText(assignmentEmpoylerModel.getEmployId());
                currentEmailEmployer.setText(assignmentEmpoylerModel.getEmailEmploy());
                currentPhoneNumberEmployer.setText(assignmentEmpoylerModel.getPhoneNumberEmploy());
            } catch (Exception ex) {
                Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void hienThiDSNhanVien(String AreaId) throws ClassNotFoundException {

        assignmentEmpoylerModels = UpdateAssignmentEmployDetailCtrl.timTatCaNhanVienTrucThuocKhuVuc(AreaId);

        tableModel.setRowCount(0);

        assignmentEmpoylerModels.forEach(assignmentEmployer -> {
            tableModel.addRow(new Object[]{assignmentEmployer.getEmployId(), assignmentEmployer.getNameEmploy(), assignmentEmployer.getEmailEmploy(), assignmentEmployer.getPhoneNumberEmploy()});
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        currentIDUser = new javax.swing.JLabel();
        currentNameUser = new javax.swing.JLabel();
        currentPhoneNumberUser = new javax.swing.JLabel();
        currentUserEmail = new javax.swing.JLabel();
        currentDetailAddressUser = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        currentTypeWaterUser = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        currentIDEmployer = new javax.swing.JLabel();
        currentNameEmployer = new javax.swing.JLabel();
        currentEmailEmployer = new javax.swing.JLabel();
        currentPhoneNumberEmployer = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAssignmentEmployer = new javax.swing.JTable();
        updateReplace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(134, 140, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chỉnh sửa chi tiết phân công nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Công ty dịch vụ nước đô thị Quận 9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setText("Thông tin người sử dụng");

        jLabel4.setText("ID:");

        jLabel5.setText("Họ và tên: ");

        jLabel6.setText("Số điện thoại:");

        jLabel7.setText("Email:");

        jLabel8.setText("Địa chỉ đăng ký:");

        currentIDUser.setText("jLabel15");

        currentNameUser.setText("jLabel15");

        currentPhoneNumberUser.setText("jLabel15");

        currentUserEmail.setText("jLabel15");

        currentDetailAddressUser.setText("jLabel15");

        jLabel15.setText("Loại nước sử dụng");

        currentTypeWaterUser.setText("jLabel16");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentPhoneNumberUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(currentIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentUserEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(currentDetailAddressUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentTypeWaterUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(currentUserEmail))
                        .addGap(18, 18, 18)
                        .addComponent(currentDetailAddressUser))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(currentIDUser))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(currentNameUser))))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(currentPhoneNumberUser)
                    .addComponent(jLabel15)
                    .addComponent(currentTypeWaterUser))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel9.setText("Thông tin nhân viên đang được phân công");

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));

        jLabel10.setText("ID");

        jLabel11.setText("Họ và tên");

        jLabel12.setText("Email");

        jLabel13.setText("Số điện thoại");

        currentIDEmployer.setText("jLabel15");

        currentNameEmployer.setText("jLabel16");

        currentEmailEmployer.setText("jLabel17");

        currentPhoneNumberEmployer.setText("jLabel18");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(currentIDEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentNameEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentEmailEmployer, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentPhoneNumberEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(currentIDEmployer)
                    .addComponent(currentNameEmployer)
                    .addComponent(currentEmailEmployer)
                    .addComponent(currentPhoneNumberEmployer))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel14.setText("Chọn nhân viên khác để thay thế");

        tableAssignmentEmployer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Họ và tên", "Email", "Số điện thoại"
            }
        ));
        tableAssignmentEmployer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAssignmentEmployerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAssignmentEmployer);

        updateReplace.setText("Thay thế");
        updateReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateReplaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(updateReplace))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(updateReplace))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateReplaceActionPerformed
        // TODO add your handling code here:
        try {
            UpdateAssignmentEmployDetailCtrl.capNhatThongTinPhanCongNhanVienChiTiet(DataGlobal.getDataGLobal.dataGlobal.getAssignmentEmpoylerModel().getDetailAddressId(), updatAssignmentEmpoylerModel.getEmployId(), DataGlobal.getDataGLobal.dataGlobal.getTimeAssign());
            setLabelDisplay();

        } catch (Exception ex) {
            Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateReplaceActionPerformed

    private void tableAssignmentEmployerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAssignmentEmployerMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tableAssignmentEmployer.getSelectedRow();

        // Kiểm tra xem người dùng đã chọn một dòng hợp lệ hay không
        if (selectedIndex >= 0) {
            try {
                // Lấy đối tượng PersonModel từ danh sách listWorker

                updatAssignmentEmpoylerModel = assignmentEmpoylerModels.get(selectedIndex);

            } catch (IndexOutOfBoundsException ex) {
                // Xử lý ngoại lệ IndexOutOfBoundsException nếu chỉ số không hợp lệ
                Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_tableAssignmentEmployerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAssignmentEmployDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAssignmentEmployDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentDetailAddressUser;
    private javax.swing.JLabel currentEmailEmployer;
    private javax.swing.JLabel currentIDEmployer;
    private javax.swing.JLabel currentIDUser;
    private javax.swing.JLabel currentNameEmployer;
    private javax.swing.JLabel currentNameUser;
    private javax.swing.JLabel currentPhoneNumberEmployer;
    private javax.swing.JLabel currentPhoneNumberUser;
    private javax.swing.JLabel currentTypeWaterUser;
    private javax.swing.JLabel currentUserEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAssignmentEmployer;
    private javax.swing.JButton updateReplace;
    // End of variables declaration//GEN-END:variables
}
