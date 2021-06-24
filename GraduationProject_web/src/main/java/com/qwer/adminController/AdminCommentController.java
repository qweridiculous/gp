package com.qwer.adminController;

import com.github.pagehelper.PageInfo;
import com.qwer.domain.Comment;
import com.qwer.domain.Comment_reply;
import com.qwer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/adminComment")
public class AdminCommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<Comment> commentList = commentService.findAlll(page,size);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(commentList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("comment-list");
        return mv;
    }

    @RequestMapping("/deleteComment.do")
    public String deleteComment(int cid){
        commentService.deleteComment(cid);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteReply.do")
    public String deleteReply(int rid){
        commentService.deleteReply(rid);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findByCid.do")
    public ModelAndView findByCid(int cid){
        ModelAndView mv = new ModelAndView();
        Comment comment = commentService.findByCid(cid);
        mv.addObject("comment",comment);
        mv.setViewName("comment-show");
        return mv;
    }
}
