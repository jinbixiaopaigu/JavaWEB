package edu.sandau.b230111.b23011129.repository;

import edu.sandau.b230111.b23011129.model.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KlassRepository extends JpaRepository<Klass,String> {

    List<Klass> findByNameAndMajor(String name,String major);
    @Query(nativeQuery = true,value = "select * from klass where name=?1")
    List<Klass> findByNativeQuery(String name);
}
