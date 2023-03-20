package com.jobboard.controllers;

import com.jobboard.domain.Role;
import com.jobboard.domain.User;
import com.jobboard.dto.RoleDto;
import com.jobboard.dto.UserDto;
import com.jobboard.service.RoleService;
import com.jobboard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping("/login")
    public String login(){
        if(isAuthenticated()){
            return "redirect:/";
        }
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
        UserDto userDto = new UserDto();
        RoleDto role = new RoleDto();
        List<RoleDto> roles = roleService.findAllRoles();
        model.addAttribute("user", userDto);
        model.addAttribute("role", role);
        model.addAttribute("existingRoles", roles);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDto userDto, @ModelAttribute("Role") RoleDto roleDto,  BindingResult result, Model model){
        userDto.getRoles().add(roleDto);
        User existingUser = userService.findUserByEmail(userDto.getEmail());


        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }

        log.info("Ejecutando AuthController(/register/save) Email: " + userDto.getEmail() + " Rol: " + roleDto.getName());

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    private boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())){
            return false;
        }
        return authentication.isAuthenticated();
    }

}
