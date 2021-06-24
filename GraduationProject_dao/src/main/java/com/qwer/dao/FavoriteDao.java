package com.qwer.dao;

import com.qwer.domain.Books;
import com.qwer.domain.Favorite;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDao {

    @Select("select * from favorite where uid = #{uid}")
    @Results({
            @Result(id=true,property = "bid",column = "bid"),
            @Result(id=true,property = "uid",column = "uid"),
            @Result(property = "favDate",column = "favDate"),
            @Result(property = "books",column = "bid",javaType = Books.class,
                    one = @One(select = "com.qwer.dao.BooksDao.findById"))
    })
    List<Favorite> findByUid(int uid);

    @Delete("delete from favorite where bid =#{bid}")
    boolean removeFav(int bid);

    @Insert("insert into favorite(bid,uid,favDate) values(#{bid},#{uid},#{favDate})")
    boolean addFav(Favorite favorite);

    @Select("select * from favorite where bid = #{bid} and uid = #{uid}")
    Favorite findByUB(@Param("bid") int bid, @Param("uid") int uid);

    @Select("select count(*) from favorite where bid = #{bid}")
    int getFavCount(int bid);

    @Select("SELECT bid FROM favorite GROUP BY bid ORDER BY COUNT(*) DESC LIMIT 8")
    @Results({
            @Result(id = true,property = "bid",column = "bid"),
            @Result(property = "books",column = "bid",javaType = Books.class,
                    one = @One(select = "com.qwer.dao.BooksDao.findById") )
    })
    List<Favorite> findFavByCount();
}
