package com.example.kt1_317;

public class Casi {
    private String tenCaSi;
    private String tenNgheDanh;
    private int img;

    public Casi() {
    }

    public Casi(String tenCaSi, String tenNgheDanh, int img) {
        this.tenCaSi = tenCaSi;
        this.tenNgheDanh = tenNgheDanh;
        this.img = img;
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public String getTenNgheDanh() {
        return tenNgheDanh;
    }

    public void setTenNgheDanh(String tenNgheDanh) {
        this.tenNgheDanh = tenNgheDanh;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
