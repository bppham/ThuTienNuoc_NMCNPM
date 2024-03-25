
package views.worker.JTableCustomButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class PanelAction extends javax.swing.JPanel {

 
    public PanelAction() {
        initComponents();
        cmdEdit.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-pencil-24.png"));
        cmdView.setIcon(new ImageIcon("src\\main\\java\\images\\Worker\\icons8-view-24.png"));
    }

    public void initEvent(TableActionEvent event, int row){
        cmdView.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onView(row);
            }
        });
        cmdEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onEdit(row);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdView = new views.worker.JTableCustomButton.ActionButton();
        cmdEdit = new views.worker.JTableCustomButton.ActionButton();

        cmdView.setIcon(new javax.swing.ImageIcon("D:\\code\\Java\\project_qlTienNuoc\\main1\\ThuTienNuoc_NMCNPM\\src\\main\\java\\images\\Worker\\icons8-view-24.png")); // NOI18N
        cmdView.setPreferredSize(new java.awt.Dimension(24, 24));
        cmdView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdViewActionPerformed(evt);
            }
        });

        cmdEdit.setIcon(new javax.swing.ImageIcon("D:\\code\\Java\\project_qlTienNuoc\\main1\\ThuTienNuoc_NMCNPM\\src\\main\\java\\images\\Worker\\icons8-pencil-24.png")); // NOI18N
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdViewActionPerformed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private views.worker.JTableCustomButton.ActionButton cmdEdit;
    private views.worker.JTableCustomButton.ActionButton cmdView;
    // End of variables declaration//GEN-END:variables
}
