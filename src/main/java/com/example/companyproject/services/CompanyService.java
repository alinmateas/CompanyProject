package com.example.companyproject.services;

import com.example.companyproject.dao.CompanyEntity;
import com.example.companyproject.dao.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll().stream().map(CompanyEntity::toPojo).collect(Collectors.toList());
    }

    public Company addCompany(Company company) {
        CompanyEntity newCompany = new CompanyEntity();
        newCompany.update(company);
        return companyRepository.save(newCompany).toPojo();
    }



    public void deleteByName(String name) {
        companyRepository.deleteByName(name);
    }

}
