package com.qwer.dao;

import com.qwer.domain.Books;
import com.qwer.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDao {

    @Select({"<script>" +
            "select * from books " +
            " where 1 = 1 " +
            " and offShelf != 1 " +
            "<if test='mid != 0'> and mid = #{mid} </if>" +
            " <if test='sword != null'> and name like CONCAT('%',#{sword},'%') </if>" +
            "</script>"})
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "introduce", column = "introduce"),
            @Result(property = "createDate", column = "createdate"),
            @Result(property = "img", column = "img"),
            @Result(property = "mid", column = "mid"),
            @Result(property = "offShelf", column = "offShelf"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "user", column = "uid", javaType = Users.class,
                    one = @One(select = "com.qwer.dao.UserDao.findById"))
    })
    List<Books> findAll(@Param("mid") Integer mid, @Param("sword") String sword);

    @Select("select * from books where introduce like CONCAT('%',#{sword},'%') and offShelf != 1 limit 4 ")
    List<Books> findByWord(String sword);

    @Select("select * from books where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "introduce", column = "introduce"),
            @Result(property = "createDate", column = "createdate"),
            @Result(property = "img", column = "img"),
            @Result(property = "mid", column = "mid"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "offShelf", column = "offShelf"),
            @Result(property = "user", column = "uid", javaType = Users.class,
                    one = @One(select = "com.qwer.dao.UserDao.findById")),
            @Result(property = "imgs", column = "id", javaType = List.class,
                    many = @Many(select = "com.qwer.dao.ImageDao.findById"))
    })
    Books findById(int id);

    @Insert("insert into books(name,price,introduce,uid,mid,createDate,img) " +
            "values(#{books.name},#{books.price},#{books.introduce},#{books.uid}," +
            "#{books.mid},#{books.createDate},#{books.img})")
    @Options(useGeneratedKeys = true, keyProperty = "books.id", keyColumn = "id")
    boolean addBook(@Param("books") Books books);

    @Select("select * from books where uid = #{uid}")
    List<Books> findByUid(int uid);

    @Delete("delete from books where id = #{id}")
    boolean deleteBook(int id);

    @Update("update books set price = #{price} ,introduce = #{introduce} where id = #{id}")
    boolean updateBook(Books books);

    @Update("update books set name = #{name} , price = #{price} , mid = #{mid},introduce = #{introduce} where id = #{id}")
    boolean adminUpdateBook(Books books);

    @Update("update books set offShelf = 0 where id = #{id}")
    boolean setOnShelf(int id);

    @Update("update books set offShelf = 1 where id = #{id}")
    boolean setOffShelf(int id);


    @Select("select * from books")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "introduce", column = "introduce"),
            @Result(property = "createDate", column = "createdate"),
            @Result(property = "img", column = "img"),
            @Result(property = "mid", column = "mid"),
            @Result(property = "offShelf", column = "offShelf"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "user", column = "uid", javaType = Users.class,
                    one = @One(select = "com.qwer.dao.UserDao.findById"))
    })
    List<Books> findAlll();

    @Select("select name from books where id = #{id}")
    String findNameById(int id);

}
