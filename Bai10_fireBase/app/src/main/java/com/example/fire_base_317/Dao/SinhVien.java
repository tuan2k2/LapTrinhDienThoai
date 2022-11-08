package com.example.fire_base_317.Dao;

public class SinhVien {
    private String id;
    private String MSV;
    private String TSV;
    private String Lop;
    private String Nganh;
    private String Khoa;

    public SinhVien(String id, String MSV, String TSV, String lop, String nganh, String khoa) {
        this.id = id;
        this.MSV = MSV;
        this.TSV = TSV;
        Lop = lop;
        Nganh = nganh;
        Khoa = khoa;
    }

    public SinhVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public String getTSV() {
        return TSV;
    }

    public void setTSV(String TSV) {
        this.TSV = TSV;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String nganh) {
        Nganh = nganh;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String khoa) {
        Khoa = khoa;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", MSV='" + MSV + '\'' +
                ", TSV='" + TSV + '\'' +
                ", Lop='" + Lop + '\'' +
                ", Nganh='" + Nganh + '\'' +
                ", Khoa='" + Khoa + '\'' +
                '}';
    }
}
