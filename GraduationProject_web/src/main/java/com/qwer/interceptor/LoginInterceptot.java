package com.qwer.interceptor;

import com.qwer.domain.Adminn;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptot implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Adminn msg = (Adminn) session.getAttribute("msg");
        if (msg == null){
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}