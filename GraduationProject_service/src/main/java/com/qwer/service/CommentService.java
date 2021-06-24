package com.qwer.service;

import com.qwer.domain.Comment;
import com.qwer.domain.Comment_reply;

import java.util.List;

public interface CommentService {
    List<Comment> findAll(int bid);

    boolean addComment(Comment comment);

    boolean addReply(Comment_reply comment_reply);

    List<Comment> findAlll(int page, int size);

    void deleteComment(int cid);

    Comment findByCid(int cid);

    void deleteReply(int rid);
}
