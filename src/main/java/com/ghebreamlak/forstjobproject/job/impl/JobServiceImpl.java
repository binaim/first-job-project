package com.ghebreamlak.forstjobproject.job.impl;

import com.ghebreamlak.forstjobproject.job.Job;
import com.ghebreamlak.forstjobproject.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextID = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Job createJob(Job job) {
        job.setId(nextID++);
        jobs.add(job);
        return job;
    }

    @Override
    public Job getJobByID(Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public boolean deleteJobByID(Long id) {
        boolean isPresent = jobs.stream().anyMatch(job -> job.getId().equals(id));
        if (isPresent){
            Job toDelete = jobs.stream().filter(job -> job.getId().equals(id)).findFirst().get();
            jobs.remove(toDelete);
            return isPresent;
        }
        return false;
    }
}
