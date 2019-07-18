package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.CompanyInput;
import com.dh.fullstack.users.service.input.UserInput;
import com.dh.fullstack.users.service.model.domain.Company;
import com.dh.fullstack.users.service.model.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/companies") //para colocar el path
@RequestScope
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Company createCompany(@RequestBody CompanyInput input) {

        Company company = new Company();

        company.setName(input.getName());

        return companyRepository.save(company);

    }

}
