package edu.sandau.b230111.b23011129.controller;

import edu.sandau.b230111.b23011129.model.Grade;
import edu.sandau.b230111.b23011129.model.Grade;
import edu.sandau.b230111.b23011129.service.GradeService;
import edu.sandau.b230111.b23011129.service.GradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("grade")
public class GradeController {
    private static final Logger log = LoggerFactory.getLogger(GradeController.class);
    @Autowired
    private GradeService gradeService;

    @RequestMapping("list")
    public String list(ModelMap map, Grade grade){
        log.info("list");
        if ("".equals(grade.getName()))
        {
            log.info("Grade name is empty");
            grade.setName(null);
        }
        map.put("gradelist",gradeService.findAll(grade));
        return "grade/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        gradeService.deleteById(id);
        return "redirect:/grade/list";
    }

    @RequestMapping("create")
    public String create(){
        return"grade/create";
    }

    @RequestMapping("save")
    public String save(Grade g) {
        if(g.getId() == null){
            g.setId(UUID.randomUUID().toString());
            gradeService.save(g);
        }
        else{
            gradeService.update(g);
        }
        return "redirect:/grade/list";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable String id,ModelMap map) {
        Grade g =gradeService.getReferenceById(id);
        map.put("grade",g);
        return "grade/update";
    }
}
