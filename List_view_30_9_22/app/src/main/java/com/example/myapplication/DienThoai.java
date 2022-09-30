package com.example.myapplication;

public class DienThoai {
    private String tenMay;
    private int img;

    public DienThoai() {
    }

    public DienThoai(String tenMay, int img) {
        this.tenMay = tenMay;
        this.img = img;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
