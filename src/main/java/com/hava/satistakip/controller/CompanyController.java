package com.hava.satistakip.controller;

import com.hava.satistakip.model.Company;
import com.hava.satistakip.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private ICompanyRepository companyRepository;

    @RequestMapping("/saveOrUpdate")
    public Company saveorUpdateAirport(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @RequestMapping("/findAll")
    public List<Company> findAll(@RequestParam String search) {
        return companyRepository.search(search);
    }
}
