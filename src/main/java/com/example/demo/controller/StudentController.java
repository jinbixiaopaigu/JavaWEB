package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    private static Map<String,Student> students=new HashMap<>();
    static {
        Student s = new Student("jinbi","1",18);
        students.put(s.getId(),s);
        students.put("2",new Student("yininbi","2",24));
    }

    @RequestMapping("list")
    public String list(ModelMap modelMap,Student student){
        if("".equals(student.getName())){
            student.setName(null);
        }

        // 预处理age字段
        try {
            if ("".equals(student.getAge())) {
                student.setAge(null);
            }
        } catch (NumberFormatException e) {
            student.setAge(null);
        }
        modelMap.put("students", studentService.findAll(student));
        return "list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        studentService.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping("/create")
    public String create(){
        return "create";
    }

    @RequestMapping("/save")
    public String save(Student student ){
        if(student.getId()==null){
            student.setId(UUID.randomUUID().toString());
        }
        studentService.save(student);
        return "redirect:/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable String id, ModelMap map){
        Student student=studentRepository.getReferenceById(id);
        map.put("student",student);
        return "update";
    }
}
