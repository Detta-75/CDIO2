package com.example.quanlyvexe.model;

public class VeXeDTO {
    private Long idVe;
    private String idKhachHang;
    private String tenKhachHang;
    private String sdt;
    private String maTuyen;
    private String ngayDi;
    private String gioDi;
    private int soVe;
    private double thanhTien;

    public VeXeDTO(Long idVe, String idKhachHang, String tenKhachHang, String sdt, String maTuyen, String ngayDi, String gioDi, int soVe, double thanhTien) {
        this.idVe = idVe;
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.maTuyen = maTuyen;
        this.ngayDi = ngayDi;
        this.gioDi = gioDi;
        this.soVe = soVe;
        this.thanhTien = thanhTien;
    }

    public Long getIdVe() { return idVe; }
    public void setIdVe(Long idVe) { this.idVe = idVe; }
    public String getIdKhachHang() { return idKhachHang; }
    public void setIdKhachHang(String idKhachHang) { this.idKhachHang = idKhachHang; }
    public String getTenKhachHang() { return tenKhachHang; }
    public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public String getMaTuyen() { return maTuyen; }
    public void setMaTuyen(String maTuyen) { this.maTuyen = maTuyen; }
    public String getNgayDi() { return ngayDi; }
    public void setNgayDi(String ngayDi) { this.ngayDi = ngayDi; }
    public String getGioDi() { return gioDi; }
    public void setGioDi(String gioDi) { this.gioDi = gioDi; }
    public int getSoVe() { return soVe; }
    public void setSoVe(int soVe) { this.soVe = soVe; }
    public double getThanhTien() { return thanhTien; }
    public void setThanhTien(double thanhTien) { this.thanhTien = thanhTien; }
}
