package com.qwer.dao;

import com.qwer.domain.BookImgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao {

    @Select("select * from img where bid = #{id} ")
    List<BookImgs> findById(int id) throws Exception;

    @Insert("insert into img(bid,img) values(#{img.bid},#{img.img})")
    boolean addImg(@Param("img") BookImgs bookImgs);

    @Delete("delete from img where bid = #{bid}")
    boolean deleteByBid(int bid);

    @Select("select * from img where bid = #{bid}")
    List<BookImgs> findAll(int bid);

    @Delete("delete from img where id = #{id}")
    boolean deleteImgById(int id);
}
