package edu.sandau.b230111.b23011129.controller;

import edu.sandau.b230111.b23011129.model.Klass;
import edu.sandau.b230111.b23011129.service.KlassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("klass")
public class KlassController {
    private static final Logger log = LoggerFactory.getLogger(KlassController.class);
    @Autowired
    private KlassService klassService;

    @RequestMapping("list")
    public String list(ModelMap map,Klass klass){
        log.info("list");
        if ("".equals(klass.getName()))
        {
            log.info("Klass name is empty");
            klass.setName(null);
        }
        if ("".equals(klass.getMajor()))
        {
            log.info("Klass major  is empty");
            klass.setMajor(null);
        }
//        log.info("Klass name is {}", klass.getName());
        map.put("klasslist",klassService.findAll(klass));
        return "klass/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        klassService.deleteById(id);
        return "redirect:/klass/list";
    }

    @RequestMapping("create")
    public String create(){
        return"klass/create";
    }

    @RequestMapping("save")
    public String save(Klass s) {
        if(s.getId() == null){
            s.setId(UUID.randomUUID().toString());
            klassService.save(s);
        }
        else{
            klassService.update(s);
        }
        return "redirect:/klass/list";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable String id,ModelMap map) {
        Klass s =klassService.getReferenceById(id);
        map.put("klass",s);
        return "klass/update";
    }
}
