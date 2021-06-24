package com.qwer.dao;


import com.qwer.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from users where username = #{username} and password = #{password}")
    public Users findByUP(@Param("username") String username, @Param("password") String password) throws Exception;

    @Insert("insert into users(username,phoneNum,email,studentNum,gender,major,password,status,code)  " +
            " values(#{username},#{phoneNum},#{email},#{studentNum},#{gender},#{major},#{password},#{status},#{code}) ")
    public void addUser(Users users) throws Exception;

    @Select("select * from users where username = #{username}")
    public Users findByUsername(String username) throws Exception;

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "email", column = "email"),
            @Result(property = "studentNum", column = "studentNum"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "major", column = "major"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "code", column = "code"),
            @Result(property = "sellCount", column = "sellCount"),
            @Result(property = "ban", column = "ban"),
            @Result(property = "booksList", column = "id", javaType = List.class,
                    many = @Many(select = "com.qwer.dao.BooksDao.findByUid"))
    })
    public Users findById(int id);

    @Update("update users set phoneNum = #{phoneNum},email = #{email}," +
            "studentNum = #{studentNum},password = #{password} where id = #{id}")
    boolean updateUser(Users users);

    @Update("update users set sellCount = sellCount + 1 where id = #{id}")
    void updateSellCount(int id);

    @Select("select * from users where code = #{code}")
    Users findByCode(String code);

    @Update("update users set status = 'Y' where id = #{id}")
    void updateStatus(Integer id);

    @Select("select username from users where id = #{id}")
    String findUsernameById(int id);

    @Select("select * from users")
    List<Users> findAll();

    @Update("update users set ban = 1 where id = #{id}")
    void banById(int id);
}
