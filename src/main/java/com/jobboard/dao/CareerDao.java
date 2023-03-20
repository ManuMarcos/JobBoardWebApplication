package com.jobboard.dao;

import com.jobboard.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerDao extends JpaRepository<Career, Integer> {
}
