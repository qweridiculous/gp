package com.qwer.dao;

import com.qwer.domain.Major;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorDao {
    @Select("select * from major")
    public List<Major> findAll() throws Exception;

    @Delete("delete from major where id = #{id}")
    void delete(int id);

    @Insert("insert into major(name) value(#{name})")
    void add(String name);
}
