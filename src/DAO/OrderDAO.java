/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mon;

/**
 *
 * @author PC
 */
public class OrderDAO {
    public static boolean addOrder(Mon mon, int soLuong, int id_hoaDon, String ghiChu) {
        boolean kq = false;
        String sql = "insert into [ORDER] (M_TEN, HD_ID, O_SOLUONG, O_GIA, O_GHICHU) "
                + "values (N'"+mon.getTenMon()+"', "+id_hoaDon+", "+soLuong+", "+mon.getGiaMon()+", N'"+ghiChu+"')";
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
