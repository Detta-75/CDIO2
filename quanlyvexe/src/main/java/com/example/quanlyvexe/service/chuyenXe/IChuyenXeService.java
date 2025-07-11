package com.example.quanlyvexe.service.chuyenXe;

import com.example.quanlyvexe.model.ChuyenXe;
import java.util.List;

public interface IChuyenXeService {
    List<ChuyenXe> getAllChuyenXe();
    void saveChuyenXe(ChuyenXe chuyenXe);
    void deleteById(Long idChuyenXe);
    void updateChuyenXe(Long id, String maTuyen, String tenTuyen, String loaiTuyen, String ngayDi, String gioDi, int soGhe);
} 