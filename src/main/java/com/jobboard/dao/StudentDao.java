package com.jobboard.dao;

import com.jobboard.domain.Student;
import com.jobboard.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends UserBaseDao<Student> {


}
