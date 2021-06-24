package com.qwer.controller;

import com.qwer.domain.Major;
import com.qwer.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @RequestMapping("/findAll.do")
    @ResponseBody
    public List<Major> findAll() throws Exception{
        List<Major> majorList = majorService.findAll();
        return majorList;
    }
}
