package com.qwer.adminController;

import com.github.pagehelper.PageInfo;
import com.qwer.domain.Books;
import com.qwer.domain.Users;
import com.qwer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<Users> users = userService.findAll(page, size);
        PageInfo<Users> pageInfo = new PageInfo<>(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/banById.do")
    public String banById(int id) {
        userService.banById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) {
        List<Books> booksList = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("booksList", booksList);
        mv.setViewName("user-show");
        return mv;
    }
}
