package com.jobboard.service;

import com.jobboard.dao.*;
import com.jobboard.domain.JobApplication;
import com.jobboard.domain.JobOffer;
import com.jobboard.domain.Recruiter;
import com.jobboard.domain.Student;
import com.jobboard.dto.JobOfferDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobOfferDao jobOfferDao;

    @Autowired
    UserDao userDao;

    @Autowired
    JobApplicationDao jobApplicationDao;

    @Override
    public List<JobOffer> findAllJobOffers() {
        return jobOfferDao.findAll();
    }

    @Override
    public List<JobOffer> findAllJobOffersByRecruiter(String emailRecruiter) {
        Recruiter recruiter = (Recruiter) userDao.findByEmail(emailRecruiter);
        return jobOfferDao.findAllByRecruiter(recruiter);
    }

    @Override
    public List<JobApplication> findJobApplicationsByStudentEmail(String studentEmail) {
        Student student = (Student) userDao.findByEmail(studentEmail);
        return jobApplicationDao.findJobApplicationsByStudentId(student.getId());
    }

    @Transactional
    @Override
    public void saveJobOffer(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = jobOfferDtoToJobOffer(jobOfferDto);
        jobOfferDao.save(jobOffer);
    }

    @Override
    public void deleteJobOffer(Integer jobOfferId) {
        jobOfferDao.deleteById(jobOfferId);
    }

    @Override
    public JobOfferDto findJobOfferById(Integer jobOfferId) {
        JobOffer jobOffer = jobOfferDao.findById(jobOfferId).orElse(null);
        if(jobOffer != null){
            return  jobOfferToJobOfferDto(jobOffer);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveJobApplication(Integer jobOfferId, String studentEmail) {
        JobOffer jobOffer = jobOfferDao.findById(jobOfferId).orElse(null);
        Student student = (Student) userDao.findByEmail(studentEmail);
        JobApplication jobApplication = new JobApplication(student, jobOffer, null);
        jobApplicationDao.save(jobApplication);
    }


    public JobOffer jobOfferDtoToJobOffer(JobOfferDto jobOfferDto){
        Recruiter recruiter = (Recruiter) userDao.findByEmail(jobOfferDto.getRecruiterEmail());
        if (jobOfferDto.getId() != null){
            return jobOfferDao.findById(jobOfferDto.getId()).orElse(null);
        }
        return new JobOffer(jobOfferDto.getTitle(), jobOfferDto.getDescription(), jobOfferDto.getCompanyLogoLink(), jobOfferDto.getCreatedAt(), recruiter );
    }

    private JobOfferDto jobOfferToJobOfferDto(JobOffer jobOffer){
        return new JobOfferDto(jobOffer.getId(), jobOffer.getCompanyLogoLink(), jobOffer.getCreatedAt(), jobOffer.getDescription(), jobOffer.getTitle(),
                jobOffer.getRecruiter().getEmail(), jobOffer.getRecruiter().getCompany());
    }

}
