package com.jobboard.service;

import com.jobboard.domain.JobOffer;

import java.util.List;

public interface JobService {

    List<JobOffer> findAllJobOffers();

    void saveJobOffer(JobOffer jobOffer);

    void deleteJobOffer(Integer jobOfferId);

    JobOffer findJobOfferById(Integer jobOfferId);
}
