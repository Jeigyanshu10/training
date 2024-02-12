package com.anshu.jobapp.repo;

import com.anshu.jobapp.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity,Long> {
}
