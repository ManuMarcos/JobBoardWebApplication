package com.jobboard.service;

import com.jobboard.domain.*;
import com.jobboard.dto.RoleDto;
import com.jobboard.dto.UserDto;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<User> findAllUsers();



}
