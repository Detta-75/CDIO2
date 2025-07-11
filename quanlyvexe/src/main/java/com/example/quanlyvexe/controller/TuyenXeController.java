package com.example.quanlyvexe.controller;

import com.example.quanlyvexe.model.ChuyenXe;
import com.example.quanlyvexe.model.TuyenXe;
import com.example.quanlyvexe.model.LoaiTuyen;
import com.example.quanlyvexe.service.chuyenXe.IChuyenXeService;
import com.example.quanlyvexe.service.tuyenXe.ITuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class TuyenXeController {
    @Autowired
    private IChuyenXeService chuyenXeService;
    @Autowired
    private ITuyenXeService tuyenXeService;

    @GetMapping("")
    public String showTuyenXe(Model model){
        List<ChuyenXe> list = chuyenXeService.getAllChuyenXe();
        model.addAttribute("chuyenXeList", list);
        model.addAttribute("chuyenXe", new ChuyenXe());
        return "TuyenXe";
    }

    @PostMapping("/addChuyenXe")
    public String addChuyenXe(@RequestParam("maTuyen") String maTuyen,
                              @RequestParam("tenTuyen") String tenTuyen,
                              @RequestParam("loaiTuyen") String loaiTuyenStr,
                              @RequestParam("ngayDi") String ngayDi,
                              @RequestParam("gioDi") String gioDi,
                              @RequestParam("soGhe") int soGhe) {
        TuyenXe tuyenXe = tuyenXeService.findByMaTuyen(maTuyen);
        LoaiTuyen loaiTuyen = LoaiTuyen.valueOf(loaiTuyenStr);
        if (tuyenXe == null) {
            tuyenXe = new TuyenXe();
            tuyenXe.setMaTuyen(maTuyen);
            tuyenXe.setTenTuyen(tenTuyen);
            tuyenXe.setLoaiTuyen(loaiTuyen);
            tuyenXe.setDonGia(loaiTuyen.getDonGia());
            tuyenXeService.saveTuyenXe(tuyenXe);
        }
        ChuyenXe chuyenXe = new ChuyenXe(ngayDi, gioDi, soGhe, tuyenXe);
        chuyenXeService.saveChuyenXe(chuyenXe);
        return "redirect:/";
    }

    @PostMapping("/deleteTuyenXe")
    public String deleteTuyenXe(@RequestParam("maTuyen") String maTuyen) {
        tuyenXeService.deleteByMaTuyen(maTuyen);
        return "redirect:/";
    }

    @PostMapping("/deleteChuyenXe")
    public String deleteChuyenXe(@RequestParam("idChuyenXe") Long idChuyenXe) {
        chuyenXeService.deleteById(idChuyenXe);
        return "redirect:/";
    }

    @PostMapping("/editChuyenXe")
    public String editChuyenXe(@RequestParam("id") Long id,
                               @RequestParam("maTuyen") String maTuyen,
                               @RequestParam("tenTuyen") String tenTuyen,
                               @RequestParam("loaiTuyen") String loaiTuyen,
                               @RequestParam("ngayDi") String ngayDi,
                               @RequestParam("gioDi") String gioDi,
                               @RequestParam("soGhe") int soGhe) {
        chuyenXeService.updateChuyenXe(id, maTuyen, tenTuyen, loaiTuyen, ngayDi, gioDi, soGhe);
        return "redirect:/";
    }
}
