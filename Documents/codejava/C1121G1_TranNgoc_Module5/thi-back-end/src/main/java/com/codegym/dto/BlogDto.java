package com.codegym.dto;

import com.codegym.model.DangTin;
import com.codegym.model.DanhMuc;
import com.codegym.model.Huong;
import com.codegym.model.VungMien;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BlogDto implements Validator {
    private Integer id;
    @Valid
    private DanhMucDto danhMucDto;
    @Valid
    private VungMiemDto vungMienDto;
    @NotBlank(message = "không được để trống.")
    private String banLa;
    @Valid
    private DangTinDto dangTinDto;
    @NotBlank(message = "không được để trống.")
    private String tinhTrang;
    @NotBlank(message = "không được để trống.")
    private String diaChi;
    @Pattern(regexp = "^(([0]*[1-9][0-9]*)|[1-9][0-9]*)$", message = "min = 0")
    private String dienTich;
    @Valid
    private HuongDto huongDto;
    @NotBlank(message = "không được để trống.")
    private String tuaDe;
    @NotBlank(message = "không được để trống.")
    private String noiDunh;
    @Pattern(regexp = "^(([0]*[1-9][0-9]*)|[1-9][0-9]*)$", message = "Min = 100000000")
    private String gia;
    @NotBlank(message = "không được để trống.")
    private String trangThai;
    @NotBlank(message = "không được để trống.")
    private String ngayDang;

    public BlogDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DanhMucDto getDanhMucDto() {
        return danhMucDto;
    }

    public void setDanhMucDto(DanhMucDto danhMucDto) {
        this.danhMucDto = danhMucDto;
    }

    public VungMiemDto getVungMienDto() {
        return vungMienDto;
    }

    public void setVungMienDto(VungMiemDto vungMienDto) {
        this.vungMienDto = vungMienDto;
    }

    public String getBanLa() {
        return banLa;
    }

    public void setBanLa(String banLa) {
        this.banLa = banLa;
    }

    public DangTinDto getDangTinDto() {
        return dangTinDto;
    }

    public void setDangTinDto(DangTinDto dangTinDto) {
        this.dangTinDto = dangTinDto;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
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

    public HuongDto getHuongDto() {
        return huongDto;
    }

    public void setHuongDto(HuongDto huongDto) {
        this.huongDto = huongDto;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
