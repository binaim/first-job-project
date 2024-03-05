package com.ghebreamlak.firstjobproject.job.impl;

import com.ghebreamlak.firstjobproject.job.Job;
import com.ghebreamlak.firstjobproject.job.JobRepository;
import com.ghebreamlak.firstjobproject.job.JobService;
import com.ghebreamlak.firstjobproject.job.configuration.JobDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
//@NoArgsConstructor
@Service
@AllArgsConstructor
@Log4j
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();

    private final JobRepository jobRepository;
    private ModelMapper modelMapper;

    //private Long nextID = 1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {

        return jobRepository.save(job);
    }

    @Override
    public Job getJobByID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobByID(Long id) {
        try {
        jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;

        }
    }

    @Override
    public Job updateJob(Long id, Job job) {

        Optional<Job> jobOptional = jobRepository.findById(id);
        try {
            return jobRepository.save(jobOptional.get());
        }catch (Exception e){
            log.fatal("the target job doesn't exist");
            return job;
        }

    }
}
