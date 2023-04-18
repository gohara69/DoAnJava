/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import DAO.DanhMucDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.DanhMuc;
import swing.table;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import swing.scrollbar;

/**
 *
 * @author VU HOANG
 */
public class frmDanhMuc extends javax.swing.JPanel {

    /**
     * Creates new form frmDanhMuc
     */
    public frmDanhMuc() {
        initComponents();
        txtSearch.setHint("Tìm kiếm theo tên ... ");
        txtDanhMucID.setHint("");
        txtTenDanhMuc.setHint("");
        //Thiết kế phần cuối table không bị xám
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        jScrollPane1.setVerticalScrollBar(new scrollbar());
        loadData();
        txtSearch.getDocument().addDocumentListener(new DocumentListener(){
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
            
            public void loadDataFromSearch(){
                clear();
                DanhMuc a = new DanhMuc();
                a.setDM_TEN(txtSearch.getText().trim());
                ArrayList<DanhMuc> dsDM = DanhMucDAO.timKiemDanhMucTheoTen(a);
                for(DanhMuc dm: dsDM){
                    Vector info = new Vector();
                    info.add(dm.getDM_ID());
                    info.add(dm.getDM_TEN());

                    tblDanhMuc.addRow(info);
                }
            }
        });  
    }
    
    public void clear(){
        DefaultTableModel dtm = (DefaultTableModel) tblDanhMuc.getModel();
        dtm.setRowCount(0);
    }

    public void loadData(){
        clear();
        ArrayList<DanhMuc> dsDM = DanhMucDAO.layDanhSachDanhMuc();
        for(DanhMuc dm: dsDM){
            Vector info = new Vector();
            info.add(dm.getDM_ID());
            info.add(dm.getDM_TEN());
            
            tblDanhMuc.addRow(info);
        }
    }
    
    public void showDetail(int pos){
        int id = (int) tblDanhMuc.getValueAt(pos, 0);
        String tenDm = (String) tblDanhMuc.getValueAt(pos, 1);
        
        txtDanhMucID.setText(id + "");
        txtTenDanhMuc.setText(tenDm);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelBorder1 = new swing.panelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhMuc = new swing.table();
        txtSearch = new swing.searchText();
        txtDanhMucID = new swing.searchText();
        txtTenDanhMuc = new swing.searchText();
        btnXoa = new swing.button();
        btnThem = new swing.button();
        btnSua = new swing.button();

        setMinimumSize(new java.awt.Dimension(910, 550));
        setPreferredSize(new java.awt.Dimension(910, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã danh mục");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên danh mục");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã danh mục", "Tên danh mục"
            }
        ));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        tblDanhMuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDanhMucKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhMuc);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 890, 430));

        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, 470, 40));

        txtDanhMucID.setEnabled(false);
        add(txtDanhMucID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, -1));
        add(txtTenDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 350, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, 30));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, 30));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
        
    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void tblDanhMucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDanhMucKeyReleased
        showDetail(((table)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblDanhMucKeyReleased

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        showDetail(((table)evt.getSource()).getSelectedRow());
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       int pos = tblDanhMuc.getSelectedRow();
        if(pos >= 0 && JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa danh mục này", "Thông báo", JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION) {
            DanhMuc dm = new DanhMuc();
            int selectedID = (int) tblDanhMuc.getValueAt(pos, 0);
            dm.setDM_ID(selectedID);

            if(DanhMucDAO.xoaDanhMuc(dm)) {
                JOptionPane.showMessageDialog(this, "Xóa danh mục thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa danh mục không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        loadData();
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(txtTenDanhMuc.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên danh mục để thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        loadData();
        int lastIndex = tblDanhMuc.getRowCount();
        int lastID = (int) tblDanhMuc.getValueAt(lastIndex - 1, 0);
        try {
            DanhMuc dm = new DanhMuc();
            dm.setDM_ID(lastID + 1);
            dm.setDM_TEN(txtTenDanhMuc.getText().trim());
            DanhMucDAO.themDanhMuc(dm);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Không thêm được danh mục", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        loadData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if(txtTenDanhMuc.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên danh mục để sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int pos = tblDanhMuc.getSelectedRow();
        if(pos >= 0){
            DanhMuc dm = new DanhMuc();
            int selectedID = (int) tblDanhMuc.getValueAt(pos, 0);
            dm.setDM_ID(selectedID);
            dm.setDM_TEN(txtTenDanhMuc.getText().trim());
            
            if(DanhMucDAO.capNhatDanhMuc(dm)) {
                JOptionPane.showMessageDialog(this, "Cập nhật danh mục thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật danh mục không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        loadData();
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.button btnSua;
    private swing.button btnThem;
    private swing.button btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.panelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private swing.table tblDanhMuc;
    private swing.searchText txtDanhMucID;
    private swing.searchText txtSearch;
    private swing.searchText txtTenDanhMuc;
    // End of variables declaration//GEN-END:variables
}
