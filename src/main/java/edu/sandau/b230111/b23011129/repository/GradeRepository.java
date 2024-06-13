package edu.sandau.b230111.b23011129.repository;

import edu.sandau.b230111.b23011129.model.Grade;
import edu.sandau.b230111.b23011129.model.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,String> {

}
