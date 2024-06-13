package edu.sandau.b230111.b23011129.mapper;

import edu.sandau.b230111.b23011129.model.Klass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KlassMapper {
    List<Klass> findAll(String name, String major);

    @Delete("delete from klass where id=#{id}")
    void deleteById(String id);

    @Insert("insert into klass(id,name,major) values(#{id},#{name},#{major})")
    void save(Klass s);

    @Update("update klass set name = #{name}, major = #{major} where id = #{id}")
    void update(Klass s);

    @Select("select * from klass where id=#{id}")
    Klass getReferenceById(String id);
}
