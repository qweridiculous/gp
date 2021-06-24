package com.qwer.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Books implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String introduce;  //介绍
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate; //创建时间
    private String img; //列表页图片
    private Integer mid;  //所属分类
    private Integer uid;  //创建者id
    private Users user; //创建者
    private List<BookImgs> imgs; //详情图
    private Integer offShelf; //是否下架
    private String offShelfStr; //是否下架

    private List<MultipartFile> files; //文件上传列表

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", createDate=" + createDate +
                ", img='" + img + '\'' +
                ", mid=" + mid +
                ", uid=" + uid +
                ", user=" + user +
                ", imgs=" + imgs +
                '}';
    }

    public String getOffShelfStr() {
        if (offShelf == 1){
            return "已下架";
        }else{
            return "在售";
        }
    }

    public void setOffShelfStr(String offShelfStr) {
        this.offShelfStr = offShelfStr;
    }

    public Integer getOffShelf() {
        return offShelf;
    }

    public void setOffShelf(Integer offShelf) {
        this.offShelf = offShelf;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<BookImgs> getImgs() {
        return imgs;
    }

    public void setImgs(List<BookImgs> imgs) {
        this.imgs = imgs;
    }
}
