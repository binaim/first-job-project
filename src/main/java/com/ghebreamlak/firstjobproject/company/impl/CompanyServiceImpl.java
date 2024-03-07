package com.ghebreamlak.firstjobproject.company.impl;

import com.ghebreamlak.firstjobproject.company.Company;
import com.ghebreamlak.firstjobproject.company.CompanyRepository;
import com.ghebreamlak.firstjobproject.company.CompanyService;
import com.ghebreamlak.firstjobproject.job.Job;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {

        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Company updatedCompany = companyRepository.findById(id).get();

        try{
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setName(company.getName());
            updatedCompany.setJobs(company.getJobs());
            companyRepository.save(updatedCompany);
            return updatedCompany;
        }catch (Exception e){
            return company;
        }

    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company comp = companyRepository.getById(id);
        companyRepository.delete(comp);

    }

    @Override
    public Company getCompanyByID(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
