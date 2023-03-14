package com.jobboard.service;

import com.jobboard.dao.RoleDao;
import com.jobboard.dao.UserDao;
import com.jobboard.domain.Role;
import com.jobboard.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void saveUser(User user, Role role) {
        //Encrypt the password using Spring Security
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role existingRole = roleDao.findByName(role.getName());

        user.setRoles(Arrays.asList(existingRole));
        userDao.save(user);
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
