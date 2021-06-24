package com.qwer.adminController;

import com.github.pagehelper.PageInfo;
import com.qwer.domain.Major;
import com.qwer.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/adminMajor")
@Controller
public class AdminMajorController {

    @Autowired
    private MajorService majorService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Major> majorList = majorService.findAlll(page,size);
        PageInfo<Major> pageInfo = new PageInfo<>(majorList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("major-list");
        return mv;
    }

    @RequestMapping("/delete.do")
    public String delete(int id){
        majorService.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/add.do")
    public String add(String  name){
        majorService.add(name);
        return "redirect:findAll.do";
    }
}
