package com.school.controller;

import com.school.dto.TeacherDto;
import com.school.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teachers")
    @ApiOperation(value = "Add new teacher in school system",
            notes = "Add new teacher in school system, this api will create new teacher record in school system.",
            response = TeacherDto.class)
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    @GetMapping("/teachers")
    @ApiOperation(value = "Fetch details of all teachers",
            notes = "This API will fetch details of all teachers in school system.")
    public List<TeacherDto> getAllTeacher() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers/{id}")
    @ApiOperation(value = "Fetch details of teacher by id",
            notes = "Fetch details of teacher in school system based on id.",
            response = TeacherDto.class)
    public TeacherDto getTeacher(@ApiParam(value = "ID value for the teacher", required = true)
                                 @PathVariable("id") Long id) {
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("/teachers/{id}")
    @ApiOperation(value = "Delete teacher details from school",
            notes = "Delete details of teacher from school system based on id.")
    public void deleteTeacher(@ApiParam(value = "ID value for the teacher you want to delete from school system.", required = true)
                              @PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
    }
}
