package com.example.btk2_317;

public class fishModel {
    String tenkhoahoc , tenthuonggoi , dactinh , mausac , hinhanh , hinhanhchichitiet ;

    public fishModel(String tenkhoahoc, String tenthuonggoi, String dactinh, String mausac, String hinhanh, String hinhanhchichitiet) {
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.dactinh = dactinh;
        this.mausac = mausac;
        this.hinhanh = hinhanh;
        this.hinhanhchichitiet = hinhanhchichitiet;
    }

    public fishModel() {
    }

    public fishModel(String tenkhoahoc, String tenthuonggoi, String hinhanh) {
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.hinhanh = hinhanh;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getHinhanhchichitiet() {
        return hinhanhchichitiet;
    }

    public void setHinhanhchichitiet(String hinhanhchichitiet) {
        this.hinhanhchichitiet = hinhanhchichitiet;
    }
}
