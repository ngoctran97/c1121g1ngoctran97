package com.codegym.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int soLuong;

    private String moTa;

    @OneToMany(mappedBy = "sach")
    private List<Muon> muonList;


    public Sach() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<Muon> getMuonList() {
        return muonList;
    }

    public void setMuonList(List<Muon> muonList) {
        this.muonList = muonList;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", soLuong=" + soLuong +
                ", moTa='" + moTa + '\'' +
                ", muonList=" + muonList +
                '}';
    }
}
