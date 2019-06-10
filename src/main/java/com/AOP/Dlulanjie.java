package com.AOP;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Dlulanjie  extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo==null){
            response.getWriter().write("请登陆");
            return false;
        }else {
            System.out.println("已经登陆过了"+session.getAttribute("userinfo"));
        }

        return true;
    }
}
