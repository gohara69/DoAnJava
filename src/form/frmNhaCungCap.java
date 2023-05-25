/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import DAO.NhaCungCapDAO;
import DAO.PhanQuyenDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import swing.scrollbar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.NhaCungCap;
import model.TaiKhoan;
import swing.table;

/**
 *
 * @author VU HOANG
 */
public class frmNhaCungCap extends javax.swing.JPanel {
     Vector data = new Vector();
     TaiKhoan tkhoan = main.main.tkhoan;


    public frmNhaCungCap() {
        initComponents();
        ///////
        sptable.setVerticalScrollBar(new scrollbar());
        sptable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        sptable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        sptable.setVerticalScrollBar(new scrollbar());
        txtID.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        txtDC.setText("");
        
        txtDC.setHint("");
        txtTen.setHint("");
        txtID.setHint("");
        txtSDT.setHint("");
        txtSearch1.setHint("Tìm kiếm nhà cung cấp theo tên");

        loadData();

        txtSearch1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                loadDataFromSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                loadDataFromSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                loadDataFromSearch();
            }

            public void loadDataFromSearch() {
             clear();
                data.removeAllElements();
                NhaCungCap a = new NhaCungCap();
                a.setNCC_TEN(txtSearch1.getText().trim());
                ArrayList<NhaCungCap> dsNcc = NhaCungCapDAO.timKiemTheoTen(a);
                for (NhaCungCap ncc : dsNcc) {
                    Vector info = new Vector();
                    info.add(ncc.getNCC_ID());
                    info.add(ncc.getNCC_TEN());
                    info.add(ncc.getNCC_DIACHI());
                    info.add(ncc.getNCC_SDT());
                    data.add(info);
                    tblNhaCungCap.addRow(info);
                }
            }
                 
        });
             
    }
    public void clear() {
        DefaultTableModel dtm = (DefaultTableModel) tblNhaCungCap.getModel();
        dtm.setRowCount(0);
    }
    public void loadData() {
        clear();
        data.removeAllElements();
        ArrayList<NhaCungCap> dsNcc = NhaCungCapDAO.layDanhSachNhaCungCap();
        for (NhaCungCap ncc : dsNcc) {
            Vector info = new Vector();
            info.add(ncc.getNCC_ID());
            info.add(ncc.getNCC_TEN());
            info.add(ncc.getNCC_SDT());
            info.add(ncc.getNCC_DIACHI());
            tblNhaCungCap.addRow(info);
            data.add(info);
        }
    }

    public void showDetail(int pos) {
        Vector info = (Vector) data.get(tblNhaCungCap.getSelectedRow());
        txtID.setText(info.get(0).toString());
        txtTen.setText(info.get(1).toString());
        txtSDT.setText(info.get(2).toString());
        txtDC.setText(info.get(3).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new swing.panelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelBorder1 = new swing.panelBorder();
        sptable = new javax.swing.JScrollPane();
        tblNhaCungCap = new swing.table();
        txtDC = new swing.searchText();
        txtTen = new swing.searchText();
        txtSDT = new swing.searchText();
        txtID = new swing.searchText();
        txtSearch1 = new swing.searchText();
        btnAdd = new swing.button();
        btnDelete = new swing.button();
        btnEdit = new swing.button();

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tên NCC :");

        jLabel3.setText("Địa Chỉ :");

        jLabel4.setText("SDT :");

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("ID :");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        sptable.setBorder(null);

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NCC_ID", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMousePressed(evt);
            }
        });
        tblNhaCungCap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblNhaCungCapKeyReleased(evt);
            }
        });
        sptable.setViewportView(tblNhaCungCap);
        if (tblNhaCungCap.getColumnModel().getColumnCount() > 0) {
            tblNhaCungCap.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sptable)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sptable, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtID.setEditable(false);
        txtID.setText("         ");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))))
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhaCungCapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblNhaCungCapKeyReleased
        // TODO add your handling code here:
         showDetail(((table) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblNhaCungCapKeyReleased

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
        // TODO add your handling code here:
         showDetail(((table) evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void tblNhaCungCapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMousePressed
        // TODO add your handling code here:
        int pos = tblNhaCungCap.getSelectedRow();
        showDetail(pos);
        txtID.setEnabled(false);
    }//GEN-LAST:event_tblNhaCungCapMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(!PhanQuyenDAO.kiemTraCoQuyenThaoTacNhaCungCap(tkhoan)){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền thao tác", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (txtTen.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp để thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int lastIndex = tblNhaCungCap.getRowCount();
        try {
            NhaCungCap ncc = new NhaCungCap();
            ncc.setNCC_ID(NhaCungCapDAO.layMaNhaCungCapTiepTheo());
            ncc.setNCC_TEN(txtTen.getText().trim());
            ncc.setNCC_SDT(txtSDT.getText());
            ncc.setNCC_DIACHI(txtDC.getText());
            NhaCungCapDAO.themNhaCungCap(ncc);
            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không thêm được nhà cung cấp", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(!PhanQuyenDAO.kiemTraCoQuyenThaoTacNhaCungCap(tkhoan)){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền thao tác", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int pos = tblNhaCungCap.getSelectedRow();
        if (pos >= 0 && JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhà cung cấp này", "Thông báo", JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION) {
            NhaCungCap ncc = new NhaCungCap();
            int selectedID = (int) tblNhaCungCap.getValueAt(pos, 0);
            ncc.setNCC_ID(selectedID);
            if (NhaCungCapDAO.xoaNhaCungCap(ncc)) {
                JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);

            }
        }
        loadData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(!PhanQuyenDAO.kiemTraCoQuyenThaoTacNhaCungCap(tkhoan)){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền thao tác", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (txtTen.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp để sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        NhaCungCap ncc = new NhaCungCap();
        ncc.setNCC_ID(Integer.valueOf(txtID.getText()));
        ncc.setNCC_TEN(txtTen.getText());
        ncc.setNCC_SDT(txtSDT.getText());
        ncc.setNCC_DIACHI(txtDC.getText());
        if (NhaCungCapDAO.capNhatNhaCungCap(ncc)) {
            JOptionPane.showMessageDialog(this, "Cập nhật nhà cung  thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật nhà cung cấp không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        loadData();
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.button btnAdd;
    private swing.button btnDelete;
    private swing.button btnEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private swing.panelBorder panelBorder1;
    private swing.panelBorder panelBorder2;
    private javax.swing.JScrollPane sptable;
    private swing.table tblNhaCungCap;
    private swing.searchText txtDC;
    private swing.searchText txtID;
    private swing.searchText txtSDT;
    private swing.searchText txtSearch1;
    private swing.searchText txtTen;
    // End of variables declaration//GEN-END:variables

}
