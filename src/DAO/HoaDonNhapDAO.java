/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.HoaDonNhap;

/**
 *
 * @author VU HOANG
 */
public class HoaDonNhapDAO {
    public static int layMaHoaDonNhapTiepTheo(){
        int id = 0;
        try {
            String sql = "Select TOP 1 HDN_ID from HOADONNHAP order by HDN_ID desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("HDN_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return id + 1;
    }
    
    public static boolean themHoaDonNhap(HoaDonNhap hd){
        boolean kq = false;
        String sql = String.format("insert into HOADONNHAP " + 
                                    "values(%d,'%s',GETDATE(),0,%d)", hd.getHDN_ID(), hd.getNV_ID(), hd.getPD_ID());
        DataService ds = new DataService();
        ds.open();
        int n = ds.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        ds.close();
        return kq;
    }
}