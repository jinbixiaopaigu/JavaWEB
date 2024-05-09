package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private static List<Student> students=new ArrayList<>();
    static {
        Student s = new Student("jinbi",1);
        students.add(s);
        students.add(new Student("yininbi",2));
    }

    @RequestMapping("list")
    public String list(ModelMap modelMap){
        modelMap.put("students",students);
        return "list";
    }
}
