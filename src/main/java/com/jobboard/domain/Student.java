package com.jobboard.domain;

import com.jobboard.dto.JobApplicationDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Slf4j
public class Student extends User {

    @Column(columnDefinition = "TEXT")
    private String presentationLetter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "career_id")
    private Career career;

    @OneToMany(mappedBy = "student")
    private List<JobApplication> applications;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobExperience> jobExperiences;

    public Student(Integer id, String email, String password, String firstName, String lastName, List<Role> roles) {
        super(id, email, password, firstName, lastName, roles);
    }

    public Student(String email, String password, String firstName, String lastName, Role role) {
        super(email, password, firstName, lastName, role);
    }

    public Student() {
    }




}
