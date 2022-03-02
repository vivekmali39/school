package com.school.dto;

import com.school.domain.Gender;
import com.school.domain.Role;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {

    private String email;

    private String name;

    private Gender gender;

    private LocalDate dateOfBirth;

    private List<Role> roles;
}
