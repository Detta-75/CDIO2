package com.example.quanlyvexe.service.veXe;

import com.example.quanlyvexe.model.VeXeDTO;
import com.example.quanlyvexe.model.KhachHang;
import com.example.quanlyvexe.model.TuyenXe;
import com.example.quanlyvexe.model.ChuyenXe;
import com.example.quanlyvexe.model.VeXe;
import com.example.quanlyvexe.repository.IVeXeRepository;
import com.example.quanlyvexe.repository.IChuyenXeRepository;
import com.example.quanlyvexe.repository.ITuyenXeRepository;
import com.example.quanlyvexe.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class VeXeServiceImpl implements IVeXeService {
    @Autowired
    private IVeXeRepository veXeRepository;
    @Autowired
    private IChuyenXeRepository chuyenXeRepository;
    @Autowired
    private ITuyenXeRepository tuyenXeRepository;
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public List<VeXeDTO> getAllVeXe() {
        return veXeRepository.findAllVeXeDTO();
    }

    @Override
    @Transactional
    public void themVe(String maTuyen, String ngayKhoiHanh, String gioKhoiHanh, String idKhachHang, String tenKhachHang, String sdt, int soVe) {
        // 1. Tìm hoặc tạo KhachHang
        KhachHang khachHang = khachHangRepository.findById(idKhachHang).orElse(null);
        if (khachHang == null) {
            khachHang = new KhachHang(idKhachHang, tenKhachHang, sdt);
            khachHangRepository.save(khachHang);
        }
        // 2. Tìm tuyến xe theo mã
        TuyenXe tuyenXe = tuyenXeRepository.findById(maTuyen).orElse(null);
        if (tuyenXe == null) {
            throw new RuntimeException("Không tìm thấy tuyến xe: " + maTuyen);
        }
        // 3. Tìm hoặc tạo chuyến xe theo tuyến/ngày/giờ
        ChuyenXe chuyenXe = chuyenXeRepository.findByTuyenXeAndNgayDiAndGioDi(tuyenXe, ngayKhoiHanh, gioKhoiHanh);
        if (chuyenXe == null) {
            chuyenXe = new ChuyenXe(ngayKhoiHanh, gioKhoiHanh, 0, tuyenXe);
            chuyenXeRepository.save(chuyenXe);
        }
        // 4. Tạo vé mới
        VeXe veXe = new VeXe(chuyenXe, khachHang, soVe);
        veXeRepository.save(veXe);
    }

    @Override
    @Transactional
    public void suaVe(Long idVe, String tenKhachHang, String sdt, String ngayDi, String gioDi, int soVe) {
        VeXe ve = veXeRepository.findById(idVe).orElseThrow();
        KhachHang kh = ve.getKhachHang();
        kh.setTenKhachHang(tenKhachHang);
        kh.setSdt(sdt);
        ve.getChuyenXe().setNgayDi(ngayDi);
        ve.getChuyenXe().setGioDi(gioDi);
        ve.setSoVe(soVe);
        // Các repository đã là JpaRepository nên sẽ tự động cập nhật khi commit transaction
    }

    @Override
    public void xoaVe(Long idVe) {
        veXeRepository.deleteById(idVe);
    }
} 