package com.school.service;

import com.school.dto.TeacherDto;
import com.school.entity.Teacher;
import com.school.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(TeacherService.class);

    public TeacherDto addTeacher(TeacherDto teacherDto) {
        logger.info("Add teacher request received, Name of Teacher: {}", teacherDto.getName());
        Teacher teacher = teacherRepository.save(convertToEntity(teacherDto));
        return convertToDto(teacher);
    }

    public List<TeacherDto> getAllTeachers() {
        logger.info("Get all teacher request received");
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TeacherDto getTeacher(Long id) {
        logger.info("Get teacher request received for teacher id: {}", id);
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return convertToDto(teacher.get());
        }
        logger.warn("Teacher record not found for id: {}", id);
        return null;
    }

    public void deleteTeacher(Long id) {
        logger.info("Delete teacher request received for teacher id: {}", id);
        teacherRepository.deleteById(id);
    }

    private TeacherDto convertToDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDto.class);
    }

    private Teacher convertToEntity(TeacherDto teacherDto) {
        return modelMapper.map(teacherDto, Teacher.class);
    }

}
