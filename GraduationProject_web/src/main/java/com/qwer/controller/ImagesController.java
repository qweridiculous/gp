package com.qwer.controller;

import com.qwer.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    private ImagesService imagesService;

    @RequestMapping("/deleteImgData.do")
    @ResponseBody
    public boolean deleteImgById(int id){
        return imagesService.deleteImgById(id);
    }
}
