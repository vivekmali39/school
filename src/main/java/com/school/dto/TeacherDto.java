package com.school.dto;

import lombok.Data;
import java.util.List;

@Data
public class TeacherDto extends StaffDto {

    private List<String> subjects;

    private List<String> sections;

    private String qualification;

}
