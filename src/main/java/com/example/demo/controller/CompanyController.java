package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewCompanyForm(Model model) {
        // create model attribute to bind form data
        Company company = new Company();
        model.addAttribute("company",company);
        return "new_company";

    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        //save company to database
        companyService.saveCompany(company);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
        //get employee from the service

        Company company = companyService.getCompanyById(id);

        //set company as a model attribute t pre-populate the form
        model.addAttribute("company", company);
        return "update_company";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Integer id) {

        // call delete employee method
        this.companyService.deleteCompanyById(id);
        return "redirect:/";
    }

//    @GetMapping("/findOne")
//    @ResponseBody
//    public Company findOne(long id) {
//       return companyService.getCompanyById(Integer id);
//    }


}

