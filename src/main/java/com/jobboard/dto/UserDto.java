package com.jobboard.dto;

import com.jobboard.domain.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<RoleDto> roles = new ArrayList<>();



}
