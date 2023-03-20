package com.jobboard.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Data
@Table(name = "job_application")
public class JobApplication implements Serializable {

    @EmbeddedId
    private JobApplicationKey id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("job_offer_id")
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;

    private Date date;

    public JobApplication(){}

    public JobApplication(Student student, JobOffer jobOffer, Date date){
        this.id = new JobApplicationKey(jobOffer.getId(), student.getId());
        this.student = student;
        this.jobOffer = jobOffer;
        this.date = date;
    }
}
