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
import model.NhanVien;
import model.PhieuDat;
import model.TaiKhoan;

/**
 *
 * @author VU HOANG
 */
public class NhanVienDAO {
     public static NhanVien layNhanVien(NhanVien nv){
        NhanVien nvien = new NhanVien();
        try {
            String sql = String.format("SELECT * FROM NHANVIEN WHERE NV_ID = '%s'", nv.getNV_ID());
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            int id;
            while(rs.next()) {
                nvien.setNV_DIACHI(rs.getString("NV_DIACHI"));
                nvien.setNV_GIOITINH(rs.getBoolean("NV_GIOITINH"));
                nvien.setNV_ID(rs.getString("NV_ID"));
                nvien.setNV_IMG(rs.getString("NV_IMG"));
                nvien.setNV_NGAYSINH(rs.getString("NV_NGAYSINH"));
                nvien.setNV_SDT(rs.getString("NV_SDT"));
                nvien.setNV_TEN(rs.getString("NV_TEN"));
                nvien.setNV_TINHTRANG(rs.getString("NV_TINHTRANG"));
                nvien.setQA_DIACHI(rs.getString("QA_DIACHI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nvien;
    }
     
     public static NhanVien layNhanVienTheoTaiKhoan(TaiKhoan tk){
        NhanVien nvien = new NhanVien();
        try {
            String sql = String.format("select * \n" +
                                    "from NHANVIEN, TAIKHOAN\n" +
                                    "where NHANVIEN.NV_ID = TAIKHOAN.TK_NV and TK_ID = %d", tk.getTK_ID());
            DataService ds = new DataService();
            ds.open();
            ResultSet rs = ds.executeQuery(sql);
            while(rs.next()) {
                nvien.setNV_DIACHI(rs.getString("NV_DIACHI"));
                nvien.setNV_GIOITINH(rs.getBoolean("NV_GIOITINH"));
                nvien.setNV_ID(rs.getString("NV_ID"));
                nvien.setNV_IMG(rs.getString("NV_IMG"));
                nvien.setNV_NGAYSINH(rs.getString("NV_NGAYSINH"));
                nvien.setNV_SDT(rs.getString("NV_SDT"));
                nvien.setNV_TEN(rs.getString("NV_TEN"));
                nvien.setNV_TINHTRANG(rs.getString("NV_TINHTRANG"));
                nvien.setQA_DIACHI(rs.getString("QA_DIACHI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nvien;
    }
}
