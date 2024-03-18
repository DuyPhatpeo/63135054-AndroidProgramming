package com.example.lvnangcao.models;

public class Country {
    String tenQG;
    int soLuongDan;
    String tenFileAnhLaCo;

    public Country(String tenQG, int soLuongDan, String tenFileAnhLaCo) {
        this.tenQG = tenQG;
        this.soLuongDan = soLuongDan;
        this.tenFileAnhLaCo = tenFileAnhLaCo;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }

    public int getSoLuongDan() {
        return soLuongDan;
    }

    public void setSoLuongDan(int soLuongDan) {
        this.soLuongDan = soLuongDan;
    }

    public String getTenFileAnhLaCo() {
        return tenFileAnhLaCo;
    }

    public void setTenFileAnhLaCo(String tenFileAnhLaCo) {
        this.tenFileAnhLaCo = tenFileAnhLaCo;
    }
}
