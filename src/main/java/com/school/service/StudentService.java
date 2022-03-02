package com.school.service;

import com.school.dto.StudentDto;
import com.school.entity.Student;
import com.school.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentDto addStudent(StudentDto studentDto) {
        logger.info("Add student request received for student name: {}", studentDto.getName());
        Student student = studentRepository.save(convertToEntity(studentDto));
        return convertToDto(student);
    }

    public List<StudentDto> getAllStudents() {
        logger.info("Get all students request received");
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public StudentDto getStudent(Long id) {
        logger.info("Get student request received for student id: {}", id);
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return convertToDto(student.get());
        }
        logger.warn("Student record is not present for id: {}", id);
        return null;
    }

    public void deleteStudent(Long id) {
        logger.info("Delete student request received for student id: {}", id);
        studentRepository.deleteById(id);
    }

    private StudentDto convertToDto(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    private Student convertToEntity(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }

}
