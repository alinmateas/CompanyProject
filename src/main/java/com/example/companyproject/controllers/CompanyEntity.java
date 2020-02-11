package com.example.companyproject.controllers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.example.companyproject.dao.Company;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="name", unique=true, nullable = false)
    private String name;
    private String data;

    public Company toPojo() {
        Company pojo = new Company();
        pojo.setName(name);
        pojo.setData(data);
        return pojo;
    }

    public CompanyEntity update(Company pojo) {
        this.name = pojo.getName();
        this.data = pojo.getData();
        return this;
    }

}