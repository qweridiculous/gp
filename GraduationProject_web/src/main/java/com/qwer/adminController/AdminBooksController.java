package com.qwer.adminController;

import com.github.pagehelper.PageInfo;
import com.qwer.domain.BookImgs;
import com.qwer.domain.Books;
import com.qwer.domain.Users;
import com.qwer.service.BooksService;
import com.qwer.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/adminBooks")
public class AdminBooksController {

    @Autowired
    private BooksService booksService;
    @Autowired
    private ImagesService imagesService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<Books> booksList = booksService.findAlll(page, size);
        PageInfo<Books> pageInfo = new PageInfo<>(booksList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("book-list");
        return mv;
    }

    @RequestMapping("/setOffShelf.do")
    public String setOffShelf(int id) throws Exception {
        booksService.setOffShelf(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/setOnShelf.do")
    public String setOnShelf(int id) throws Exception {
        booksService.setOnShelf(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteBook.do")
    public String deleteBook(int id, HttpServletRequest request) {
        List<BookImgs> allFile = imagesService.findAll(id);
        for (BookImgs bookImgs : allFile) {
            try {
                deleteFiles(bookImgs.getImg(), request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        booksService.deleteBook(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(int id){
        ModelAndView mv = new ModelAndView();
        Books byId = booksService.findById(id);
        mv.addObject("book",byId);
        mv.setViewName("book-show");
        return mv;
    }
    @RequestMapping("/findByUid.do")
    public ModelAndView findByUid(int uid) throws Exception {
        List<Books> booksList = booksService.findByUid(uid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("booksList",booksList);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/updateBook.do")
    public String updateBook(Books books) throws Exception {
        booksService.adminUpdateBook(books);
        return "redirect:findAll.do";
    }

    //删除文件
    @RequestMapping("deleteImg.do")
    public boolean deleteFiles(String fileNames, HttpServletRequest request) throws Exception {
        String filePath = request.getSession().getServletContext().getRealPath("/images/product/");
        String filename = fileNames.split("/")[2];
        File file = new File(filePath, filename);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

}
