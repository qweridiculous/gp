package com.qwer.service.impl;

import com.github.pagehelper.PageHelper;
import com.qwer.MailUtils;
import com.qwer.UuidUtil;
import com.qwer.dao.BooksDao;
import com.qwer.dao.UserDao;
import com.qwer.domain.Books;
import com.qwer.domain.Users;
import com.qwer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BooksDao booksDao;
    @Override
    public Users findByUP(Users users) throws Exception {
        return userDao.findByUP(users.getUsername(), users.getPassword());
    }

    @Override
    public Boolean addUser(Users users) throws Exception {
        Users byUsername = userDao.findByUsername(users.getUsername());
        if (byUsername != null) {
            return false;
        }
        users.setStatus("N");
        String activeCode = UuidUtil.getUuid();
        users.setCode(activeCode);
        userDao.addUser(users);


        String content = "<a href='http://localhost:8080/GraduationProject/user/activeUser.do?code=" + users.getCode() + "'>点击激活【二手图书信息】账号</a>";

        MailUtils.sendMail(users.getEmail(), content, "激活邮件");

        return true;
    }

    @Override
    public boolean updateUser(Users users) {
        return userDao.updateUser(users);
    }

    @Override
    public boolean active(String code) {
        Users users = userDao.findByCode(code);
        if (users != null) {
            userDao.updateStatus(users.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Users> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    @Override
    public void banById(int id) {
        userDao.banById(id);
    }

    @Override
    public List<Books> findById(int id) {
        return booksDao.findByUid(id);
    }
}
