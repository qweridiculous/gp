package com.qwer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Favorite implements Serializable {
    private Integer bid;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date favDate;
    private Integer uid;
    private Books books;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getFavDate() {
        return favDate;
    }

    public void setFavDate(Date favDate) {
        this.favDate = favDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "bid=" + bid +
                ", favDate=" + favDate +
                ", uid=" + uid +
                ", books=" + books +
                '}';
    }
}
