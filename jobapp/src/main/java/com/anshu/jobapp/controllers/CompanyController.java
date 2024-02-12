package com.anshu.jobapp.controllers;

import com.anshu.jobapp.entities.CompanyEntity;
import com.anshu.jobapp.entities.ReviewEntity;
import com.anshu.jobapp.service.CompanyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyEntity>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyEntity> addCompany(@RequestBody CompanyEntity company){
        return new ResponseEntity<>(companyService.addCompany(company),HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable String id){
        return new ResponseEntity<>(companyService.getCompanyById(Long.parseLong(id)),HttpStatus.OK);
    }

    @PutMapping("/id")
    public ResponseEntity<CompanyEntity> updateCompany(@RequestBody CompanyEntity company,@PathVariable String id){
      return new ResponseEntity<>(companyService.updateCompany(Long.parseLong(id),company),HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteCompany(@PathVariable String id){
        if(companyService.deleteCompany(Long.parseLong(id))){
            return new ResponseEntity<>("Company deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to delete the requested company, please try with different id",HttpStatus.OK);
    }

    @GetMapping("/{id}/review")
    public ResponseEntity<ReviewEntity> getReviewByCompanyId(@PathVariable String id){
        Long longId = Long.parseLong(id);
        return null;
    }

    public ResponseEntity<String> addReviewToCompany(){
      return null;
    }


}
