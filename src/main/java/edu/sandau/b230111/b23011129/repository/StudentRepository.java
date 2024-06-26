package edu.sandau.b230111.b23011129.repository;

import edu.sandau.b230111.b23011129.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByNameAndAge(String name, Integer age);

    List<Student> findByNameOrAge(String name, Integer age);

    @Query(nativeQuery = true,value = "select * from student where name = ?1")
    List<Student> findByNativeQuery(String name);
}
