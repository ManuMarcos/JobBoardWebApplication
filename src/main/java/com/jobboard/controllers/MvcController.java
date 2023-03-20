package com.jobboard.controllers;

import com.jobboard.domain.*;
import com.jobboard.dto.JobOfferDto;
import com.jobboard.service.CareerService;
import com.jobboard.service.JobService;
import com.jobboard.service.UserService;
import com.jobboard.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class MvcController {

    @Autowired
    private JobService jobService;

    @Autowired
    private CareerService careerService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<JobOffer> jobOffers = jobService.findAllJobOffers();
        model.addAttribute("jobOffers", jobOffers);
        return "index";
    }

    @GetMapping("/posts")
    public String getMyPosts(Model model, Authentication authentication){
        List<JobOffer> jobOffers = jobService.findAllJobOffersByRecruiter(authentication.getName());
        model.addAttribute("jobOffers", jobOffers);
        return "myPosts";
    }

    @GetMapping("/posts/create")
    public String createJobOffer(Model model){
        JobOfferDto jobOffer = new JobOfferDto();
        model.addAttribute("jobOffer", jobOffer);
        return "createPost";
    }

    @PostMapping("/posts/save")
    public String saveJobOffer(@ModelAttribute("jobOffer") JobOfferDto jobOffer, Authentication authentication){
        log.info("Ejecutando MvcController - saveJobOffer");
        //Date date = Calendar.getInstance().getTime();
        //jobOffer.setCreatedAt((java.sql.Date) date);
        jobOffer.setRecruiterEmail(authentication.getName());
        jobService.saveJobOffer(jobOffer);
        return "myPosts";
    }

    @GetMapping("/posts/{postId}")
    public String showPost(@PathVariable("postId") Integer postId, Model model, Authentication authentication){
        model.addAttribute("jobOffer", jobService.findJobOfferById(postId));
        return "jobOfferData";
    }

    @GetMapping("/userData")
    public String userData(Model model, HttpServletRequest request, Authentication authentication){
        if (request.isUserInRole("ROLE_STUDENT")){
            Student student = (Student) userService.findUserByEmail(authentication.getName());
            model.addAttribute("user", student);
        }
        else{
            Recruiter recruiter = (Recruiter) userService.findUserByEmail(authentication.getName());
            model.addAttribute("user", recruiter);
        }
        model.addAttribute("careers",careerService.findAllCareers());
        return "userData";
    }

    @PostMapping("/apply")
    public String applyJobOffer(Authentication authentication, Integer jobOfferId){
        jobService.saveJobApplication(jobOfferId, authentication.getName());
        return "index";
    }

    @GetMapping("/jobsApplied")
    public String jobsApplied(Model model, Authentication authentication){
        List<JobApplication> jobApplications = jobService.findJobApplicationsByStudentEmail(authentication.getName());
        List<JobOffer> jobOffers = new ArrayList<>();
        for(JobApplication jobApplication : jobApplications){
            jobOffers.add(jobApplication.getJobOffer());
        }
        model.addAttribute("jobOffers", jobOffers);
        return "index";
    }
}
