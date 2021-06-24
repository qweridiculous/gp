package com.qwer.controller;

import com.github.pagehelper.PageInfo;
import com.qwer.UuidUtil;
import com.qwer.domain.BookImgs;
import com.qwer.domain.Books;
import com.qwer.service.BooksService;
import com.qwer.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;
    @Autowired
    private ImagesService imagesService;

    @RequestMapping("/findAll.do")
    @ResponseBody
    public PageInfo findAll(@RequestParam(value = "mid", defaultValue = "0") String mid,
                            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(value = "sname") String sname) throws Exception {
        String sword = URLDecoder.decode(sname, "utf-8");
        int inmid = 0;
        if (mid != null && mid.length() > 0 && !"null".equals(mid)) {
            inmid = Integer.parseInt(mid);
        }
        List<Books> allBooks = booksService.findAll(inmid, currentPage, sword);
        PageInfo pageInfo = new PageInfo(allBooks);
        return pageInfo;
    }

    @RequestMapping("/findByWord.do")
    @ResponseBody
    public List<Books> findByWord(String sname) throws Exception {
        String sword = URLDecoder.decode(sname, "utf-8");
        List<Books> booksList = booksService.findByWord(sword);
        return booksList;
    }

    @RequestMapping("/setOffShelf.do")
    @ResponseBody
    public boolean setOffShelf(int id) throws Exception {
        return booksService.setOffShelf(id);
    }

    @RequestMapping("/setOnShelf.do")
    @ResponseBody
    public boolean setOnShelf(int id) throws Exception {
        return booksService.setOnShelf(id);
    }

    @RequestMapping("/findById.do")
    @ResponseBody
    public Books findById(int id) throws Exception {
        Books books = booksService.findById(id);
        return books;
    }

    @RequestMapping("/findByUid.do")
    @ResponseBody
    public List<Books> findByUid(int uid) throws Exception {
        List<Books> booksList = booksService.findByUid(uid);
        return booksList;
    }

    @RequestMapping("/addBook.do")
    @ResponseBody
    public boolean addBook(Books books, HttpServletRequest request) throws Exception {
        books.setCreateDate(new Date());
        List<MultipartFile> multipartFiles = books.getFiles();
        List<String> fileNames = new ArrayList<>();
        boolean flag = false;
        if (multipartFiles != null) {
            fileNames = uploadFiles(multipartFiles, request);
        }
        if (fileNames != null && fileNames.size() > 0) {
            List<BookImgs> bookImgsList = new ArrayList<>();
            for (String fileName : fileNames) {
                BookImgs bookImgs = new BookImgs();
                bookImgs.setImg(fileName);
                bookImgsList.add(bookImgs);
            }
            books.setImg(fileNames.get(0));
            books.setImgs(bookImgsList);
            flag = booksService.addBook(books);
        }
        return flag;
    }

    @RequestMapping("/updateBook.do")
    @ResponseBody
    public boolean updateBook(Books books, HttpServletRequest request) throws Exception {
        List<MultipartFile> multipartFiles = books.getFiles();
        List<String> fileNames = new ArrayList<>();
        boolean flag = false;
        if (multipartFiles != null) {
            fileNames = uploadFiles(multipartFiles, request);
        }
        if (fileNames != null) {
            List<BookImgs> bookImgsList = new ArrayList<>();
            for (String fileName : fileNames) {
                BookImgs bookImgs = new BookImgs();
                bookImgs.setImg(fileName);
                bookImgsList.add(bookImgs);
            }
            books.setImg(fileNames.get(0));
            books.setImgs(bookImgsList);
            flag = booksService.updateBook(books);
        }
        return flag;
    }

    @RequestMapping("/deleteBook.do")
    @ResponseBody
    public boolean deleteBook(int id, HttpServletRequest request) {
        List<BookImgs> allFile = imagesService.findAll(id);
        for (BookImgs bookImgs : allFile) {
            try {
                deleteFiles(bookImgs.getImg(), request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return booksService.deleteBook(id);
    }

    //删除文件
    @RequestMapping("deleteImg.do")
    @ResponseBody
    public boolean deleteFiles(String fileNames, HttpServletRequest request) throws Exception {
        String filePath = request.getSession().getServletContext().getRealPath("/images/product/");
        String filename = fileNames.split("/")[2];
        File file = new File(filePath, filename);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    //上传文件
    public List<String> uploadFiles(List<MultipartFile> multipartFiles, HttpServletRequest request) throws Exception {
        List<String> newFileNames = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            String newFileName = "";
            String originalFilename = multipartFile.getOriginalFilename();
            String fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length());
            if ("jpg,jpeg,gif,png".contains(fileType.toLowerCase())){
                if (originalFilename != null && multipartFile != null && originalFilename.length() > 0) {
                    newFileName = UuidUtil.getUuid() + "_" + originalFilename;
                    String pic_path = request.getSession().getServletContext().getRealPath("/images/product/");
                    File file = new File(pic_path);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    multipartFile.transferTo(new File(pic_path, newFileName));
                    newFileNames.add("images/product/" + newFileName);
                }
            }
        }
        return newFileNames;
    }
}
