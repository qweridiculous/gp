package com.qwer.controller;

import com.qwer.domain.Comment;
import com.qwer.domain.Comment_reply;
import com.qwer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/findComment.do")
    @ResponseBody
    public List<Comment> findComment(int bid) throws Exception{
        List<Comment> commentList = commentService.findAll(bid);
        return commentList;
    }

    @RequestMapping("/addComment.do")
    @ResponseBody
    public boolean addComment(Comment comment) throws Exception{
        comment.setComment_time(new Date());
        boolean flag = commentService.addComment(comment);
        return flag;
    }

    @RequestMapping("/addReply.do")
    @ResponseBody
    public boolean addReply(Comment_reply comment_reply) throws Exception{
        comment_reply.setReply_time(new Date());
        boolean flag = commentService.addReply(comment_reply);
        return flag;
    }
}
