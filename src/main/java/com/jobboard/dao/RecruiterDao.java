package com.jobboard.dao;

import com.jobboard.domain.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterDao extends JpaRepository<Recruiter, Integer> {
}
