package com.example.quanlyvexe.service.veXe;

import com.example.quanlyvexe.model.VeXeDTO;
import java.util.List;

public interface IVeXeService {
    List<VeXeDTO> getAllVeXe();
    void themVe(String maTuyen, String ngayKhoiHanh, String gioKhoiHanh, String idKhachHang, String tenKhachHang, String sdt, int soVe);
    void xoaVe(Long idVe);
    void suaVe(Long idVe, String tenKhachHang, String sdt, String ngayDi, String gioDi, int soVe);
} 