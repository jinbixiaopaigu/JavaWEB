package edu.sandau.b230111.b23011129.service;

import edu.sandau.b230111.b23011129.mapper.GradeMapper;
import edu.sandau.b230111.b23011129.model.Grade;
import edu.sandau.b230111.b23011129.model.Klass;
import edu.sandau.b230111.b23011129.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GradeService {
    private static final Logger log = LoggerFactory.getLogger(GradeService.class);
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private GradeRepository gradeRepository;
    public Object findAll(Grade grade)
    {
        log.info("name");
        return gradeRepository.findAll(Example.of(grade));
    }
    public void deleteById(String id)
    {
        gradeMapper.deleteById(id);
    }
    public void save(Grade g)
    {
        gradeMapper.save(g);
    }
    public Grade getReferenceById(String id)
    {
        return gradeMapper.getReferenceById(id);
    }

    public void update(Grade g) {
        gradeMapper.update(g);
    }
}
