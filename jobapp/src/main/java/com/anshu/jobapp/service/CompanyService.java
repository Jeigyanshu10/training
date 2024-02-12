package com.anshu.jobapp.service;


import com.anshu.jobapp.entities.CompanyEntity;

import java.util.List;

public interface CompanyService {

    List<CompanyEntity> getAllCompanies();

    CompanyEntity getCompanyById(Long id);

    boolean deleteCompany(Long id);

    CompanyEntity updateCompany(Long id, CompanyEntity company);

    CompanyEntity addCompany(CompanyEntity company);
}