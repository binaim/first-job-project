package com.ghebreamlak.forstjobproject.job;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
//@NoArgsConstructor
public class JobController {
    private JobService jobService;

    @GetMapping()
    public <T> ResponseEntity<T>  findAll() {
        return new ResponseEntity<T>((T) jobService.findAll(),HttpStatus.OK);

    }

    @PostMapping
    public <T> ResponseEntity<T>  addJob(@RequestBody Job job) {

        return new ResponseEntity<T>((T) jobService.createJob(job),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public <T> ResponseEntity<T> getJobByID(@PathVariable Long id){
        ResponseEntity response = new ResponseEntity<>(jobService.getJobByID(id), HttpStatus.OK);
        if (response.getBody() != null){
          return   response;
        }
        response = new ResponseEntity<>( "There is No job for this ID",HttpStatus.NOT_FOUND);
        return response ;
    }
    @DeleteMapping("/{id}")
    public <T> ResponseEntity<T> deleteJobByID(@PathVariable Long id){
        boolean isDeleted = jobService.deleteJobByID(id);
        if (isDeleted){
            return new ResponseEntity<T>((T) "Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<T>((T) "Job Not Found", HttpStatus.NOT_FOUND);
    }

}