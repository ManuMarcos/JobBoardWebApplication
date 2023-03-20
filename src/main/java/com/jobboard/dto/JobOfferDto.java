package com.jobboard.dto;

import lombok.Data;

import java.sql.Date;


@Data
public class JobOfferDto {

    private Integer id;
    private String companyLogoLink;
    private Date createdAt;
    private String description;
    private String title;
    private String recruiterEmail;
    private String company;

    public JobOfferDto(){}

    public JobOfferDto(Integer id, String companyLogoLink, Date createdAt, String description, String title, String recruiterEmail, String company) {
        this.id = id;
        this.companyLogoLink = companyLogoLink;
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
        this.recruiterEmail = recruiterEmail;
        this.company = company;
    }
}
