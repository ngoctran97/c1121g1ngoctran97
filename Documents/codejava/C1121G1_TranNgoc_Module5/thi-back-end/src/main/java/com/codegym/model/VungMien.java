package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VungMien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenVungMien;
    @JsonBackReference
    @OneToMany(mappedBy = "vungMien")
    private Set<Blog> blogSet;

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

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
