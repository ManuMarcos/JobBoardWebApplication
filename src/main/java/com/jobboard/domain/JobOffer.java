package com.jobboard.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "job_offer")
public class JobOffer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    @Column(name = "company_logo_link")
    private String companyLogoLink;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    private Recruiter recruiter;

    @OneToMany(mappedBy = "jobOffer")
    private List<JobApplication> applications;

    public JobOffer(){}

    public JobOffer(Integer id, String title, String description, String companyLogoLink, Date createdAt, Recruiter recruiter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.companyLogoLink = companyLogoLink;
        this.createdAt = createdAt;
        this.recruiter = recruiter;
    }

    public JobOffer(String title, String description, String companyLogoLink, Date createdAt, Recruiter recruiter) {
        this.title = title;
        this.description = description;
        this.companyLogoLink = companyLogoLink;
        this.createdAt = createdAt;
        this.recruiter = recruiter;
    }
}
