package com.example.quanlyvexe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chuyen_xe")
public class ChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngay_di")
    private String ngayDi;

    @Column(name = "gio_di")
    private String gioDi;

    @Column(name = "so_ghe")
    private int soGhe;

    @ManyToOne
    @JoinColumn(name = "ma_tuyen")
    private TuyenXe tuyenXe;

    public ChuyenXe() {}

    public ChuyenXe(String ngayDi, String gioDi, int soGhe, TuyenXe tuyenXe) {
        this.ngayDi = ngayDi;
        this.gioDi = gioDi;
        this.soGhe = soGhe;
        this.tuyenXe = tuyenXe;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNgayDi() { return ngayDi; }
    public void setNgayDi(String ngayDi) { this.ngayDi = ngayDi; }
    public String getGioDi() { return gioDi; }
    public void setGioDi(String gioDi) { this.gioDi = gioDi; }
    public int getSoGhe() { return soGhe; }
    public void setSoGhe(int soGhe) { this.soGhe = soGhe; }
    public TuyenXe getTuyenXe() { return tuyenXe; }
    public void setTuyenXe(TuyenXe tuyenXe) { this.tuyenXe = tuyenXe; }
}
