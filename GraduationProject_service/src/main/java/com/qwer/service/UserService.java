package com.qwer.service;

import com.qwer.domain.Books;
import com.qwer.domain.Users;

import java.util.List;

public interface UserService {
    public Users findByUP(Users users) throws Exception;

    Boolean addUser(Users users) throws Exception;

    boolean updateUser(Users users);

    boolean active(String code);

    List<Users> findAll(int page, int size);

    void banById(int id);

    List<Books> findById(int id);
}
