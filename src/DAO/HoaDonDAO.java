/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import form.frmChonMon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.Ban;
import model.HoaDon;

/**
 *
 * @author PC
 */
public class HoaDonDAO {
    public static boolean addBill(HoaDon hd){
        boolean kq = false;
        String sql = "INSERT INTO HOADON(HD_ID, NV_ID, B_SOBAN, HD_THANHTIEN, HD_NGAYXUAT, HD_TrangThai) values ("+hd.getMaHD()+", '"+hd.getMaNV()+"', "+hd.getSoBan()+", "+hd.getThanhTien()+", '"+hd.getNgayXuatHD()+"', '"+hd.isTrangThai()+"')";
        DataService ds = new DataService();
        ds.open();
            int n = ds.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        ds.close();
        return kq;
    }
    public static int layMaHoaDonTiepTheo(){
        ArrayList<HoaDon> dshd = new ArrayList<>();
        int id = 0;
        try {
            String sql = "Select TOP 1 HD_ID from HOADON order by HD_ID desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("HD_ID");
            }
        } catch (Exception e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return id + 1;
    }
    public static int layDonGiaHoaDon(int soBan){
        int donGia = 0;
        try {
            String sql = "select HD_THANHTIEN from HOADON where B_SOBAN = "+soBan+" and HD_TrangThai = 'False'";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while (rs.next()) {
                donGia = rs.getInt("HD_THANHTIEN");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donGia;
    }
    public static int layMaHoaDonTheoBan(int soBan){
        int maHoaDon = 0;
        try {
            String sql = "select HD_ID from HOADON where B_SOBAN = "+soBan+" and HD_TrangThai = 'False'";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while (rs.next()) {
                maHoaDon = rs.getInt("HD_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maHoaDon;
    }
}
