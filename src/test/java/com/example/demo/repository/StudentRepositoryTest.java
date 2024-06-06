package com.example.demo.repository;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findByName() {
        List<Student> students = studentRepository.findByName("yinbi");
        Assertions.assertNotNull(students);
        Assertions.assertEquals(1,students.size());
    }

    @Test
    void findAll() {
        List<Student> students = studentRepository.findAll();
        Assertions.assertNotNull(students);
        Assertions.assertEquals(32,students.size());
    }
}