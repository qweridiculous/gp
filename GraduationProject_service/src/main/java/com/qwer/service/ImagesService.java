package com.qwer.service;

import com.qwer.domain.BookImgs;

import java.util.List;

public interface ImagesService {

    public List<BookImgs> findAll(int bid);

    public boolean deleteImgById(int id);
}
