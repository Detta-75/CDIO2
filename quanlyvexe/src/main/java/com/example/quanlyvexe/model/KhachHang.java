package com.example.quanlyvexe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "khach_hang")
public class KhachHang {

    @Id
    @Column(name = "id_khach_hang")
    private String idKhachHang;

    @Column(name = "ten_khach_hang", nullable = false)
    private String tenKhachHang;

    @Column(name = "sdt", nullable = false)
    private String sdt;

    public KhachHang() {
    }

    public KhachHang(String idKhachHang, String tenKhachHang, String sdt) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
