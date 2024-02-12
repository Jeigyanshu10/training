package com.anshu.jobapp.service.impl;

import com.anshu.jobapp.entities.CompanyEntity;
import com.anshu.jobapp.repo.CompanyRepo;
import com.anshu.jobapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<CompanyEntity> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public CompanyEntity getCompanyById(Long id) {
        return companyRepo.findById(id).get();
    }

    @Override
    public boolean deleteCompany(Long id) {
        companyRepo.deleteById(id);
        return true;
    }

    @Override
    public CompanyEntity updateCompany(Long id, CompanyEntity company) {
        CompanyEntity existingCompany = companyRepo.findById(id).get();
        existingCompany.setDescription(company.getDescription());
        existingCompany.setName(company.getName());
        existingCompany.setJobs(company.getJobs());
        companyRepo.save(existingCompany);
        return existingCompany;
    }

    @Override
    public CompanyEntity addCompany(CompanyEntity company) {
        return companyRepo.save(company);
    }
}
