package com.example.quanlyvexe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ve_xe")
public class VeXe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ve")
    private Long idVe;

    @ManyToOne
    @JoinColumn(name = "id_chuyen_xe", nullable = false)
    private ChuyenXe chuyenXe;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang", nullable = false)
    private KhachHang khachHang;

    @Column(name = "so_ve", nullable = false)
    private int soVe;

    public VeXe() {
    }

    public VeXe(ChuyenXe chuyenXe, KhachHang khachHang, int soVe) {
        this.chuyenXe = chuyenXe;
        this.khachHang = khachHang;
        this.soVe = soVe;
    }

    public Long getIdVe() {
        return idVe;
    }

    public void setIdVe(Long idVe) {
        this.idVe = idVe;
    }

    public ChuyenXe getChuyenXe() {
        return chuyenXe;
    }

    public void setChuyenXe(ChuyenXe chuyenXe) {
        this.chuyenXe = chuyenXe;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public int getSoVe() {
        return soVe;
    }

    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }
}
