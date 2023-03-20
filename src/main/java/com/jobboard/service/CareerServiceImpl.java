package com.jobboard.service;

import com.jobboard.dao.CareerDao;
import com.jobboard.domain.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerServiceImpl implements CareerService{

    @Autowired
    CareerDao career;

    @Override
    public List<Career> findAllCareers() {
        return career.findAll();
    }
}
