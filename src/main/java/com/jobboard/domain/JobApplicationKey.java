package com.jobboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class JobApplicationKey implements Serializable {

    @Column(name = "job_offer_id")
    Integer jobOfferId;

    @Column(name = "student_id")
    Integer studentId;

    public JobApplicationKey(Integer jobOfferId, Integer studentId) {
        this.jobOfferId = jobOfferId;
        this.studentId = studentId;
    }

    public JobApplicationKey() {

    }
}
