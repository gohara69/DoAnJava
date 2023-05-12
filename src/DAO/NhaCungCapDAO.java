/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import java.util.ArrayList;
import pojo.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.PhieuDat;

/**
 *
 * @author VU HOANG
 */
public class NhaCungCapDAO {
     public static ArrayList<NhaCungCap> layDanhSachNhaCungCap() {
        ArrayList<NhaCungCap> dsNcc = new ArrayList<>();
        try {
            String sql = "Select * from NHACUNGCAP";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setNCC_ID(rs.getInt("NCC_ID"));
                ncc.setNCC_TEN(rs.getString("NCC_TEN"));
                ncc.setNCC_SDT(rs.getString("NCC_SDT"));
                ncc.setNCC_DIACHI(rs.getString("NCC_DIACHI"));

                dsNcc.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dsNcc;
    }
     
     public static String layTenNhaCungCapTheoMaPhieuDat(PhieuDat pd){
         String kq = "";
         try {
            String sql = "select NCC_TEN\n" +
                        " from NHACUNGCAP ncc, PHIEUDAT pd\n" +
                        " where ncc.NCC_ID = pd.NCC_ID and PD_ID = " + pd.getPD_ID();
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                kq = rs.getString("NCC_TEN");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return kq;
     }
}
