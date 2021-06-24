package com.qwer.service;

import com.qwer.domain.Major;

import java.util.List;

public interface MajorService {
    public List<Major> findAll() throws Exception;

    public List<Major> findAlll(int page, int size) throws Exception;

    void delete(int id);

    void add(String name);
}
