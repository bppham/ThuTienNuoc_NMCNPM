
package views.worker;

import controllers.Worker.WorkerController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.PersonData;
import models.PersonModel;


public class editPassword_worker extends javax.swing.JPanel {

    private PersonModel personModel = PersonData.getInstance().getPersonInfo();
    private WorkerController workerController = new WorkerController();
    
    private workerMain wMain;
    public editPassword_worker(workerMain wMain) {
        this.wMain = wMain;
        initComponents();
        setDefault();
    }
    
    private void setDefault(){
        lb_email.setText(personModel.getEmail());
        text_oldPassword.setText("");
        text_newPassword.setText("");
        text_confirmPassword.setText("");
        try {
            lb_branch.setText("Chi nhánh " + workerController.getBranchWork(personModel.getPersonId()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(home_worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkPassword(){
        if(text_oldPassword.getText().equals("")|| text_newPassword.getText().equals("") || text_confirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Các ô không được để trống!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        if(!String.valueOf(text_oldPassword.getText()).equals(personModel.getPasswordAcc())){
            JOptionPane.showMessageDialog(this,"Mật khẩu cũ không đúng! Vui lòng nhập lại", "Thông báo",  JOptionPane.OK_OPTION);
            return false;
        }
        if((String.valueOf(text_newPassword.getText())).length() < 6 || (String.valueOf(text_newPassword.getText())).length() > 20){
            JOptionPane.showMessageDialog(this,"Mật khẩu mới chứa ít nhất 6 kí tự và tối đa 20 kí tự!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        if(!String.valueOf(text_newPassword.getText()).equals(String.valueOf(text_confirmPassword.getText()))){
            JOptionPane.showMessageDialog(this,"Mật khẩu mới không trùng với nhập lại mật khẩu!", "Thông báo",  JOptionPane.OK_OPTION);
            return false;
        }
        if(text_oldPassword.getText().equals(text_newPassword.getText())){
            JOptionPane.showMessageDialog(this, "Mật khẩu mới trùng mật khẩu cũ!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        return true;
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
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        text_oldPassword = new javax.swing.JPasswordField();
        text_newPassword = new javax.swing.JPasswordField();
        text_confirmPassword = new javax.swing.JPasswordField();
        button_save = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 720));

        jPanel1.setBackground(new java.awt.Color(235, 239, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 54, 116));
        jLabel1.setText("Thay đổi mật khẩu");

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
                    .addComponent(jLabel1)
                    .addComponent(lb_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_branch)
                .addContainerGap())
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
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_back)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(button_back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(235, 239, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 400));

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 3));
        jPanel4.setForeground(new java.awt.Color(0, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your Profile");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel4.setText("Tên đăng nhập:");

        lb_email.setText("NV001");

        jLabel7.setText("Mật khẩu cũ:");

        jLabel9.setText("Mật khẩu mới:");

        jLabel11.setText("Xác nhận mật khẩu mới:");

        text_oldPassword.setText("jPasswordField1");
        text_oldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_oldPasswordActionPerformed(evt);
            }
        });

        text_newPassword.setText("jPasswordField2");

        text_confirmPassword.setText("jPasswordField3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(73, 73, 73)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_email)
                    .addComponent(text_oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(text_newPassword)
                    .addComponent(text_confirmPassword))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_email)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(text_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(text_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_save, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_save)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        wMain.setVisibleAllFalse();
        wMain.setVisibleProfileUser();
    }//GEN-LAST:event_button_backActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        if(checkPassword()){
            try {
                workerController.changePassword(String.valueOf(text_newPassword.getText()),personModel.getPersonId());
                JOptionPane.showMessageDialog(this, "Thay đổi mật khẩu thành công!", "Thông báo", JOptionPane.OK_OPTION);
                wMain.setVisibleAllFalse();
                wMain.setVisibleProfileUser();
                personModel = workerController.getInforPersonbyID(personModel.getPersonId());
                PersonData.getInstance().setPersonInfo(personModel);
            setDefault();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(editPassword_worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_saveActionPerformed

    private void text_oldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_oldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_oldPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_back;
    private javax.swing.JButton button_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lb_branch;
    private javax.swing.JLabel lb_email;
    private javax.swing.JPasswordField text_confirmPassword;
    private javax.swing.JPasswordField text_newPassword;
    private javax.swing.JPasswordField text_oldPassword;
    // End of variables declaration//GEN-END:variables
}
