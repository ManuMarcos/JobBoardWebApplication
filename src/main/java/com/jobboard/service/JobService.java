package com.jobboard.service;

import com.jobboard.domain.JobApplication;
import com.jobboard.domain.JobOffer;
import com.jobboard.dto.JobOfferDto;

import java.util.List;

public interface JobService {

    List<JobOffer> findAllJobOffers();

    List<JobOffer> findAllJobOffersByRecruiter(String emailRecruiter);

    List<JobApplication> findJobApplicationsByStudentEmail(String studentEmail);

    List<JobApplication> findJobApplicationsByJobOfferId(Integer jobOfferId);

    void saveJobOffer(JobOfferDto jobOfferDto);

    void deleteJobOffer(Integer jobOfferId);

    JobOfferDto findJobOfferById(Integer jobOfferId);

    void saveJobApplication(Integer jobOfferId, String studentEmail);

    boolean studentHasApplied(String studentEmail, Integer jobOfferId);



}
