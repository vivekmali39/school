package com.school.service;

import com.school.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    Logger logger = LoggerFactory.getLogger(StudentServiceTest.class);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void convertToDto() {
        logger.info("Entity to DTO conversion started.");
        Student student = new Student();
    }

    @Test
    void convertToEntity() {
    }
}