package com.example.companyproject.dao;

import com.example.companyproject.controllers.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    CompanyEntity deleteByName(String name);
    Optional<CompanyEntity> findCompanyEntityByName(String Name);
}
