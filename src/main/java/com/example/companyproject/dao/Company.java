package com.example.companyproject.dao;

import com.example.companyproject.services.CompanyDTO;
import lombok.Data;

@Data
public class Company {
    private String name;
    private String data;

    public CompanyDTO toDto(){
        CompanyDTO dto = new CompanyDTO();
        dto.setName(name);
        return dto;
    }

    public Company update(CompanyDTO dto){
        this.name = dto.getName();
        return this;
    }
}
