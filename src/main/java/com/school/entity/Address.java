package com.school.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String firstLine;
    private String secondLine;
    private String city;
    private String district;
    private String state;
    private String country;
    private String pinCode;


}
