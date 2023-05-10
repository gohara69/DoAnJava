/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Order {
    private String tenMon;
    private int idHoaDon, soLuong, giaTien;

    public Order(String tenMon, int idHoaDon, int soLuong, int giaTien) {
        this.tenMon = tenMon;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
    
}
