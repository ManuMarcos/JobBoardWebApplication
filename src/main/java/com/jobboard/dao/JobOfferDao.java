package com.jobboard.dao;

import com.jobboard.domain.JobOffer;
import com.jobboard.domain.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferDao extends JpaRepository<JobOffer, Integer> {

    List<JobOffer> findAllByRecruiter(Recruiter recruiter);
}
