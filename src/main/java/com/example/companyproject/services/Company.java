package com.example.companyproject.services;

import com.example.companyproject.services.CompanyDto;
import lombok.Data;

@Data
public class Company {
    private String name;
    private String data;

    public CompanyDto toDto(){
        CompanyDto dto = new CompanyDto();
        dto.setName(name);
        return dto;
    }

    public Company update(CompanyDto dto){
        this.name = dto.getName();
        return this;
    }
}
