package com.qwer.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users implements Serializable {
    private Integer id;
    private String username;
    private String phoneNum;
    private String email;
    private String studentNum;
    private String gender;
    private String major;
    private String password;
    private String status;
    private String statusStr;
    private String code;
    private int sellCount;
    private int ban;
    private String banStr;
    private List<Books> booksList;

    public String getStatusStr() {
        if ("Y".equals(status)){
            return "已激活";
        }else {
            return "未激活";
        }
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getBanStr() {
        if (ban == 0){
            return "正常";
        }else {
            return "被封禁";
        }
    }

    public void setBanStr(String banStr) {
        this.banStr = banStr;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", sellCount=" + sellCount +
                ", ban=" + ban +
                ", booksList=" + booksList +
                '}';
    }
}
