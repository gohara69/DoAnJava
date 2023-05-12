/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author VU HOANG
 */
public class Ban {
    private int B_SOBAN;
    private String B_VITRI;

    public Ban() {
    }

    public Ban(int B_SOBAN, String B_VITRI) {
        this.B_SOBAN = B_SOBAN;
        this.B_VITRI = B_VITRI;
    }

    public int getB_SOBAN() {
        return B_SOBAN;
    }

    public void setB_SOBAN(int B_SOBAN) {
        this.B_SOBAN = B_SOBAN;
    }

    public String getB_VITRI() {
        return B_VITRI;
    }

    public void setB_VITRI(String B_VITRI) {
        this.B_VITRI = B_VITRI;
    }
}
