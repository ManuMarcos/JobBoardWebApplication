package com.jobboard.service;

import com.jobboard.dao.*;
import com.jobboard.domain.*;
import com.jobboard.dto.RoleDto;
import com.jobboard.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private RecruiterDao recruiterDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void saveUser(UserDto userDto) {
        //Encrypt the password using Spring Security
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String roleName = userDto.getRoles().get(0).getName();
        Role existingRole = roleDao.findByName(roleName);
        User user;
        switch (roleName){
            case ("ROLE_RECRUITER"):
                user = new Recruiter(userDto.getEmail(), userDto.getPassword(), userDto.getFirstName(), userDto.getLastName(),
                        existingRole);
                userDao.save(user);
                break;
            case "ROLE_STUDENT":
                user = new Student(userDto.getEmail(), userDto.getPassword(), userDto.getFirstName(), userDto.getLastName(),
                        existingRole);
                userDao.save(user);
                break;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }




}
