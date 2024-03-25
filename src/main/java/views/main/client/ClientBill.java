package views.main.client;

import controllers.Client.ClientCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Client.ClientBillModel;
import models.Client.ClientHouseholdModel;
/**
 *
 * @author Phu Bao
 */
public class ClientBill extends javax.swing.JPanel {

    /**
     * Creates new form ClientBills
     */
    DefaultTableModel tableModel;
    List<ClientBillModel> dsHoaDon = new ArrayList<>();
    private List<ClientHouseholdModel> dsCacHo;
    private String maHo = null;

    public ClientBill() {
        initComponents();
        tableModel = (DefaultTableModel) tblDanhSachHoaDon.getModel();
        try {
            hienThiHoaDon();
            hienThiDSCacHo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSCacHo() {
        try {
            dsCacHo = ClientCtrl.hienThiCacHoDangSuDungDichVu();
            cboDSCacHo.removeAllItems();
            cboDSCacHo.addItem("--Tất cả--");
            dsCacHo.forEach(ho -> {
                String diaChi = ho.getNameDetailAddress();
                cboDSCacHo.addItem(diaChi);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiHoaDon() throws ClassNotFoundException {
        dsHoaDon = ClientCtrl.hienThiHoaDon();
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getCollectMoneyId(), hd.getEmployCollectID(), hd.getUserID(), hd.getPreIndex(),
                hd.getCurrentIndex(), hd.getTimeCollect(), hd.getMoneyToPay(), hd.getNameAddressCollect()});
        });
    }

    private void hienThiHoaDonTheoDiaChi(String maHo) throws ClassNotFoundException {
        dsHoaDon = ClientCtrl.hienThiHoaDonTheoDiaChi(maHo);
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getCollectMoneyId(), hd.getEmployCollectID(), hd.getUserID(), hd.getPreIndex(),
                hd.getCurrentIndex(), hd.getTimeCollect(), hd.getMoneyToPay(), hd.getNameAddressCollect()});
        });
    }

    private void hienThiHoaDon_TangDanTheoGiaTien(List<ClientBillModel> list) throws ClassNotFoundException {
        dsHoaDon = ClientCtrl.sapXepTheoTienTangDan(list);
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getCollectMoneyId(), hd.getEmployCollectID(), hd.getUserID(), hd.getPreIndex(),
                hd.getCurrentIndex(), hd.getTimeCollect(), hd.getMoneyToPay(), hd.getNameAddressCollect()});
        });
    }

    private void hienThiHoaDon_GiamDanTheoGiaTien(List<ClientBillModel> list) throws ClassNotFoundException {
        dsHoaDon = ClientCtrl.sapXepTheoTienGiamDan(list);
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getCollectMoneyId(), hd.getEmployCollectID(), hd.getUserID(), hd.getPreIndex(),
                hd.getCurrentIndex(), hd.getTimeCollect(), hd.getMoneyToPay(), hd.getNameAddressCollect()});
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cboSapXep = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboDSCacHo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCollectMoneyID = new javax.swing.JTextField();
        txtEmployeeName = new javax.swing.JTextField();
        txtPrevIndex = new javax.swing.JTextField();
        txtCurrentIndex = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMoneyToPay = new javax.swing.JTextField();
        txtAmountWater = new javax.swing.JTextField();
        txtMoneyCategory = new javax.swing.JTextField();
        txtNameAddressCollect = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(134, 140, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hóa đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnRefresh.setBackground(new java.awt.Color(51, 102, 255));
        btnRefresh.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Mã chủ hộ", "Chỉ số trước", "Chỉ số sau", "Ngày ghi nước", "Số tiền", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachHoaDon);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("DANH SÁCH CÁC HÓA ĐƠN");

        cboSapXep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Tăng dần theo giá tiền", "Giảm dần theo giá tiền" }));
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Sắp xếp:");

        cboDSCacHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboDSCacHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDSCacHoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Chọn hộ:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboDSCacHo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboDSCacHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Tên nhân viên thu tiền");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Chỉ số trước");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Chỉ số sau");
        jLabel4.setToolTipText("");

        txtCollectMoneyID.setEditable(false);
        txtCollectMoneyID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmployeeName.setEditable(false);
        txtEmployeeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPrevIndex.setEditable(false);
        txtPrevIndex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCurrentIndex.setEditable(false);
        txtCurrentIndex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("Số nước");
        jLabel6.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Loại tiền nước");
        jLabel5.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setText("Địa chỉ thu tiền");
        jLabel8.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("Số tiền đã trả");
        jLabel7.setToolTipText("");

        txtMoneyToPay.setEditable(false);
        txtMoneyToPay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMoneyToPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoneyToPayActionPerformed(evt);
            }
        });

        txtAmountWater.setEditable(false);
        txtAmountWater.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAmountWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountWaterActionPerformed(evt);
            }
        });

        txtMoneyCategory.setEditable(false);
        txtMoneyCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNameAddressCollect.setEditable(false);
        txtNameAddressCollect.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNameAddressCollect.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNameAddressCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameAddressCollectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrevIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCurrentIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCollectMoneyID, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMoneyCategory)
                    .addComponent(txtAmountWater)
                    .addComponent(txtMoneyToPay)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtNameAddressCollect, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNameAddressCollect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMoneyCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAmountWater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMoneyToPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCollectMoneyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrevIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCurrentIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonMouseClicked
        // TODO add your handling code here:
        refresh();
        int selectedIndex = tblDanhSachHoaDon.getSelectedRow();
        if (selectedIndex >= 0) {
            ClientBillModel bill = dsHoaDon.get(selectedIndex);
            txtCollectMoneyID.setText(bill.getCollectMoneyId());
            txtEmployeeName.setText(bill.getNameEmployee());
            txtPrevIndex.setText(String.valueOf(bill.getPreIndex()));
            txtCurrentIndex.setText(String.valueOf(bill.getCurrentIndex()));
            txtNameAddressCollect.setText(bill.getNameAddressCollect());
            int amountOfWater = bill.getCurrentIndex() - bill.getPreIndex();
            txtAmountWater.setText(String.valueOf(amountOfWater));
            txtMoneyCategory.setText(bill.getNameMoneyCategory());
            txtMoneyToPay.setText(String.valueOf(bill.getMoneyToPay()));
        } else {
            System.out.println("Chưa có dòng nào được chọn");
        }

    }//GEN-LAST:event_tblDanhSachHoaDonMouseClicked

    private void refresh() {
        txtCollectMoneyID.setText("");
        txtCurrentIndex.setText("");
        txtEmployeeName.setText("");
        txtMoneyCategory.setText("");
        txtMoneyToPay.setText("");
        txtPrevIndex.setText("");
        txtCollectMoneyID.setText("");
        txtNameAddressCollect.setText("");
        txtAmountWater.setText("");

    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
        try {
            hienThiHoaDon();
            cboDSCacHo.setSelectedIndex(0);
            cboSapXep.setSelectedIndex(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtAmountWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountWaterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountWaterActionPerformed

    private void cboDSCacHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDSCacHoActionPerformed
        // TODO add your handling code here:
        if (cboDSCacHo.getSelectedIndex() == 0) {
            try {
                hienThiHoaDon();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int index = cboDSCacHo.getSelectedIndex();
            maHo = dsCacHo.get(index - 1).getDetailAddressId();
            System.out.println(maHo);
            if (maHo != null) {
                try {
                    hienThiHoaDonTheoDiaChi(maHo);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cboDSCacHoActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
        switch (cboSapXep.getSelectedIndex()) {
            case 0 -> {
                try {
                    if (cboDSCacHo.getSelectedIndex() == 0) {
                        hienThiHoaDon();
                    } else {
                        hienThiHoaDonTheoDiaChi(maHo);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 1 -> {
                try {
                    hienThiHoaDon_TangDanTheoGiaTien(dsHoaDon);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2 -> {
                try {
                    hienThiHoaDon_GiamDanTheoGiaTien(dsHoaDon);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            default -> {
            }
        }
    }//GEN-LAST:event_cboSapXepActionPerformed

    private void txtNameAddressCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameAddressCollectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameAddressCollectActionPerformed

    private void txtMoneyToPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoneyToPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoneyToPayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cboDSCacHo;
    private javax.swing.JComboBox<String> cboSapXep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSachHoaDon;
    private javax.swing.JTextField txtAmountWater;
    private javax.swing.JTextField txtCollectMoneyID;
    private javax.swing.JTextField txtCurrentIndex;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtMoneyCategory;
    private javax.swing.JTextField txtMoneyToPay;
    private javax.swing.JTextField txtNameAddressCollect;
    private javax.swing.JTextField txtPrevIndex;
    // End of variables declaration//GEN-END:variables
}
