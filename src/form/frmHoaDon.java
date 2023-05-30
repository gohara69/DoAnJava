/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import DAO.BanDAO;
import DAO.HoaDonDAO;
import DAO.NguyenLieuDAO;
import DAO.NhanVienDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.NguyenLieu;
import model.TableHoaDon;
import swing.scrollbar;

/**
 *
 * @author VU HOANG
 */
public class frmHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form frmHoaDon
     */
    Vector data = new Vector();

    public frmHoaDon() {
        initComponents();
        spTable.setVerticalScrollBar(new scrollbar());
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        spTable.setVerticalScrollBar(new scrollbar());
        loadDataTable();
        loadDataOnComboboxTable();
        loadDataOnComboboxEmployees();
    }

    public void loadData(ArrayList<TableHoaDon> listBill) {
        clear();
        data.removeAllElements();
        for (TableHoaDon hd : listBill) {
            Vector info = new Vector();
            info.add(hd.getMaHoaDon());
            info.add(hd.getTenNhanVien());
            info.add(hd.getSoBan());
            info.add(hd.getThanhTien());
            info.add(hd.getNgayXuatHD());
            info.add(hd.getTrangThai());
            tblHoaDon.addRow(info);
            data.add(info);
        }
    }
    
    public void loadDataTable(){
        ArrayList<TableHoaDon> dshd = HoaDonDAO.getListBill();
        loadData(dshd);
    }

    public void clear() {
        DefaultTableModel dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm.setRowCount(0);
    }
    
    public void loadDataOnComboboxTable(){
        ArrayList<Integer> list_numberTable = BanDAO.getAllNumberTable();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("None");
        for(int i : list_numberTable){
            model.addElement(String.valueOf(i));
        }
        cbxBan.setModel(model);
    }
    
    public void loadDataOnComboboxEmployees(){
        ArrayList<String> list_nameEmployee = NhanVienDAO.layTenNhanVien();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("None");
        for(String name : list_nameEmployee){
            model.addElement(name);
        }
        cbxNhanVien.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxBan = new javax.swing.JComboBox<>();
        cbxNhanVien = new javax.swing.JComboBox<>();
        cbxTinhTrang = new javax.swing.JComboBox<>();
        panelBorder3 = new swing.panelBorder();
        spTable = new javax.swing.JScrollPane();
        tblHoaDon = new swing.table();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        cbxBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxBan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBanItemStateChanged(evt);
            }
        });

        cbxNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNhanVienItemStateChanged(evt);
            }
        });

        cbxTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Chưa thanh toán", "Đã thanh toán" }));
        cbxTinhTrang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTinhTrangItemStateChanged(evt);
            }
        });

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        tblHoaDon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Tên nhân viên", "Số bàn", "Thành tiền", "Ngày xuất hóa đơn", "Trạng thái"
            }
        ));
        spTable.setViewportView(tblHoaDon);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Bàn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tình trạng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxBan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxBan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxBanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBanItemStateChanged
        Object soBan = cbxBan.getSelectedItem();
        ArrayList<TableHoaDon> dshd = HoaDonDAO.getListBillByNumberTable(Integer.valueOf(soBan.toString()));
        loadData(dshd);
    }//GEN-LAST:event_cbxBanItemStateChanged

    private void cbxNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNhanVienItemStateChanged
        Object name = cbxNhanVien.getSelectedItem();
        ArrayList<TableHoaDon> dshd = HoaDonDAO.getListBillByNameEmployee(name.toString());
        loadData(dshd);
    }//GEN-LAST:event_cbxNhanVienItemStateChanged

    private void cbxTinhTrangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTinhTrangItemStateChanged
        Object status = cbxTinhTrang.getSelectedItem();
        if(status.toString().equals("Chưa thanh toán"))
            status = "0";
        else
            status = "1";
        ArrayList<TableHoaDon> dshd = HoaDonDAO.getListBillByStatusBill(status.toString());
        loadData(dshd);
    }//GEN-LAST:event_cbxTinhTrangItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxBan;
    private javax.swing.JComboBox<String> cbxNhanVien;
    private javax.swing.JComboBox<String> cbxTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private swing.panelBorder panelBorder3;
    private javax.swing.JScrollPane spTable;
    private swing.table tblHoaDon;
    // End of variables declaration//GEN-END:variables
}
