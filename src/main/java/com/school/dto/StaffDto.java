package com.school.dto;

import com.school.domain.StaffType;
import lombok.Data;

@Data
public class StaffDto extends UserDto {

    private StaffType type;

    private String department;

    private AddressDto address;

}
