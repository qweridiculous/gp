package com.qwer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Comment {
    private Integer comment_id;
    private Integer uid;
    private Integer bid;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date comment_time;

    private String username; //评论者用户名
    private String bookname;
    private List<Comment_reply> comment_replies;

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", uid=" + uid +
                ", bid=" + bid +
                ", content='" + content + '\'' +
                ", comment_time=" + comment_time +
                ", username='" + username + '\'' +
                ", bookname='" + bookname + '\'' +
                ", comment_replies=" + comment_replies +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public List<Comment_reply> getComment_replies() {
        return comment_replies;
    }

    public void setComment_replies(List<Comment_reply> comment_replies) {
        this.comment_replies = comment_replies;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }
}
