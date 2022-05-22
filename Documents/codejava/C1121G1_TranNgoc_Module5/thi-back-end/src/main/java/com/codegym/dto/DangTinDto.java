package com.codegym.dto;

import javax.validation.constraints.NotBlank;

public class DangTinDto {
    private Integer id;
    @NotBlank(message = "không được để trống.")
    private String tenDangTin;

    public DangTinDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDangTin() {
        return tenDangTin;
    }

    public void setTenDangTin(String tenDangTin) {
        this.tenDangTin = tenDangTin;
    }
}
