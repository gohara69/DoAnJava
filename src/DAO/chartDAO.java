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
import model.chartModel;

/**
 *
 * @author VU HOANG
 */
public class chartDAO {
    public static ArrayList<chartModel> getListChartModel(){
        ArrayList<chartModel> dsChartModel = new ArrayList<>();
        try {
            String sql = "Select TOP 12 DATEPART(YEAR, HDN_NGAYNHAP), DATENAME(MONTH, HDN_NGAYNHAP) AS 'MONTH', SUM(HDN_THANHTIEN) AS 'COST'\n" +
                        "from HOADONNHAP\n" +
                        "group by DATEPART(YEAR, HDN_NGAYNHAP), DATENAME(MONTH, HDN_NGAYNHAP)\n" +
                        "order by DATEPART(YEAR, HDN_NGAYNHAP) DESC, DATENAME(MONTH, HDN_NGAYNHAP) desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                chartModel cm = new chartModel();
                cm.setMonth(rs.getString("MONTH"));
                cm.setCost(rs.getLong("COST"));
                cm.setProfit(0);
                dsChartModel.add(cm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dsChartModel;
    }
    
    public static ArrayList<chartModel> layThongKe30NgayGanNhat(){
        ArrayList<chartModel> dsChartModel = new ArrayList<>();
        try {
            String sql = "select top 30 DATEPART(YEAR, HDN_NGAYNHAP), CONVERT(date, HDN_NGAYNHAP) AS 'DAY', SUM(HDN_THANHTIEN) AS 'COST'\n" +
                        "from HOADONNHAP\n" +
                        "group by DATEPART(YEAR, HDN_NGAYNHAP), CONVERT(date, HDN_NGAYNHAP)\n" +
                        "order by DATEPART(YEAR, HDN_NGAYNHAP) desc, CONVERT(date, HDN_NGAYNHAP) desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                chartModel cm = new chartModel();
                cm.setMonth(rs.getString("DAY").substring(8));
                cm.setCost(rs.getLong("COST"));
                cm.setProfit(0);
                dsChartModel.add(cm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dsChartModel;
    }
}
