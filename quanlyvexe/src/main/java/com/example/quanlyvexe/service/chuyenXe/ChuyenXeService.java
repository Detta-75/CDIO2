package com.example.quanlyvexe.service.chuyenXe;

import com.example.quanlyvexe.model.ChuyenXe;
import com.example.quanlyvexe.model.LoaiTuyen;
import com.example.quanlyvexe.model.TuyenXe;
import com.example.quanlyvexe.repository.IChuyenXeRepository;
import com.example.quanlyvexe.repository.IVeXeRepository;
import com.example.quanlyvexe.repository.ITuyenXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChuyenXeService implements IChuyenXeService {
    @Autowired
    private IChuyenXeRepository chuyenXeRepository;
    @Autowired
    private IVeXeRepository veXeRepository;
    @Autowired
    private ITuyenXeRepository tuyenXeRepository;

    @Override
    public List<ChuyenXe> getAllChuyenXe() {
        return chuyenXeRepository.findAll();
    }

    @Override
    public void saveChuyenXe(ChuyenXe chuyenXe) {
        chuyenXeRepository.save(chuyenXe);
    }

    @Override
    @Transactional
    public void deleteById(Long idChuyenXe) {
        veXeRepository.deleteByChuyenXe_Id(idChuyenXe);
        chuyenXeRepository.deleteById(idChuyenXe);
    }

    @Override
    @Transactional
    public void updateChuyenXe(Long id, String maTuyen, String tenTuyen, String loaiTuyen, String ngayDi, String gioDi, int soGhe) {
        ChuyenXe chuyenXe = chuyenXeRepository.findById(id).orElse(null);
        if (chuyenXe != null) {
            // Cập nhật tuyến xe nếu cần
            TuyenXe tuyenXe = chuyenXe.getTuyenXe();
            if (!tuyenXe.getMaTuyen().equals(maTuyen)) {
                // Nếu đổi mã tuyến, tìm tuyến mới hoặc tạo mới
                tuyenXe = tuyenXeRepository.findById(maTuyen).orElse(new TuyenXe());
                tuyenXe.setMaTuyen(maTuyen);
            }
            tuyenXe.setTenTuyen(tenTuyen);
            tuyenXe.setLoaiTuyen(LoaiTuyen.valueOf(loaiTuyen));
            tuyenXeRepository.save(tuyenXe);
            // Cập nhật chuyến xe
            chuyenXe.setTuyenXe(tuyenXe);
            chuyenXe.setNgayDi(ngayDi);
            chuyenXe.setGioDi(gioDi);
            chuyenXe.setSoGhe(soGhe);
            chuyenXeRepository.save(chuyenXe);
        }
    }
} 