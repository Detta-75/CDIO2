package com.example.quanlyvexe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tuyen_xe")
public class TuyenXe {

    @Id
    @Column(name = "ma_tuyen")
    private String maTuyen;

    @Column(name = "ten_tuyen", nullable = false)
    private String tenTuyen;

    @Enumerated(EnumType.STRING)
    @Column(name = "loai_tuyen", nullable = false)
    private LoaiTuyen loaiTuyen;

    @Column(name = "don_gia", nullable = false)
    private double donGia;

    public TuyenXe() {
    }

    public TuyenXe(String maTuyen, String tenTuyen, LoaiTuyen loaiTuyen, double donGia) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.loaiTuyen = loaiTuyen;
        this.donGia = donGia;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public LoaiTuyen getLoaiTuyen() {
        return loaiTuyen;
    }

    public void setLoaiTuyen(LoaiTuyen loaiTuyen) {
        this.loaiTuyen = loaiTuyen;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
