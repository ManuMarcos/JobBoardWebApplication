package com.jobboard.dao;

import com.jobboard.domain.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {
}
