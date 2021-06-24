package com.qwer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment_reply {

    private Integer reply_id;
    private Integer comment_id;
    private Integer uid;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date reply_time;
    private Integer replyed_id;

    private String replyed_name; //被回复者用户名
    private String username; //回复者用户名


    public String getReplyed_name() {
        return replyed_name;
    }

    public void setReplyed_name(String replyed_name) {
        this.replyed_name = replyed_name;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public Integer getReplyed_id() {
        return replyed_id;
    }

    public void setReplyed_id(Integer replyed_id) {
        this.replyed_id = replyed_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReply_time() {
        return reply_time;
    }

    public void setReply_time(Date reply_time) {
        this.reply_time = reply_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
