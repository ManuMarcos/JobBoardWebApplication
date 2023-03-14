package com.jobboard.service;

import com.jobboard.dao.JobOfferDao;
import com.jobboard.domain.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobOfferDao jobOfferDao;

    @Override
    public List<JobOffer> findAllJobOffers() {
        return jobOfferDao.findAll();
    }

    @Override
    public void saveJobOffer(JobOffer jobOffer) {
        jobOfferDao.save(jobOffer);
    }

    @Override
    public void deleteJobOffer(Integer jobOfferId) {
        jobOfferDao.deleteById(jobOfferId);
    }

    @Override
    public JobOffer findJobOfferById(Integer jobOfferId) {
        return jobOfferDao.findById(jobOfferId).orElse(null);
    }
}
