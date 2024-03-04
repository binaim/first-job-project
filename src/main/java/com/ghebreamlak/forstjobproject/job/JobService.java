package com.ghebreamlak.forstjobproject.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job createJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobByID(Long id);
}
