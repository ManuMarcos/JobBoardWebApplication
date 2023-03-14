package com.jobboard.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "job_experience")
public class JobExperience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
