package com.jobboard.dao;

import com.jobboard.domain.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
}
