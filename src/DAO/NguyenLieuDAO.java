/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataService.DataService;
import java.util.ArrayList;
import model.NguyenLieu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhaCungCap;

/**
 *
 * @author VU HOANG
 */
public class NguyenLieuDAO {
    public static ArrayList<NguyenLieu> searchIngredientById (NguyenLieu nl, int nccId) {
        ArrayList<NguyenLieu> dsdm = new ArrayList<>();
        try {
            String sql = "select top 1 NGUYENLIEU.NL_ID, NL_TEN, NL_DONVITINH, NL_GIA\n" +
                        "from NGUYENLIEU, GIANGUYENLIEU\n" +
                        "where NGUYENLIEU.NL_ID = GIANGUYENLIEU.NL_ID and NGUYENLIEU.NL_ID = " + nl.getNL_ID()
                        + " and NCC_ID = " + nccId + " order by NGAYTHAYDOI desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                NguyenLieu nlieu = new NguyenLieu();
                nlieu.setNL_ID(rs.getInt("NL_ID"));
                nlieu.setNL_TEN(rs.getString("NL_TEN"));
                nlieu.setNL_DONVITINH(rs.getString("NL_DONVITINH"));
                nlieu.setNL_GIA(rs.getFloat("NL_GIA"));
                
                dsdm.add(nlieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsdm;
    }
    
    public static boolean isThisIngredientById (NguyenLieu nl) {
        ArrayList<NguyenLieu> dsdm = new ArrayList<>();
        try {
            String sql = "select * from NguyenLieu where NL_ID = " + nl.getNL_ID()+ "";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static NguyenLieu searchIngredientById (NguyenLieu nl) {
        NguyenLieu a = new NguyenLieu();
        try {
            String sql = "select nl.NL_ID, NL_TEN, NL_DONVITINH, NL_GIA \n" +
                        "from NGUYENLIEU nl, GIANGUYENLIEU gnl \n" +
                        "where nl.NL_ID = gnl.NL_ID and nl.NL_ID = " + nl.getNL_ID();
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                a.setNL_DONVITINH(rs.getString("NL_DONVITINH"));
                a.setNL_GIA(rs.getFloat("NL_GIA"));
                a.setNL_ID(rs.getInt("NL_ID"));
                a.setNL_TEN(rs.getString("NL_TEN"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public static ArrayList<Integer> searchIngredientByNCCId (NhaCungCap ncc) {
        ArrayList<Integer> dsnl = new ArrayList<>();
        try {
            String sql = "select distinct NL_ID from NGUYENLIEU where NCC_ID = " + ncc.getNCC_ID();
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                dsnl.add(rs.getInt("NL_ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsnl;
    }
    
    public static ArrayList<NguyenLieu> searchIngredientNameByNCCId (NhaCungCap ncc) {
        ArrayList<NguyenLieu> dsnl = new ArrayList<>();
        try {
            String sql = "select distinct NGUYENLIEU.NL_ID ,NL_TEN from GIANGUYENLIEU, NGUYENLIEU where " + 
                    "GIANGUYENLIEU.NL_ID = NGUYENLIEU.NL_ID and NCC_ID = " + ncc.getNCC_ID();
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                NguyenLieu nl = new NguyenLieu();
                nl.setNL_ID(rs.getInt("NL_ID"));
                nl.setNL_TEN(rs.getString("NL_TEN"));
                
                dsnl.add(nl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsnl;
    }
    
     public static Float searchIngredientPriceById (NguyenLieu nl) {
        ArrayList<Float> dsGia = new ArrayList<>();
        try {
            String sql = "select TOP 1 NL_GIA from GIANGUYENLIEU where NL_ID = " + nl.getNL_ID() + " order by NGAYTHAYDOI desc";
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()){
                dsGia.add(rs.getFloat("NL_GIA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsGia.get(0);
    }
}
