package edu.sandau.b230111.b23011129.controller;

import edu.sandau.b230111.b23011129.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("stu")
    public Student stu(){
        Student student =new Student("stu","1");
        return student;
    }

    @GetMapping("list3")
    public List<Student> list(){
        List<Student> list =new ArrayList<>();
        list.add(new Student("stu","1"));
        list.add(new Student("ss","2"));
        return list;
    }
}


