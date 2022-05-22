package com.codegym.dto;

import javax.validation.constraints.NotBlank;

public class HuongDto {
    private Integer id;
    @NotBlank(message = "không được để trống.")
    private String tenHuong;

    public HuongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHuong() {
        return tenHuong;
    }

    public void setTenHuong(String tenHuong) {
        this.tenHuong = tenHuong;
    }
}
