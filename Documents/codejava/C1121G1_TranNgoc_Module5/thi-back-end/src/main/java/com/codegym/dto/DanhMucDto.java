package com.codegym.dto;

import javax.validation.constraints.NotBlank;

public class DanhMucDto {
    private Integer id;
    @NotBlank(message = "không được để trống.")
    private String tenDanhMuc;

    public DanhMucDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}
