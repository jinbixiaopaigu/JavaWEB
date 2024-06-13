package edu.sandau.b230111.b23011129.controller;

import edu.sandau.b230111.b23011129.model.Student;
import edu.sandau.b230111.b23011129.service.StudentService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.UUID;

@Controller
@RequestMapping("student")
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("list")
    public String list(ModelMap map, Student student){
        if ("".equals(student.getName()))
        {
            student.setName(null);
        }
        map.put("studentlist",studentService.findAll(student));
        return "student/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        studentService.deleteById(id);
        return "redirect:/student/list";
    }

    @RequestMapping("/create")
    public String create(){
        return "/student/create";
    }

    @RequestMapping("/save")
    public String save(Student student ){
        if(student.getId()==null){
            student.setId(UUID.randomUUID().toString());
        }
        studentService.save(student);
        return "redirect:/student/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable String id, ModelMap map){
        Student student=studentService.getReferenceById(id);
        map.put("student",student);
        return "/student/update";
    }
}
