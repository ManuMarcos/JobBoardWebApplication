package com.jobboard.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Data
@Table(name = "job_application")
public class JobApplication implements Serializable {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    JobOffer jobOffer;

    private Date date;


}
