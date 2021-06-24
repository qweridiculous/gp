package com.qwer.service;

import com.qwer.domain.Books;

import java.util.List;

public interface BooksService {
    public List<Books> findAll(int mid, int currentPage, String sword) throws Exception;

    public List<Books> findAlll(int page,int size);

    Books findById(int id);

    boolean addBook(Books books);

    List<Books> findByUid(int uid);

    boolean deleteBook(int id);

    public boolean updateBook(Books books);

    boolean adminUpdateBook(Books books);

    boolean setOffShelf(int id);

    boolean setOnShelf(int id);

    List<Books> findByWord(String sword);
}
