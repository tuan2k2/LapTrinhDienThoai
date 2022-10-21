package com.example.btgk;

public class Phim {
    private String tenPhim;
    private String gthPhim;
    private int img;

    public Phim(String tenPhim, String gthPhim, int img) {
        this.tenPhim = tenPhim;
        this.gthPhim = gthPhim;
        this.img = img;
    }


    public Phim() {
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getGthPhim() {
        return gthPhim;
    }

    public void setGthPhim(String gthPhim) {
        this.gthPhim = gthPhim;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
