package com.qwer.controller;

import com.github.pagehelper.PageInfo;
import com.qwer.domain.Books;
import com.qwer.domain.ResultInfo;
import com.qwer.domain.Users;
import com.qwer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUsername.do")
    @ResponseBody
    public Users getUsername(HttpServletRequest request) throws Exception {
        Users user = (Users) request.getSession().getAttribute("user");
        return user;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo findByUP(HttpServletRequest request, Users users, String checkcode) throws Exception {
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        ResultInfo resultInfo = new ResultInfo();
        if (checkcode_server == null || !checkcode.equalsIgnoreCase(checkcode_server)) {
            resultInfo.setFlag(false);
            resultInfo.setMsg("验证码错误");
            return resultInfo;
        }

        Users user = userService.findByUP(users);
        if (user == null){
            resultInfo.setMsg("账号或密码错误");
            resultInfo.setFlag(false);
            return resultInfo;
        }
        if (user != null && "N".equals(user.getStatus())){
            resultInfo.setMsg("账号未激活");
            resultInfo.setFlag(false);
            return resultInfo;
        }
        if (user != null && user.getBan() == 1){
            resultInfo.setMsg("账号被封禁");
            resultInfo.setFlag(false);
            return resultInfo;
        }
        if (user != null) {
            request.getSession().setAttribute("user", user);
            resultInfo.setFlag(true);
            return resultInfo;
        }
        resultInfo.setFlag(false);
        return resultInfo;
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUser(Users users, HttpServletRequest request, String checkcode) throws Exception {
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        ResultInfo resultInfo = new ResultInfo();
        if (checkcode_server == null || !checkcode.equalsIgnoreCase(checkcode_server)) {
            resultInfo.setFlag(false);
            resultInfo.setMsg("验证码错误");
            return resultInfo;
        }
        Boolean flag = userService.addUser(users);
        if (!flag) {
            resultInfo.setMsg("用户名已存在");
        }
        resultInfo.setFlag(flag);
        return resultInfo;
    }

    @RequestMapping("/updateUser.do")
    @ResponseBody
    public boolean updateUser(Users users, HttpServletRequest request) {

        boolean flag = userService.updateUser(users);
        if (flag) {
            request.getSession().setAttribute("user", users);
        }
        return flag;
    }

    @RequestMapping(value = "/activeUser.do")
    public String activeUser(String code) throws Exception {
        if (code != null) {
            boolean flag = userService.active(code);
            if (flag) {
                return "redirect:/index.html";
            } else {
                return "redirect:/register.html";
            }
        }else {
            return null;
        }
    }


}
