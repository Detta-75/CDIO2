package com.example.quanlyvexe.repository;

import com.example.quanlyvexe.model.TuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITuyenXeRepository extends JpaRepository<TuyenXe, String> {
    TuyenXe findByTenTuyen(String tenTuyen);
}
