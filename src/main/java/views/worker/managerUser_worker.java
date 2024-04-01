
package views.worker;

import controllers.Worker.WorkerController;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

public class managerUser_worker extends javax.swing.JPanel {
    private PersonModel personModel = PersonData.getInstance().getPersonInfo();
    private WorkerController workerController = new WorkerController();
    private DefaultTableModel tblModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            if(column == 6){
                return true;
            }
            return false;
        }
        
    };
    private workerMain wMain;

    public managerUser_worker(workerMain wMain) {
        this.wMain = wMain; 
        initComponents();
        setDefault();
        
    }

    private void setDefault(){
        // table
        initTable();
        fillTableInforUser("");
        setingUITable();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        try {
            lb_branch.setText("Chi nhánh " + workerController.getBranchWork(personModel.getPersonId()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(home_worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_search.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txt_search.setHint("Tìm kiếm theo " + option.getName() + "...");
            }
        });
        txt_search.addOption(new SearchOption("Tên Chủ Hộ", new ImageIcon(("src\\main\\java\\images\\Worker\\user_1.png"))));
        txt_search.addOption(new SearchOption("Số điện thoại", new ImageIcon(("src\\main\\java\\images\\Worker\\tel.png"))));
        txt_search.addOption(new SearchOption("Email", new ImageIcon(("src\\main\\java\\images\\Worker\\email.png"))));
        txt_search.addOption(new SearchOption("Địa chỉ", new ImageIcon(("src\\main\\java\\images\\Worker\\address.png"))));
    }
    
    private void setingUITable(){
        TableColumn column1 = table.getColumnModel().getColumn(0);
        column1.setPreferredWidth(25);
        TableColumn column2 = table.getColumnModel().getColumn(1);
        column2.setPreferredWidth(75);
        TableColumn column3 = table.getColumnModel().getColumn(2);
        column3.setPreferredWidth(200);
        TableColumn column4 = table.getColumnModel().getColumn(3);
        column4.setPreferredWidth(70);
        TableColumn column5 = table.getColumnModel().getColumn(4);
        column5.setPreferredWidth(100);
        TableColumn column6 = table.getColumnModel().getColumn(5);
        column6.setPreferredWidth(60);
        TableColumn column7 = table.getColumnModel().getColumn(6);
        column7.setPreferredWidth(48);
    }
    
    private void initTable() {
        String[] header = new String[]{"ID","Họ và tên", "Địa chỉ", "Nhóm", "Email", "SDT", " "};
        tblModel.setColumnIdentifiers(header);
        table.setModel(tblModel);
        table.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
    }
    
    private void fillTableInforUser(String where, Object ... text){
        tblModel.setRowCount(0);
        List<PersonModel> lsPesonInfor;
        try {
            lsPesonInfor = workerController.getInforUsersByBranch(PersonData.getInstance().getBranch(),where,text);
            PersonData.getInstance().setLsPersonInfor(lsPesonInfor);
            for (PersonModel pm : lsPesonInfor) {
            tblModel.addRow(new String[]{String.valueOf(pm.getPersonId()),pm.getNamePerson(),pm.getAddressPerson(),
                pm.getRolePerson(), pm.getEmail(),
                pm.getPhoneNumber()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managerUser_worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblModel.fireTableDataChanged();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String idUserSelected = String.valueOf(table.getValueAt(row, 0));
                for(PersonModel pm: PersonData.getInstance().getLsPersonInfor()){
                    if(pm.getPersonId().equals(idUserSelected)){
                        wMain.setUserInfor_DienSoNuoc(pm);
                        break;
                    }
                }
                wMain.setVisibleAllFalse();
                wMain.setVisibleGhiDienSoNuoc(true);
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
                wMain.setVisibleAllFalse();
                wMain.setVisibleDienSoNuoc(true);
            }
        };
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        // ----- end table -----
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_branch = new javax.swing.JLabel();
        txt_search = new views.worker.JtextFieldCustom.TextFieldSearchOption();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel1.setText("Quản lý chủ hộ");

        lb_branch.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lb_branch.setForeground(new java.awt.Color(5, 205, 153));
        lb_branch.setText("Chi nhánh Tân Phú");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(235, 239, 254));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Chi tiết chủ hộ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        if(txt_search.isSelected()){
            int option = txt_search.getSelectedIndex();
            String text = "%" + txt_search.getText().trim() +"%";
            switch (option) {
                case 0 -> fillTableInforUser("and NamePerson like ?", text);
                case 1 -> fillTableInforUser("and PhoneNumber like ?", text);
                case 2 -> fillTableInforUser("and Email like ?", text);
                case 3 -> fillTableInforUser("and NameDetailAddress like ?", text);
                default -> {
                }
            }
        }
    }//GEN-LAST:event_txt_searchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_branch;
    private javax.swing.JTable table;
    private views.worker.JtextFieldCustom.TextFieldSearchOption txt_search;
    // End of variables declaration//GEN-END:variables
}
