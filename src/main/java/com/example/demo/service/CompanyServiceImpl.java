package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Integer id) {
        Optional<Company> optional = companyRepository.findById(id);
        Company company = null;
        if(optional.isPresent()) {
            company = optional.get();
        }else {
            throw new RuntimeException("Company Not found for id"+id);
        }
        return company;
    }

    @Override
    public void deleteCompanyById(Integer id) {
        this.companyRepository.deleteById(id);
    }


}
