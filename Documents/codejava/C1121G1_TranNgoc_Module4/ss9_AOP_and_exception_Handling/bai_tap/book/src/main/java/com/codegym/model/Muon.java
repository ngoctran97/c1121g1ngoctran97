package com.codegym.model;

import javax.persistence.*;
@Entity
public class Muon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maMuonSach;
    @ManyToOne
    @JoinColumn(name = "sach_id", referencedColumnName ="id")
    private Sach sach;
    @ManyToOne
    @JoinColumn(name = "hocSinh_id", referencedColumnName = "id")
    private HocSinh hocSinh;

    private boolean trangThai;
    private String ngayMuon;
    private String ngayTra;


    public Muon(Integer id, String maMuonSach, Sach sach, HocSinh hocSinh, boolean trangThai, String ngayMuon, String ngayTra) {
        this.id = id;
        this.maMuonSach = maMuonSach;
        this.sach = sach;
        this.hocSinh = hocSinh;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Muon() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    @Override
    public String toString() {
        return "Muon{" +
                "id=" + id +
                ", maMuonSach='" + maMuonSach + '\'' +
                ", sach=" + sach +
                ", hocSinh=" + hocSinh +
                ", trangThai=" + trangThai +
                ", ngayMuon='" + ngayMuon + '\'' +
                ", ngayTra='" + ngayTra + '\'' +
                '}';
    }
}

