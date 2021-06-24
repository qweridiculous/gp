package com.qwer.service.impl;

import com.github.pagehelper.PageHelper;
import com.qwer.dao.CommentDao;
import com.qwer.domain.Comment;
import com.qwer.domain.Comment_reply;
import com.qwer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> findAll(int bid) {
        return commentDao.findAll(bid);
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public boolean addReply(Comment_reply comment_reply) {
        return commentDao.addReply(comment_reply);
    }

    @Override
    public List<Comment> findAlll(int page, int size) {
        PageHelper.startPage(page,size);
        return commentDao.findAlll();
    }

    @Override
    public void deleteComment(int cid) {
        commentDao.deleteByCid(cid);
    }

    @Override
    public Comment findByCid(int cid) {
        return commentDao.findByCid(cid);
    }

    @Override
    public void deleteReply(int rid) {
        commentDao.deleteReply(rid);
    }


}
