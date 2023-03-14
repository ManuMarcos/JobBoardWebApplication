package com.jobboard.dao;

import com.jobboard.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerDao extends JpaRepository<Career, Integer> {
}
