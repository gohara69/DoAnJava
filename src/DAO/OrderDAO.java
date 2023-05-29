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
import model.Ban;
import model.Mon;
import model.Order;
import model.ModelButtonFood;

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
    
    public static boolean removeOrder(String tenMon, int maHoaDon) {
        boolean kq = false;
        String sql = "delete from [ORDER] Where M_TEN = N'"+tenMon+"' and HD_ID = " + maHoaDon;
        DataService ds = new DataService();
        ds.open();
        int n = ds.executeUpdate(sql);
        if(n == 1){
            kq = true;
        }
        ds.close();
        return kq;
    }
    
    public static ArrayList<ModelButtonFood> getListFoodOrdered(int soBan){
        ArrayList<ModelButtonFood> ds_order = new ArrayList<ModelButtonFood>();
        try {
            String sql = "select * from [ORDER] od, HOADON hd, MON m where od.HD_ID = hd.HD_ID and od.M_TEN = m.M_TEN and hd.B_SOBAN = "+soBan+" and hd.HD_TrangThai = 'False'";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while (rs.next()) {
                ModelButtonFood model = new ModelButtonFood();
                model.setTenMon(rs.getString("M_TEN"));
                model.setSrcAnh(rs.getString("M_IMG"));
                model.setSoLuong(rs.getInt("O_SOLUONG"));
                model.setGia(rs.getInt("M_GIA"));
                ds_order.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds_order;
    }
}
