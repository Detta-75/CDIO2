package com.example.quanlyvexe.controller;

import com.example.quanlyvexe.model.VeXeDTO;
import com.example.quanlyvexe.service.veXe.IVeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/banve")
public class BanVeController {
    @Autowired
    private IVeXeService veXeService;

    @GetMapping("")
    public String showBanVe(Model model) {
        List<VeXeDTO> danhSachVe = veXeService.getAllVeXe();
        model.addAttribute("danhSachVe", danhSachVe);
        return "BanVe";
    }

    @PostMapping("/them")
    public String themVe(
        @RequestParam String maTuyen,
        @RequestParam String ngayKhoiHanh,
        @RequestParam String gioKhoiHanh,
        @RequestParam String idKhachHang,
        @RequestParam String tenKhachHang,
        @RequestParam String sdt,
        @RequestParam int soVe,
        RedirectAttributes redirectAttributes
    ) {
        // Gọi service để lưu vé mới
        veXeService.themVe(maTuyen, ngayKhoiHanh, gioKhoiHanh, idKhachHang, tenKhachHang, sdt, soVe);
        // Sau khi thêm xong, redirect về trang bán vé
        return "redirect:/banve";
    }

    @PostMapping("/xoa")
    public String xoaVe(@RequestParam Long idVe) {
        veXeService.xoaVe(idVe);
        return "redirect:/banve";
    }

    @PostMapping("/sua")
    public String suaVe(
        @RequestParam Long idVe,
        @RequestParam String tenKhachHang,
        @RequestParam String sdt,
        @RequestParam String ngayDi,
        @RequestParam String gioDi,
        @RequestParam int soVe
    ) {
        veXeService.suaVe(idVe, tenKhachHang, sdt, ngayDi, gioDi, soVe);
        return "redirect:/banve";
    }
}
