package com.school.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String firstLine;

    private String secondLine;

    private String city;

    private String district;

    private String state;

    private String country;

    private String pinCode;

}
