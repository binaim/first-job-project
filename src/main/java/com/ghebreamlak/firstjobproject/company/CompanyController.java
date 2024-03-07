package com.ghebreamlak.firstjobproject.company;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping
    public <T>ResponseEntity<T> getAllCompanies(){
        return new ResponseEntity<T>((T) companyService.getAllCompanies(), HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public <T> ResponseEntity<T> getCompanyByID(@PathVariable Long id){
        Company company = companyService.getCompanyByID(id);

        if (company != null){
            return (ResponseEntity<T>) new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<T>((T) "No Company for the id is found", HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public <T> ResponseEntity<T> createCompany(@RequestBody Company company){
        return new ResponseEntity<T>((T) companyService.createCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public <T> ResponseEntity<T> updateCompanies(@PathVariable Long id, @RequestBody Company company){
        Company updatedCompany = companyService.updateCompany(id, company);
        if (company.equals(updatedCompany)){
            return new ResponseEntity<T>((T) "Company not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<T>((T) updatedCompany, HttpStatus.FOUND);
    }
    @DeleteMapping("/{id}")
    public <T> ResponseEntity<T> deleteCompanyByID(@PathVariable Long id){
        try {
            return new ResponseEntity<T>((T) "Company deleted Successfully", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<T>((T) "No such Company for the id is found", HttpStatus.NOT_FOUND);
        }

    }
}
