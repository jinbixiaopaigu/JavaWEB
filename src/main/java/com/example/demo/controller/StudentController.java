package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;


    private static Map<String,Student> students=new HashMap<>();
    static {
        Student s = new Student("jinbi","1");
        students.put(s.getId(),s);
        students.put("2",new Student("yininbi","2"));
    }

    @RequestMapping("list")
    public String list(ModelMap modelMap){
        modelMap.put("students", studentRepository.findAll());
        return "list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        studentRepository.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping("/create")
    public String create(){
        return "create";
    }

    @RequestMapping("/save")
    public String save(Student student ){
        if(student.getId()==null){
            student.setId(String.valueOf(students.size()+1));
        }
        students.put(student.getId(),student);
        return "redirect:/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable String id, ModelMap map){
        Student student=students.get(id);
        map.put("student",student);
        return "update";
    }
}
