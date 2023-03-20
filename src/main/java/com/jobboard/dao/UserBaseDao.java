package com.jobboard.dao;

import com.jobboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserBaseDao<T extends User> extends JpaRepository<T, Integer> {

    T findByEmail(String email);


}
