package com.jobboard.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RecruiterDto extends UserDto{

    private String company;

}
