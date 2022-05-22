package com.codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc", referencedColumnName = "id")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "id_vung_mien", referencedColumnName = "id")
    private VungMien vungMien;

    private String banLa;

    @ManyToOne
    @JoinColumn(name = "id_dang_tin", referencedColumnName = "id")
    private DangTin dangTin;

    private String tinhTrang;

    private String diaChi;
    private String dienTich;

    @ManyToOne
    @JoinColumn(name = "id_huong", referencedColumnName = "id")
    private Huong huong;

    private String tuaDe;
    private String noiDunh;
    private String gia;
    private String trangThai;
    private String ngayDang;

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public VungMien getVungMien() {
        return vungMien;
    }

    public void setVungMien(VungMien vungMien) {
        this.vungMien = vungMien;
    }

    public String getBanLa() {
        return banLa;
    }

    public void setBanLa(String banLa) {
        this.banLa = banLa;
    }

    public DangTin getDangTin() {
        return dangTin;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setDangTin(DangTin dangTin) {
        this.dangTin = dangTin;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public Huong getHuong() {
        return huong;
    }

    public String getTuaDe() {
        return tuaDe;
    }

    public void setTuaDe(String tuaDe) {
        this.tuaDe = tuaDe;
    }

    public String getNoiDunh() {
        return noiDunh;
    }

    public void setNoiDunh(String noiDunh) {
        this.noiDunh = noiDunh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public void setHuong(Huong huong) {
        this.huong = huong;
    }
}
