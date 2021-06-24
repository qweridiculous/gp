package com.qwer.service.impl;

import com.qwer.dao.AdminnDao;
import com.qwer.domain.Adminn;
import com.qwer.service.AdminnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminnServiceImpl implements AdminnService {

    @Autowired
    private AdminnDao adminnDao;
    @Override
    public Adminn findByUP(Adminn adminn) {
        return adminnDao.findByUP(adminn);
    }
}
