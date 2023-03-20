package com.jobboard.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDto extends UserDto{

    private String presentationLetter;
    private CareerDto career;

}
