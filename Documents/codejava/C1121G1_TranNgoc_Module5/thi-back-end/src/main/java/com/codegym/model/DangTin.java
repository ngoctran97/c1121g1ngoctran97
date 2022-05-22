package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DangTin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenDangTin;
    @JsonBackReference
    @OneToMany(mappedBy = "dangTin")
    private Set<Blog> blogSet;

    public DangTin() {
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

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
