package edu.sandau.b230111.b23011129.service;

import edu.sandau.b230111.b23011129.mapper.KlassMapper;
import edu.sandau.b230111.b23011129.model.Klass;
import edu.sandau.b230111.b23011129.repository.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class KlassService {
    @Autowired
    private KlassMapper klassMapper;
    @Autowired
    private KlassRepository klassRepository;
    public Object findAll(Klass klass)
    {
        return klassRepository.findAll(Example.of(klass));
    }
    public void deleteById(String id)
    {
        klassMapper.deleteById(id);
    }
    public void save(Klass s)
    {
        klassMapper.save(s);
    }
    public Klass getReferenceById(String id)
    {
        return klassMapper.getReferenceById(id);
    }

    public void update(Klass s) {
        klassMapper.update(s);
    }
}
