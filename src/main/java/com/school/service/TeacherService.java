package com.school.service;

import com.school.entity.Teacher;
import com.school.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    Logger logger = LoggerFactory.getLogger(TeacherService.class);

    public Teacher addTeacher(Teacher teacher) {
        logger.info("Add teacher request received, Name of Teacher: {}", teacher.getName());
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        logger.info("Get all teacher request received");
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Long id) {
        logger.info("Get teacher request received for teacher id: {}", id);
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        logger.warn("Teacher record not found for id: {}", id);
        return null;
    }

    public void deleteTeacher(Long id) {
        logger.info("Delete teacher request received for teacher id: {}", id);
        teacherRepository.deleteById(id);
    }

}
