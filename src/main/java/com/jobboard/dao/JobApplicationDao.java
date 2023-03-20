package com.jobboard.dao;

import com.jobboard.domain.JobApplication;
import com.jobboard.domain.JobApplicationKey;
import com.jobboard.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {

    @Query(value = "SELECT * FROM job_application ja WHERE ja.student_id = ?1 ",
    nativeQuery = true)
    List<JobApplication> findJobApplicationsByStudentId(Integer studentId);
}
