package com.example.demo.service;


import com.example.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void findAll() {
        Student student1 = new Student();
        student1.setName("yinbi");
        List<Student> students = (List<Student>) studentService.findAll(student1);
        assertNotNull(students);
        assertEquals(students.size(), 1);
    }
}