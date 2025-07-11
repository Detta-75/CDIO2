package com.example.quanlyvexe.service.tuyenXe;

import com.example.quanlyvexe.model.TuyenXe;
import java.util.List;

public interface ITuyenXeService {
    List<TuyenXe> getAllTuyenXe();
    TuyenXe findByMaTuyen(String maTuyen);
    void saveTuyenXe(TuyenXe tuyenXe);
    void deleteByMaTuyen(String maTuyen);
}
