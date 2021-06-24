package com.qwer.domain;

import java.io.Serializable;

public class BookImgs implements Serializable {
    private Integer id;
    private Integer bid;
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "BookImgs{" +
                "id=" + id +
                ", bid=" + bid +
                ", img='" + img + '\'' +
                '}';
    }
}
