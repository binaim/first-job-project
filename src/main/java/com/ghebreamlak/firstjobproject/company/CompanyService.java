package com.ghebreamlak.firstjobproject.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company updateCompany(Long id, Company company);
    Company createCompany(Company company);
    void deleteCompany(Long id);
    Company getCompanyByID(Long id);
}
