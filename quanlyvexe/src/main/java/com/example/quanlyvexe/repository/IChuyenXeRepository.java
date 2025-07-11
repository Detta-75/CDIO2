package com.example.quanlyvexe.repository;

import com.example.quanlyvexe.model.TuyenXe;
import com.example.quanlyvexe.model.ChuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChuyenXeRepository extends JpaRepository<ChuyenXe, Long> {
    void deleteByTuyenXe_MaTuyen(String maTuyen);

    List<ChuyenXe> findByTuyenXe_MaTuyen(String tuyenXeMaTuyen);

    ChuyenXe findByTuyenXeAndNgayDiAndGioDi(TuyenXe tuyenXe, String ngayDi, String gioDi);
}