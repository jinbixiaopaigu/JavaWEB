package edu.sandau.b230111.b23011129.repository;

import edu.sandau.b230111.b23011129.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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