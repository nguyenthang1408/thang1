package com.example.hp8440p.myapplication.Oject;

public class NoiDung {
    public NoiDung() {
    }

    public int getIdNoiDung() {

        return IdNoiDung;
    }

    public void setIdNoiDung(int idNoiDung) {
        IdNoiDung = idNoiDung;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public NoiDung(String noiDung, String soTien, String theLoai, String ngay, String ghiChu) {

        NoiDung = noiDung;
        SoTien = soTien;
        TheLoai = theLoai;
        Ngay = ngay;
        GhiChu = ghiChu;
    }
//day
    private int IdNoiDung;
    private String NoiDung;
    private String SoTien;
    private String TheLoai;
    private String Ngay;
    private String GhiChu;

}
