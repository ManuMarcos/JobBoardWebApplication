package com.jobboard.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "recruiter")
public class Recruiter extends User {

    private String company;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobOffer> jobOffers;

    public Recruiter(String email, String password, String firstName, String lastName, Role role) {
        super(email, password, firstName, lastName, role);
    }

    public Recruiter() {

    }
}
