package com.school.dto;

import lombok.Data;

@Data
public class StudentDto extends UserDto {

    private String section;

    private AddressDto address;
}
