package com.qwer.service.impl;

import com.github.pagehelper.PageHelper;
import com.qwer.dao.*;
import com.qwer.domain.BookImgs;
import com.qwer.domain.Books;
import com.qwer.domain.Comment;
import com.qwer.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksDao booksDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private FavoriteDao favoriteDao;
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Books> findAll(int mid, int currentPage, String sword) throws Exception {
        PageHelper.startPage(currentPage, 9);
        return booksDao.findAll(mid, sword);
    }

    @Override
    public List<Books> findAlll(int page, int size) {
        PageHelper.startPage(page, size);
        return booksDao.findAlll();
    }

    @Override
    public List<Books> findByWord(String sword) {
        return booksDao.findByWord(sword);
    }

    @Override
    public Books findById(int id) {
        return booksDao.findById(id);
    }

    @Override
    public boolean addBook(Books books) {
        boolean flag = booksDao.addBook(books);

        List<BookImgs> imgs = books.getImgs();
        for (BookImgs img : imgs) {
            img.setBid(books.getId());
            imageDao.addImg(img);
        }
        userDao.updateSellCount(books.getUid());
        return flag;
    }

    @Override
    public boolean updateBook(Books books) {
        boolean flag = booksDao.updateBook(books);
        List<BookImgs> imgs = books.getImgs();
        for (BookImgs img : imgs) {
            img.setBid(books.getId());
            imageDao.addImg(img);
        }
        return flag;
    }

    @Override
    public boolean adminUpdateBook(Books books) {
        return booksDao.adminUpdateBook(books);
    }

    @Override
    public boolean setOffShelf(int id) {
        return booksDao.setOffShelf(id);
    }

    @Override
    public boolean setOnShelf(int id) {
        return booksDao.setOnShelf(id);
    }


    @Override
    public List<Books> findByUid(int uid) {
        return booksDao.findByUid(uid);
    }

    @Override
    public boolean deleteBook(int id) {
        boolean delete = imageDao.deleteByBid(id);
        if (delete) {
            favoriteDao.removeFav(id);
            commentDao.deleteByBid(id);
            return booksDao.deleteBook(id);
        }
        return false;
    }
}
