package com.jobboard.dao;

import com.jobboard.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
