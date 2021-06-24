package com.qwer.service.impl;

import com.github.pagehelper.PageHelper;
import com.qwer.domain.Major;
import com.qwer.service.MajorService;
import com.qwer.dao.MajorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorDao majorDao;

    @Override
    public List<Major> findAll() throws Exception{
        return majorDao.findAll();
    }

    @Override
    public List<Major> findAlll(int page, int size) throws Exception{
        PageHelper.startPage(page,size);
        return majorDao.findAll();
    }

    @Override
    public void delete(int id) {
        majorDao.delete(id);
    }

    @Override
    public void add(String name) {
        majorDao.add(name);
    }
}
