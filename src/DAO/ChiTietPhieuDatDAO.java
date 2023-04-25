/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import model.ChiTietPhieuDat;

/**
 *
 * @author VU HOANG
 */
public class ChiTietPhieuDatDAO {
    public static boolean themCTPhieuNhap(ChiTietPhieuDat ctpd){
        boolean kq = false;
        String sql = String.format("insert into CTPHIEUDAT " + 
                                    "values(%d, %d,%d,0)",ctpd.getPD_ID(), ctpd.getNL_ID(), ctpd.getSOLUONG());
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
