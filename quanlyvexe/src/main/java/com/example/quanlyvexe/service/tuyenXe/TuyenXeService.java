package com.example.quanlyvexe.service.tuyenXe;

import com.example.quanlyvexe.model.TuyenXe;
import com.example.quanlyvexe.repository.ITuyenXeRepository;
import com.example.quanlyvexe.repository.IChuyenXeRepository;
import com.example.quanlyvexe.repository.IVeXeRepository;
import com.example.quanlyvexe.model.ChuyenXe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TuyenXeService implements ITuyenXeService {
    @Autowired
    private ITuyenXeRepository tuyenXeRepository;
    @Autowired
    private IChuyenXeRepository chuyenXeRepository;
    @Autowired
    private IVeXeRepository veXeRepository;

    @Override
    public List<TuyenXe> getAllTuyenXe() {
        return tuyenXeRepository.findAll();
    }

    @Override
    public TuyenXe findByMaTuyen(String maTuyen) {
        return tuyenXeRepository.findById(maTuyen).orElse(null);
    }

    @Override
    public void saveTuyenXe(TuyenXe tuyenXe) {
        tuyenXeRepository.save(tuyenXe);
    }

    @Override
    @Transactional
    public void deleteByMaTuyen(String maTuyen) {
        List<ChuyenXe> chuyenXes = chuyenXeRepository.findByTuyenXe_MaTuyen(maTuyen);
        for (ChuyenXe cx : chuyenXes) {
            veXeRepository.deleteByChuyenXe_Id(cx.getId());
        }
        chuyenXeRepository.deleteByTuyenXe_MaTuyen(maTuyen);
        tuyenXeRepository.deleteById(maTuyen);
    }
}
