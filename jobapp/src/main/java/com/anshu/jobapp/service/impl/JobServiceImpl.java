package com.anshu.jobapp.service.impl;

import com.anshu.jobapp.entities.JobEntity;
import com.anshu.jobapp.repo.JobRepo;
import com.anshu.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;

    List<JobEntity> jobEntities = new ArrayList<>();
    @Override
    public List<JobEntity> FindAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(JobEntity jobEntity) {
        jobRepo.save(jobEntity);
    }

    @Override
    public JobEntity findJobById(Long id) {
       return jobRepo.findById(id).get();
    }

    @Override
    public boolean removeJobById(Long id) {
        jobRepo.deleteById(id);
        return true;
    }

    @Override
    public JobEntity updatejob(Long id, JobEntity jobEntity) {
        JobEntity existingJobEntity = jobRepo.findById(id).get();
        existingJobEntity.setDescription(jobEntity.getDescription());
        existingJobEntity.setMinSalary(jobEntity.getMinSalary());
        existingJobEntity.setMaxSalary(jobEntity.getMaxSalary());
        existingJobEntity.setTitle(jobEntity.getTitle());
        existingJobEntity.setLocation(jobEntity.getLocation());
        jobRepo.save(existingJobEntity);
        return existingJobEntity;
    }
}
