package com.school.controller;

import com.school.dto.StudentDto;
import com.school.entity.Student;
import com.school.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    @ApiOperation(value = "Add new student in school system",
            notes = "Add new student in school system, this api will create new student record in school system.",
            response = StudentDto.class)
    public StudentDto addStudent(@RequestBody StudentDto student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    @ApiOperation(value = "Fetch details of all students",
            notes = "This API will fetch details of all students in school system.")
    public List<StudentDto> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    @ApiOperation(value = "Fetch details of student by id",
            notes = "Fetch details of student in school system based on id.",
            response = Student.class)
    public StudentDto getStudent(@ApiParam(value = "ID value for the student", required = true)
                                 @PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/students/{id}")
    @ApiOperation(value = "Delete student details from school",
            notes = "Delete details of student from school system based on id.")
    public void deleteStudent(@ApiParam(value = "ID value for the student you want to delete from school system.", required = true)
                              @PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
