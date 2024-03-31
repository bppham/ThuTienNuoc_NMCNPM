/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main.Manager;

import controllers.Manager.AssignmentCtrl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DataGlobal;
import models.RoleCodeModel;

/**
 *
 * @author GIANG
 */
public class Assignment extends javax.swing.JFrame {

    /**
     * Creates new form ManagerArea
     */
    DefaultTableModel tableModel;
    List<RoleCodeModel> listRoleCode = new ArrayList<>();

    private String idArea;

    // Lớp Singleton để lưu trữ thông tin của đối tượng PersonModel được chọn
    public Assignment() {
        try {
            initComponents();
            
            tableModel = (DefaultTableModel) listAreaTable.getModel();

            hienThiDSKhuvuc();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hienThiDSKhuvuc() throws ClassNotFoundException {

        listRoleCode = AssignmentCtrl.timTatCaKhuVuc();

        tableModel.setRowCount(0);

        listRoleCode.forEach(area -> {
            tableModel.addRow(new Object[]{area.getKeyCode(), area.getValuecode()});
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
        jLabel3 = new javax.swing.JLabel();
        addArea = new javax.swing.JButton();
        updateArea = new javax.swing.JButton();
        deleteArea = new javax.swing.JButton();
        reloadArea = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAreaTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldNameArea = new javax.swing.JTextField();
        detailAreaAssignment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(134, 140, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Khu vực ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Công ti dịch vụ nước đô thị Quận 9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(134, 140, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách phường / xã / thị trấn Quận 9");

        addArea.setBackground(new java.awt.Color(0, 153, 255));
        addArea.setForeground(new java.awt.Color(255, 255, 255));
        addArea.setText("Thêm");
        addArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAreaActionPerformed(evt);
            }
        });

        updateArea.setBackground(new java.awt.Color(0, 153, 255));
        updateArea.setForeground(new java.awt.Color(255, 255, 255));
        updateArea.setText("Chỉnh sửa");
        updateArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAreaActionPerformed(evt);
            }
        });

        deleteArea.setBackground(new java.awt.Color(0, 153, 255));
        deleteArea.setForeground(new java.awt.Color(255, 255, 255));
        deleteArea.setText("Xóa");
        deleteArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAreaActionPerformed(evt);
            }
        });

        reloadArea.setBackground(new java.awt.Color(0, 153, 255));
        reloadArea.setForeground(new java.awt.Color(255, 255, 255));
        reloadArea.setText("Làm mới");
        reloadArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadAreaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm");

        listAreaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã khu vực", "Tên khu vực"
            }
        ));
        listAreaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAreaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listAreaTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Phiếu thêm khu vực");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tên Khu vực");

        detailAreaAssignment.setBackground(new java.awt.Color(0, 153, 255));
        detailAreaAssignment.setForeground(new java.awt.Color(255, 255, 255));
        detailAreaAssignment.setText("Xem chi tiết");
        detailAreaAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailAreaAssignmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldNameArea, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(154, 154, 154))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(addArea)
                                .addGap(18, 18, 18)
                                .addComponent(updateArea)
                                .addGap(18, 18, 18)
                                .addComponent(deleteArea)
                                .addGap(18, 18, 18)
                                .addComponent(detailAreaAssignment)
                                .addGap(18, 18, 18)
                                .addComponent(reloadArea)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addArea)
                    .addComponent(updateArea)
                    .addComponent(deleteArea)
                    .addComponent(detailAreaAssignment)
                    .addComponent(reloadArea))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldNameArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reloadAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadAreaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            hienThiDSKhuvuc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reloadAreaActionPerformed

    private void addAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAreaActionPerformed
        // TODO add your handling code here:
        String nameArea = fieldNameArea.getText();

        if (nameArea.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Trường dữ liệu không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                AssignmentCtrl.themKhuvuc(nameArea);
                JOptionPane.showMessageDialog(null, "Tạo khu vực thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi tạo khu vực", "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_addAreaActionPerformed

    private void updateAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAreaActionPerformed
        // TODO add your handling code here:
        String nameArea = fieldNameArea.getText();

        if (nameArea.isEmpty() || idArea.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Trường dữ liệu không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                AssignmentCtrl.CapNhatKhuvuc(idArea, nameArea);
                JOptionPane.showMessageDialog(null, "Cập nhật khu vực thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi cập nhật khu vực", "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_updateAreaActionPerformed

    private void deleteAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAreaActionPerformed
        // TODO add your handling code here:
        if (idArea.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Trường dữ liệu không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                AssignmentCtrl.XoaKhuvuc(idArea);
                JOptionPane.showMessageDialog(null, "Xóa khu vực thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi xóa khu vực", "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteAreaActionPerformed

    private void listAreaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAreaTableMouseClicked
        // TODO add your handling code here:
        int selectedIndex = listAreaTable.getSelectedRow();

        // Kiểm tra xem người dùng đã chọn một dòng hợp lệ hay không
        if (selectedIndex >= 0) {
            try {
                // Lấy đối tượng PersonModel từ danh sách listWorker

                RoleCodeModel roleCodeModel = listRoleCode.get(selectedIndex);

                System.out.println(roleCodeModel);

                fieldNameArea.setText(roleCodeModel.getValuecode());
                idArea = roleCodeModel.getKeyCode();

                DataGlobal.getDataGLobal.dataGlobal.setRoleCodeModel(roleCodeModel);

            } catch (IndexOutOfBoundsException ex) {
                // Xử lý ngoại lệ IndexOutOfBoundsException nếu chỉ số không hợp lệ
                Logger.getLogger(ManagerWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_listAreaTableMouseClicked

    private void detailAreaAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailAreaAssignmentActionPerformed
        // TODO add your handling code here:

        DetailAssignment detailAssignment = new DetailAssignment();
        detailAssignment.setVisible(true);
    }//GEN-LAST:event_detailAreaAssignmentActionPerformed

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
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addArea;
    private javax.swing.JButton deleteArea;
    private javax.swing.JButton detailAreaAssignment;
    private javax.swing.JTextField fieldNameArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listAreaTable;
    private javax.swing.JButton reloadArea;
    private javax.swing.JButton updateArea;
    // End of variables declaration//GEN-END:variables
}
