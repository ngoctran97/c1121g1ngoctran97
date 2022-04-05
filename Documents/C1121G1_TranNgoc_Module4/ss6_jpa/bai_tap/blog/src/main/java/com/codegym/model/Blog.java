package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tieuDe;
    private String tacGia;
    private String tomTat;
    private String noiDung;

    public Blog(Integer id, String tieuDe, String tacGia, String tomTat) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.tomTat = tomTat;
    }

    public Blog(Integer id, String tieuDe, String tacGia, String tomTat, String noiDung) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.tomTat = tomTat;
        this.noiDung = noiDung;
    }

    public Blog() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
