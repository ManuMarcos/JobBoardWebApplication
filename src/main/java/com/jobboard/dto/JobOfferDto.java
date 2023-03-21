package com.jobboard.dto;

import com.jobboard.domain.JobApplication;
import com.jobboard.enumerations.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class JobOfferDto {

    private Integer id;
    private String companyLogoLink;
    private Date createdAt;
    private String description;
    private String title;
    private String recruiterEmail;
    private String company;
    private Status status;

    private List<JobApplicationDto> jobApplications;

    public JobOfferDto(){}

    public JobOfferDto(Integer id, String companyLogoLink, Date createdAt, String description, String title, String recruiterEmail, String company, Status status) {
        this.id = id;
        this.companyLogoLink = companyLogoLink;
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
        this.recruiterEmail = recruiterEmail;
        this.company = company;
        this.status = status;
    }

    public JobOfferDto(Integer id, String companyLogoLink, Date createdAt, String description, String title, String recruiterEmail, String company, Status status, List<JobApplicationDto> jobApplications) {
        this.id = id;
        this.companyLogoLink = companyLogoLink;
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
        this.recruiterEmail = recruiterEmail;
        this.company = company;
        this.status = status;
        this.jobApplications = jobApplications;
    }
}
