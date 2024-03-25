/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main.Manager;

import controllers.Manager.AssignmentCtrl;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

import controllers.Manager.DetailAssignmentCtrl;
import controllers.Manager.WorkerCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DataGlobal;
import models.PersonModel;
import models.RoleCodeModel;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import models.AssignmentEmpoylerModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author GIANG
 */
public class DetailAssignment extends javax.swing.JFrame {

    /**
     * Creates new form DetailAssignment
     */
    // Tạo combobox và thêm các mục vào
    List<PersonModel> listWorker = new ArrayList<>();

    RoleCodeModel roleCodeModel = DataGlobal.getDataGLobal.dataGlobal.getRoleCodeModel();

    DefaultTableModel tableModel;

    List<AssignmentEmpoylerModel> assignmentEmpoylerModels = new ArrayList<>();

    List<AssignmentEmpoylerModel> changeAssignmentEmpoylerModels = new ArrayList<>();

    List<String> detailAddressId = new ArrayList<>();

    String resultTime;

    String TimeSelect;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date currentDate = new Date();
    String dateTimeString = dateFormat.format(currentDate);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Phân tích chuỗi thành LocalDateTime
    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

    // Trích xuất tháng và năm
    int month = dateTime.getMonthValue();
    int year = dateTime.getYear();

    public DetailAssignment() {

        // Date Time
        // Tạo chuỗi mới
        resultTime = month + "/" + year;

        try {
            initComponents();

            // Set abtribution 
            // Tạo JComboBox cho tháng và năm
            String[] monthsYears = generateMonthsYears();

            for (int i = 0; i < monthsYears.length; i++) {
                listTimeAssignment.addItem(monthsYears[i]);
            }

//            listTimeAssignment = new JComboBox<>(monthsYears);
            nameArea.setText(roleCodeModel.getValuecode());

            JComboBox<String> comboBox = new JComboBox<>();

// Gán TableCellEditor cho cột bạn muốn thêm combobox vào (ví dụ: cột thứ 2)
            TableColumn column = areaAssignmentEmployer.getColumnModel().getColumn(4);

            areaAssignmentEmployer.getAccessibleContext();

            column.setCellEditor(
                    new DefaultCellEditor(comboBox));

            listWorker = DetailAssignmentCtrl.timTatCaNhanVienTrucThuocKhuVuc(roleCodeModel.getKeyCode());

            listWorker.forEach(person -> {
                comboBox.addItem(person.getPersonId());

            });

            // Add Data 
            tableModel = (DefaultTableModel) areaAssignmentEmployer.getModel();

            hienThiDSPhanCong(roleCodeModel.getKeyCode(), resultTime);

            TimeSelect = listTimeAssignment.getSelectedItem().toString();

            listTimeAssignment.setSelectedItem(resultTime);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DetailAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void selectTime() {
        String selectedValue = listTimeAssignment.getSelectedItem().toString();

        TimeSelect = selectedValue;
    }

    public void hienThiDSPhanCong(String AreaId, String TimeLine) throws ClassNotFoundException {

        assignmentEmpoylerModels = DetailAssignmentCtrl.timTatCaDuLieuThuocKhuVuc(AreaId, TimeLine);
        tableModel.setRowCount(0);

        assignmentEmpoylerModels.forEach(assignmentEmployer -> {
            tableModel.addRow(new Object[]{assignmentEmployer.getPersonId(), assignmentEmployer.getNamePerson(), assignmentEmployer.getTypeWater(), assignmentEmployer.getDetailAddress(), assignmentEmployer.getEmployId(), assignmentEmployer.getNameEmploy()});
        });

        assignmentEmpoylerModels.forEach(assign -> {
            detailAddressId.add(assign.getDetailAddressId());
        });

    }

    private String[] generateMonthsYears() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int currentYear = calendar.get(java.util.Calendar.YEAR);
        String[] monthsYears = new String[120]; // 5 years before and 5 years after
        int count = 0;
        for (int year = currentYear - 5; year <= currentYear + 5; year++) {
            for (int month = 1; month <= 12; month++) {
                if (count < monthsYears.length) {
                    monthsYears[count++] = getMonthName(month) + year;
                } else {
                    break; // Exit the loop if we've filled the array
                }
            }
        }
        return monthsYears;
    }

    private String getMonthName(int month) {
        switch (month) {
            case 1:
                return "1/";
            case 2:
                return "2/";
            case 3:
                return "3/";
            case 4:
                return "4/";
            case 5:
                return "5/";
            case 6:
                return "6/";
            case 7:
                return "7/";
            case 8:
                return "8/";
            case 9:
                return "9/";
            case 10:
                return "10/";
            case 11:
                return "11/";
            case 12:
                return "12/";
            default:
                return "";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameArea = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaAssignmentEmployer = new javax.swing.JTable();
        autoAssign = new javax.swing.JButton();
        listTimeAssignment = new javax.swing.JComboBox<>();
        updateAssignmentEmployUser = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        displayInfo = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(134, 140, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phân công nhân viên ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Công ty dịch vụ nước đô thị Quận 9");

        nameArea.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        nameArea.setText("Name Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameArea, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameArea, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(134, 140, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách phân công nhân viên");

        areaAssignmentEmployer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã người sử dụng", "Tên người sử dụng", "Loại nước sử dụng", "Địa chỉ", "Mã nhân viên", "Tên nhân viên"
            }
        ));
        areaAssignmentEmployer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areaAssignmentEmployerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(areaAssignmentEmployer);

        autoAssign.setText("Tự động phân công");
        autoAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoAssignActionPerformed(evt);
            }
        });

        listTimeAssignment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        listTimeAssignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTimeAssignmentMouseClicked(evt);
            }
        });
        listTimeAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listTimeAssignmentActionPerformed(evt);
            }
        });

        updateAssignmentEmployUser.setText("Chỉnh sửa");
        updateAssignmentEmployUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAssignmentEmployUserActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Chọn thời gian");

        displayInfo.setText("Xem thông tin");
        displayInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayInfoActionPerformed(evt);
            }
        });

        resetButton.setText("Đặt lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        applyButton.setText("Áp dụng");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(27, 27, 27)
                                .addComponent(listTimeAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(displayInfo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetButton)
                                .addGap(26, 26, 26)
                                .addComponent(applyButton)
                                .addGap(27, 27, 27)
                                .addComponent(updateAssignmentEmployUser)
                                .addGap(26, 26, 26)
                                .addComponent(autoAssign))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(autoAssign)
                        .addComponent(updateAssignmentEmployUser)
                        .addComponent(resetButton)
                        .addComponent(applyButton)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(listTimeAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void autoAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoAssignActionPerformed
        // TODO add your handling code here:
        // Định dạng ngày giờ
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Lấy ngày hiện tại
        Date currentDate = new Date();

        // Tạo một đối tượng Calendar và thiết lập ngày hiện tại vào đó
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Tăng thêm 1 tháng
        calendar.add(Calendar.MONTH, 1);

        // Đặt ngày là 1
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Lấy ngày sau khi tăng 1 tháng và định dạng lại thành chuỗi
        Date nextMonthDate = calendar.getTime();

        String nextMonthDateTimeString = dateFormat.format(nextMonthDate);

        selectTime();

        String TimeAutoAssign = String.valueOf(month + 1) + "/" + year;

        System.out.println(resultTime);

        try {

            if (DetailAssignmentCtrl.kiemTraLichPhanCong(TimeAutoAssign)) {
                JOptionPane.showMessageDialog(null, "Tháng tiếp theo đã được phân công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                DetailAssignmentCtrl.autoPhanCongNhanVien(roleCodeModel.getKeyCode(), nextMonthDateTimeString, resultTime);

            }

        } catch (Exception ex) {
            Logger.getLogger(DetailAssignment.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_autoAssignActionPerformed

    private void updateAssignmentEmployUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAssignmentEmployUserActionPerformed
        // TODO add your handling code here:
        selectTime();
        String[] parts = TimeSelect.split("/");
        
        // Lấy tháng và năm từ mảng parts
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        
        if (month >= Integer.parseInt(String.valueOf(this.month)) && year >= Integer.parseInt(String.valueOf(this.year))) {
            DataGlobal.getDataGLobal.dataGlobal.setTimeAssign(TimeSelect);
            UpdateAssignmentEmployDetail updateAssignmentEmployDetail = new UpdateAssignmentEmployDetail();
            updateAssignmentEmployDetail.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Ngoài thời gian phân công, không được chỉnh sửa phân công !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_updateAssignmentEmployUserActionPerformed

    private void listTimeAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listTimeAssignmentActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_listTimeAssignmentActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        try {
            hienThiDSPhanCong(roleCodeModel.getKeyCode(), resultTime);
            listTimeAssignment.setSelectedItem(resultTime);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DetailAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_resetButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:

        selectTime();
        
        String[] parts = TimeSelect.split("/");
        
        // Lấy tháng và năm từ mảng parts
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        if (month >= Integer.parseInt(String.valueOf(this.month)) && year >= Integer.parseInt(String.valueOf(this.year))) {
            for (int row = 0; row < areaAssignmentEmployer.getRowCount(); row++) {
                String personId = (String) areaAssignmentEmployer.getValueAt(row, 0); // Giả sử cột đầu tiên là PersonId
                String namePerson = (String) areaAssignmentEmployer.getValueAt(row, 1); // Giả sử cột thứ hai là NamePerson
                String typeWater = (String) areaAssignmentEmployer.getValueAt(row, 2);
                String detailAddress = (String) areaAssignmentEmployer.getValueAt(row, 3);
                String employerId = (String) areaAssignmentEmployer.getValueAt(row, 4);
                String nameEmployer = (String) areaAssignmentEmployer.getValueAt(row, 5);

                String detailAddressId = this.detailAddressId.get(row);

                AssignmentEmpoylerModel changeAssignmentEmpoylerModel = new AssignmentEmpoylerModel(personId, namePerson, typeWater, detailAddress, employerId, nameEmployer, detailAddressId); // Thêm các thông tin còn lại của AssignmentEmpoylerModel

                // Thêm đối tượng AssignmentEmpoylerModel vào danh sách
                changeAssignmentEmpoylerModels.add(changeAssignmentEmpoylerModel);
            }

            try {
                DetailAssignmentCtrl.capNhatTatCaDuLieuThuocKhuVuc(roleCodeModel.getKeyCode(), assignmentEmpoylerModels, changeAssignmentEmpoylerModels, TimeSelect);
            } catch (Exception e) {
                // Xử lý ngoại lệ nếu có
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ngoài thời gian phân công, không được chỉnh sửa phân công !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_applyButtonActionPerformed

    private void areaAssignmentEmployerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaAssignmentEmployerMouseClicked
        // TODO add your handling code here:

        int selectedIndex = areaAssignmentEmployer.getSelectedRow();

        // Kiểm tra xem người dùng đã chọn một dòng hợp lệ hay không
        if (selectedIndex >= 0) {
            try {
                // Lấy đối tượng PersonModel từ danh sách listWorker

                AssignmentEmpoylerModel assignmentEmpoylerModel = assignmentEmpoylerModels.get(selectedIndex);

                DataGlobal.getDataGLobal.dataGlobal.setAssignmentEmpoylerModel(assignmentEmpoylerModel);

            } catch (IndexOutOfBoundsException ex) {
                // Xử lý ngoại lệ IndexOutOfBoundsException nếu chỉ số không hợp lệ
                Logger.getLogger(DetailAssignment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_areaAssignmentEmployerMouseClicked

    private void displayInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayInfoActionPerformed
        // TODO add your handling code here:

        selectTime();
        try {
            DetailAssignmentCtrl.timTatCaDuLieuThuocKhuVucTheoThoiGian(roleCodeModel.getKeyCode(), String.valueOf(listTimeAssignment.getSelectedItem()));
            hienThiDSPhanCong(roleCodeModel.getKeyCode(), TimeSelect);

        } catch (Exception ex) {
            Logger.getLogger(DetailAssignment.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_displayInfoActionPerformed

    private void listTimeAssignmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTimeAssignmentMouseClicked

    }//GEN-LAST:event_listTimeAssignmentMouseClicked

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
            java.util.logging.Logger.getLogger(DetailAssignment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailAssignment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailAssignment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailAssignment.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailAssignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JTable areaAssignmentEmployer;
    private javax.swing.JButton autoAssign;
    private javax.swing.JButton displayInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listTimeAssignment;
    private javax.swing.JLabel nameArea;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton updateAssignmentEmployUser;
    // End of variables declaration//GEN-END:variables
}
