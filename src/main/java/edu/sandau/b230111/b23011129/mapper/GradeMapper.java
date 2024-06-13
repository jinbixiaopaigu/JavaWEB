package edu.sandau.b230111.b23011129.mapper;

import edu.sandau.b230111.b23011129.model.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeMapper {
    List<Grade> findAll(String name, Integer java,Integer python,Integer c);

    @Delete("delete from grade where id=#{id}")
    void deleteById(String id);

    @Insert("insert into grade(id,name,java,python,c) values(#{id},#{name},#{java},#{python},#{c})")
    void save(Grade g);

    @Update("update grade set name = #{name}, java = #{java}, python = #{python}, c = #{c} where id = #{id}")
    void update(Grade g);

    @Select("select * from grade where id=#{id}")
    Grade getReferenceById(String id);
}
