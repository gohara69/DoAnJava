/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import java.util.ArrayList;
import model.PhieuDat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author VU HOANG
 */
public class PhieuDatDAO {
    public static boolean themPhieuNhap(PhieuDat pd){
        boolean kq = false;
        String sql = String.format("insert into PHIEUDAT(NV_ID, NCC_ID, PD_DATE, PD_TRANGTHAI)\n" +
                                   "values('%s',%d,'%s',0)", pd.getNV_ID(), pd.getNCC_ID(), pd.getPD_DATE());
        DataService ds = new DataService();
        ds.open();
        int n = ds.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        ds.close();
        return kq;
    }
    
    public static int layMaPhieuDatTiepTheo(){
        ArrayList<PhieuDat> dspd = new ArrayList<PhieuDat>();
        int id = 0;
        try {
            String sql = "Select TOP 1 PD_ID from PHIEUDAT order by PD_ID desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("PD_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return id + 1;
    }
}
