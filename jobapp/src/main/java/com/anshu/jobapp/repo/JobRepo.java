package com.anshu.jobapp.repo;

import com.anshu.jobapp.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobEntity, Long> {
}
