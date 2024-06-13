package edu.sandau.b230111.b23011129.service;

import edu.sandau.b230111.b23011129.model.Student;
import edu.sandau.b230111.b23011129.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    public Object findAll(Student student) {
        return studentRepository.findAll(Example.of(student));
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getReferenceById(String id) {
        return studentRepository.getReferenceById(id);
    }
}
