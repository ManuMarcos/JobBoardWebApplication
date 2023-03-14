package com.jobboard.controllers;

import com.jobboard.domain.JobOffer;
import com.jobboard.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class MvcController {

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<JobOffer> jobOffers = jobService.findAllJobOffers();
        model.addAttribute("jobOffers", jobOffers);
        return "index";
    }

}
