package com.school.service;

import com.school.entity.Student;
import com.school.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Student addStudent(Student student) {
        logger.info("Add student request received for student name: {}", student.getName());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        logger.info("Get all students request received");
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        logger.info("Get student request received for student id: {}", id);
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        logger.warn("Student record is not present for id: {}", id);
        return null;
    }

    public void deleteStudent(Long id) {
        logger.info("Delete student request received for student id: {}", id);
        studentRepository.deleteById(id);
    }

}
