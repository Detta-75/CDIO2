package com.example.quanlyvexe.repository;

import com.example.quanlyvexe.model.VeXe;
import com.example.quanlyvexe.model.VeXeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IVeXeRepository extends JpaRepository<VeXe, Long> {
    void deleteByChuyenXe_Id(Long idChuyenXe);

    @Query("SELECT new com.example.quanlyvexe.model.VeXeDTO(" +
           "v.idVe, k.idKhachHang, k.tenKhachHang, k.sdt, t.maTuyen, c.ngayDi, c.gioDi, v.soVe, (v.soVe * t.donGia)) " +
           "FROM VeXe v " +
           "JOIN v.khachHang k " +
           "JOIN v.chuyenXe c " +
           "JOIN c.tuyenXe t")
    List<VeXeDTO> findAllVeXeDTO();
} 