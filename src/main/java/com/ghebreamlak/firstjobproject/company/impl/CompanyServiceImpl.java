package com.ghebreamlak.firstjobproject.company.impl;

import com.ghebreamlak.firstjobproject.company.Company;
import com.ghebreamlak.firstjobproject.company.CompanyRepository;
import com.ghebreamlak.firstjobproject.company.CompanyService;
import com.ghebreamlak.firstjobproject.job.Job;
import com.ghebreamlak.firstjobproject.job.JobRepository;
import com.ghebreamlak.firstjobproject.review.Review;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private JobRepository jobRepository;
    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies;
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
        List<Job> jobs = company.getJobs();

        for (Job job : jobs){
            job.setCompany(company);
            jobRepository.save(job);
        }
        Company comp = companyRepository.save(company);

//        for (Review review : company.getReviews()) {
//            reviewRepository.save(review);
//        }

        return comp;
    }

    @Override
    public void deleteCompany(Long id) {
        Company comp = companyRepository.getById(id);
        companyRepository.delete(comp);

    }

    @Override
    public Company getCompanyByID(Long id) {
        Company company = companyRepository.findCompaniesById(id);
        return company;
    }
}
