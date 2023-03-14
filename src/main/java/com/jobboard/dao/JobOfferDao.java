package com.jobboard.dao;

import com.jobboard.domain.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferDao extends JpaRepository<JobOffer, Integer> {
}
