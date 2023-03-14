package com.jobboard.controllers;

import com.jobboard.domain.Role;
import com.jobboard.domain.User;
import com.jobboard.service.RoleService;
import com.jobboard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        //Create model objet to store form data
        User user = new User();
        Role role = new Role();
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("role", role);
        model.addAttribute("roles", roles);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") User user, @ModelAttribute("Role") Role role,  BindingResult result, Model model){
        User existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }

        log.info("Ejecutando AuthController(/register/save) Email: " + user.getEmail() + " Rol: " + role.getName());

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }

        userService.saveUser(user, role);
        return "redirect:/register?success";
    }
}
