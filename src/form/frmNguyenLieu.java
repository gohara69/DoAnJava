/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

/**
 *
 * @author VU HOANG
 */
public class frmNguyenLieu extends javax.swing.JPanel {

    /**
     * Creates new form frmNguyenLieu
     */
    public frmNguyenLieu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDatNguyenLieu = new swing.button();
        btnNhapNguyenLieu = new swing.button();

        btnDatNguyenLieu.setText("Đặt nguyên liệu");
        btnDatNguyenLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatNguyenLieuActionPerformed(evt);
            }
        });

        btnNhapNguyenLieu.setText("Nhập nguyên liệu");
        btnNhapNguyenLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapNguyenLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(597, Short.MAX_VALUE)
                .addComponent(btnNhapNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnDatNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(497, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatNguyenLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatNguyenLieuActionPerformed
        frmDatNguyenLieu frm = new frmDatNguyenLieu();
        frm.setVisible(true);
        frm.setLocation(310, 85);
    }//GEN-LAST:event_btnDatNguyenLieuActionPerformed

    private void btnNhapNguyenLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapNguyenLieuActionPerformed
        frmNhapNguyenLieu frm = new frmNhapNguyenLieu();
        frm.setVisible(true);
        frm.setLocation(310, 85);
    }//GEN-LAST:event_btnNhapNguyenLieuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.button btnDatNguyenLieu;
    private swing.button btnNhapNguyenLieu;
    // End of variables declaration//GEN-END:variables
}
