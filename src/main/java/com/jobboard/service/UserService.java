package com.jobboard.service;

import com.jobboard.domain.Role;
import com.jobboard.domain.User;

import java.util.List;

public interface UserService {

    void saveUser(User user, Role role);

    User findUserByEmail(String email);

    List<User> findAllUsers();
}
