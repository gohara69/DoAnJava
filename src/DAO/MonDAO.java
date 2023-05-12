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
public class MonDAO {
    public static ArrayList<Mon> layDanhSachMonAn() {
        ArrayList<Mon> ds_mon = new ArrayList<Mon>();
        try {
            String sql = "Select * from MON";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                Mon mon = new Mon();
                mon.setDanhMuc(rs.getInt("DM_ID"));
                mon.setTenMon(rs.getString("M_TEN"));
                mon.setGiaMon(rs.getInt("M_GIA"));
                mon.setSrcAnh(rs.getString("M_IMG"));
                
                ds_mon.add(mon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return ds_mon;
    }
}
