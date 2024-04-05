
package views.worker;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.DataGlobal;
import models.PersonData;
import models.PersonModel;
import views.main.client.ClientLogin;


public class workerMain extends javax.swing.JFrame {
    
    private final editPassword_worker editPassword_worker1 = new views.worker.editPassword_worker(this);
    private home_worker home_worker2 = new home_worker(this);
    private final managerUser_worker managerUser_worker1 = new managerUser_worker(this);
    private final profile_worker profile_worker1 = new  views.worker.profile_worker(this);
    private GhiDienSoNuoc ghiDienSoNuoc = new views.worker.GhiDienSoNuoc(this);
    private DienSoNuoc dienSoNuoc = new views.worker.DienSoNuoc(this);

    public workerMain() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLayeredPane1.add(home_worker2);
        jLayeredPane1.add(managerUser_worker1);
        jLayeredPane1.add(profile_worker1);
        jLayeredPane1.add(editPassword_worker1);
        jLayeredPane1.add(ghiDienSoNuoc);
        jLayeredPane1.add(dienSoNuoc);
        home_worker2.setVisible(true);
    }

    public void setVisibleAllFalse(){
        home_worker2.setVisible(false);
        profile_worker1.setVisible(false);
        managerUser_worker1.setVisible(false);
        editPassword_worker1.setVisible(false);
        ghiDienSoNuoc.setVisible(false);
        dienSoNuoc.setVisible(false);
    }
    
    public void setVisibleHome(boolean check){
        if(check == true){
            button_home.setBackground(new Color(67, 24, 255));
            button_managerUser.setBackground(new Color(123,150,212));
            button_profile.setBackground(new Color(123,150,212));
            setVisibleAllFalse();
            jLayeredPane1.repaint();
            jLayeredPane1.revalidate();
            home_worker2.setDefault();
            home_worker2.setVisible(true);
            
        }else{
            home_worker2.setVisible(false);
        }
    }
    
    public void setVisibleEditPassword(){
        editPassword_worker1.setVisible(true);
    }
    public void setVisibleProfileUser(){
        profile_worker1.setVisible(true);
    }
    public void setVisibleGhiDienSoNuoc(boolean check){
        if(check == true){
            ghiDienSoNuoc.setDefault();
            ghiDienSoNuoc.setVisible(true);
            
        }
        else{
            ghiDienSoNuoc.setVisible(false);
        }
        
    }
    
    public void setVisibleDienSoNuoc(boolean check){
        if(check == true){
            dienSoNuoc.setDefault();
            dienSoNuoc.setVisible(true);
            
        }
        else{
            dienSoNuoc.setVisible(false);
        }
        
    }
    
    public void setVisibleManagerUser(){
        managerUser_worker1.setVisible(true);
    }
    
    public void setVisibleStack(){
        setVisibleAllFalse();
        switch (PersonData.getInstance().getStack()) {
            case "TRANGCHU" -> setVisibleHome(true);
            case "QLUSERS" -> setVisibleManagerUser();
            case "INFOR" -> setVisibleProfileUser();
            case "DIENSONUOC" -> setVisibleDienSoNuoc(true);
            case "GHIDIENSONUOC" -> setVisibleGhiDienSoNuoc(true);
            case "CHANGEINFOR" -> setVisibleEditPassword();
            default -> {
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        button_home = new javax.swing.JButton();
        button_managerUser = new javax.swing.JButton();
        button_logout = new javax.swing.JButton();
        button_profile = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Client/logoWater.png"))); // NOI18N

        button_home.setBackground(new java.awt.Color(67, 24, 255));
        button_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_home.setForeground(new java.awt.Color(255, 255, 255));
        button_home.setText("Trang chủ");
        button_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_homeActionPerformed(evt);
            }
        });

        button_managerUser.setBackground(new java.awt.Color(123, 150, 212));
        button_managerUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_managerUser.setForeground(new java.awt.Color(255, 255, 255));
        button_managerUser.setText("Quản lý chủ hộ");
        button_managerUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_managerUserActionPerformed(evt);
            }
        });

        button_logout.setBackground(new java.awt.Color(134, 140, 255));
        button_logout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        button_logout.setForeground(new java.awt.Color(255, 255, 255));
        button_logout.setText("Đăng xuất");
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
            }
        });

        button_profile.setBackground(new java.awt.Color(123, 150, 212));
        button_profile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button_profile.setForeground(new java.awt.Color(255, 255, 255));
        button_profile.setText("Hồ sơ");
        button_profile.setPreferredSize(new java.awt.Dimension(72, 55));
        button_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_profileActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_managerUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(button_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_managerUser, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logoutActionPerformed
        new ClientLogin().setVisible(true);
        PersonData.getInstance().clearData();
        this.dispose();
    }//GEN-LAST:event_button_logoutActionPerformed

    private void button_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_homeActionPerformed
        PersonData.getInstance().clearStack();
        setVisibleHome(true);
    }//GEN-LAST:event_button_homeActionPerformed

    private void button_managerUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_managerUserActionPerformed
        PersonData.getInstance().clearStack();
        button_home.setBackground(new Color(123,150,212));
        button_managerUser.setBackground(new Color(67, 24, 255));
        button_profile.setBackground(new Color(123,150,212));
        setVisibleAllFalse();
        managerUser_worker1.setDefault();
        managerUser_worker1.setVisible(true);
    }//GEN-LAST:event_button_managerUserActionPerformed

    private void button_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_profileActionPerformed
        PersonData.getInstance().clearStack();
        button_home.setBackground(new Color(123,150,212));
        button_managerUser.setBackground(new Color(123,150,212));
        button_profile.setBackground(new Color(67, 24, 255));
        setVisibleAllFalse();
        profile_worker1.setDefault();
        profile_worker1.setVisible(true);
    }//GEN-LAST:event_button_profileActionPerformed

    public profile_worker getProfile_worker1() {
        return profile_worker1;
    }


    public void setUserInfor_DienSoNuoc(PersonModel personModel_dsn){
        ghiDienSoNuoc.setPersonModel(personModel_dsn);
    }
    
    public void setBillsUser_DienSoNuoc(PersonModel personModel_dsn){
        dienSoNuoc.setPersonModel(personModel_dsn);
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new workerMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_home;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_managerUser;
    private javax.swing.JButton button_profile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
