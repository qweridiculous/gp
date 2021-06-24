package com.qwer.adminController;

import com.qwer.domain.Adminn;
import com.qwer.service.AdminnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/adminn")
public class AdminnController {

    @Autowired
    private AdminnService adminnService;

    @RequestMapping("/AdminLogin.do")
    public ModelAndView login(Adminn adminn, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        Adminn loginAdminn = adminnService.findByUP(adminn);
        request.getSession().setAttribute("msg",loginAdminn);
        if (loginAdminn!=null) {
            mv.addObject("msg", loginAdminn);
            mv.setViewName("index");
        } else {
            mv.addObject("msg","账号或密码错误");
            mv.setViewName("login");
        }
        return mv;
    }
    @RequestMapping("/goLogin.do")
    public String goLogin(){
        return "login";
    }
    @RequestMapping("/goIndex.do")
    public String goIndex(){
        return "index";
    }
}
