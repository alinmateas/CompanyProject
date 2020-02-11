package com.example.companyproject.controllers;

import com.example.companyproject.services.Company;
import com.example.companyproject.services.CompanyDto;
import com.example.companyproject.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(path = "/")
    public CompanyDto addCompany(@RequestBody Company company) {
        return companyService.addCompany(company).toDto();
    }

    @PutMapping("/{existingName}")
    public CompanyDto updateCompany(@PathVariable("existingName") String existingName, @RequestBody Company company) {
        return companyService.updateCompany(existingName, company).toDto();
    }

    @GetMapping(path = "/")
    public List<CompanyDto> getCompanies() {
        return companyService.getCompanies().stream().map(Company::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{existingName}")
    @Transactional
    public void deleteCompany(@PathVariable("existingName") String existingName) {
        companyService.deleteByName(existingName);
    }
}
