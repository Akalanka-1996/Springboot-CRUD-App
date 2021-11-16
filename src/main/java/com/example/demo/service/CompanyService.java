package com.example.demo.service;

import com.example.demo.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void saveCompany(Company company);
    Company getCompanyById(Integer id);
    void deleteCompanyById(Integer id);
}
