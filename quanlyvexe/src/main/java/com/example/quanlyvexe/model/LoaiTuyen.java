package com.example.quanlyvexe.model;

public enum LoaiTuyen {
    MIEN_BAC("Miền Bắc", 450000.00),
    MIEN_NAM("Miền Nam", 500000.00),
    MIEN_TRUNG("Miền Trung", 300000.00);

    private final String displayName;
    private final double donGia;

    LoaiTuyen(String displayName, double donGia) {
        this.displayName = displayName;
        this.donGia = donGia;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getDonGia() {
        return donGia;
    }
}
