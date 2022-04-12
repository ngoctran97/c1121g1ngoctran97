package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maHocSinh;
    private String hoTen;
    private String lop;

    @OneToMany(mappedBy = "hocSinh")
    private List<Muon> muonList;

    public HocSinh() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public List<Muon> getMuonList() {
        return muonList;
    }

    public void setMuonList(List<Muon> muonList) {
        this.muonList = muonList;
    }


}
