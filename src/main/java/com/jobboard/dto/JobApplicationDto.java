package com.jobboard.dto;

import com.jobboard.domain.JobOffer;
import com.jobboard.domain.Student;
import lombok.Data;

import java.util.Date;

@Data
public class JobApplicationDto {

    private Student student;
    private JobOffer jobOffer;
    private Date date;

    public JobApplicationDto(){}

    public JobApplicationDto(Student student, JobOffer jobOffer, Date date) {
        this.student = student;
        this.jobOffer = jobOffer;
        this.date = date;
    }
}
