package com.example.demo.controller;

import com.example.demo.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private static List<Student> students=new ArrayList<>();
    static {
        Student s = new Student("jinbi","1");
        students.add(s);
        students.add(new Student("yininbi","2"));
    }

    @RequestMapping("list")
    public String list(ModelMap modelMap){
        modelMap.put("students",students);
        return "list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
//        System.out.println("id:"+id);
        log.warn("id:"+(Integer.parseInt(id)-1)+"");
//        students.remove(Integer.parseInt(id)-1);
        students.removeIf(student -> Integer.parseInt(student.getId()) == (Integer.parseInt(id)));
        return "redirect:/list";
    }

    @RequestMapping("/create")
    public String create(){
        return "create";
    }

    @RequestMapping("/save")
    public String save(Student student ){
        log.warn("student:"+student.getName());
        student.setId(String.valueOf(students.size()+1));
        students.add(student);
        return "redirect:/list";
    }
}
