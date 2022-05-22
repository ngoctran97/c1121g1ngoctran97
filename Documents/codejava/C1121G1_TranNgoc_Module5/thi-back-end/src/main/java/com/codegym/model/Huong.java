package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Huong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenHuong;
    @JsonBackReference
    @OneToMany(mappedBy = "huong")
    private Set<Blog> blogSet;

    public Huong() {
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

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
