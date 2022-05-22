package com.codegym.dto;

import javax.validation.constraints.NotBlank;

public class VungMiemDto {
    private Integer id;
    @NotBlank(message = "không được để trống.")
    private String tenVungMien;

    public VungMiemDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenVungMien() {
        return tenVungMien;
    }

    public void setTenVungMien(String tenVungMien) {
        this.tenVungMien = tenVungMien;
    }
}
