package com.qwer.service.impl;

import com.qwer.domain.BookImgs;
import com.qwer.dao.ImageDao;
import com.qwer.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImageDao imageDao;
    @Override
    public List<BookImgs> findAll(int bid) {
        return imageDao.findAll(bid);
    }

    @Override
    public boolean deleteImgById(int id) {
        return imageDao.deleteImgById(id);
    }


}
