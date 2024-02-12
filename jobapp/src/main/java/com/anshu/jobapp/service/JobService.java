package com.anshu.jobapp.service;

import com.anshu.jobapp.entities.JobEntity;

import java.util.List;

public interface JobService {
    List<JobEntity> FindAll();
    void createJob(JobEntity jobEntity);
    JobEntity findJobById(Long id);
    boolean removeJobById(Long id);
    JobEntity updatejob(Long id, JobEntity jobEntity);
}
