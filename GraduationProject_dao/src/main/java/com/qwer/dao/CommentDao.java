package com.qwer.dao;

import com.qwer.domain.Comment;
import com.qwer.domain.Comment_reply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    @Select("select * from comment where bid = #{bid}")
    @Results({
            @Result(id = true, property = "comment_id", column = "comment_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "bid", column = "bid"),
            @Result(property = "content", column = "content"),
            @Result(property = "comment_time", column = "comment_time"),
            @Result(property = "username", column = "uid", javaType = String.class,
                    one = @One(select = "com.qwer.dao.UserDao.findUsernameById")),
            @Result(property = "comment_replies", column = "comment_id", javaType = List.class,
                    many = @Many(select = "com.qwer.dao.CommentDao.findReplies"))
    })
    List<Comment> findAll(int bid);

    @Select("select * from comment_reply where comment_id = #{comment_id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "comment_id", column = "comment_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "content", column = "content"),
            @Result(property = "reply_time", column = "reply_time"),
            @Result(property = "replyed_id", column = "replyed_id"),
            @Result(property = "username", column = "uid", javaType = String.class,
                    one = @One(select = "com.qwer.dao.UserDao.findUsernameById")),
            @Result(property = "replyed_name", column = "replyed_id", javaType = String.class,
                    one = @One(select = "com.qwer.dao.UserDao.findUsernameById"))
    })
    List<Comment_reply> findReplies(int comment_id);

    @Insert("insert into comment(uid,bid,content,comment_time) values(#{uid},#{bid},#{content},#{comment_time})")
    boolean addComment(Comment comment);

    @Insert("insert into comment_reply(comment_id,uid,content,reply_time,replyed_id) " +
            " values(#{comment_id},#{uid},#{content},#{reply_time},#{replyed_id})")
    boolean addReply(Comment_reply comment_reply);

    @Delete("delete from comment where bid = #{id}")
    boolean deleteByBid(int bid);

    @Select("select * from comment")
    @Results({
            @Result(id = true, property = "comment_id", column = "comment_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "bid", column = "bid"),
            @Result(property = "content", column = "content"),
            @Result(property = "comment_time", column = "comment_time"),
            @Result(property = "username", column = "uid", javaType = String.class,
                    one = @One(select = "com.qwer.dao.UserDao.findUsernameById")),
            @Result(property = "bookname", column = "bid", javaType = String.class,
                    one = @One(select = "com.qwer.dao.BooksDao.findNameById")),
            @Result(property = "comment_replies", column = "comment_id", javaType = List.class,
                    many = @Many(fetchType = FetchType.LAZY,select = "com.qwer.dao.CommentDao.findReplies"))
    })
    List<Comment> findAlll();

    @Delete("delete from comment where comment_id = #{cid}")
    void deleteByCid(int cid);

    @Select("select * from comment where comment_id = #{cid}")
    @Results({
            @Result(id = true, property = "comment_id", column = "comment_id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "bid", column = "bid"),
            @Result(property = "content", column = "content"),
            @Result(property = "comment_time", column = "comment_time"),
            @Result(property = "username", column = "uid", javaType = String.class,
                    one = @One(select = "com.qwer.dao.UserDao.findUsernameById")),
            @Result(property = "bookname", column = "bid", javaType = String.class,
                    one = @One(select = "com.qwer.dao.BooksDao.findNameById")),
            @Result(property = "comment_replies", column = "comment_id", javaType = List.class,
                    many = @Many(select = "com.qwer.dao.CommentDao.findReplies"))
    })
    Comment findByCid(int cid);

    @Delete("delete from comment_reply where reply_id = #{rid}")
    void deleteReply(int rid);
}
