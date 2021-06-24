package com.qwer.dao;

import com.qwer.domain.Adminn;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminnDao {


    @Select("select * from adminn where username = #{username} and password = #{password}")
    Adminn findByUP(Adminn adminn);
}
