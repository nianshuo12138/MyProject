package com.dk.controller;

import com.dk.domain.User;
import com.dk.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("loginCheck".equals(method)){

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            UserService us = new UserService();
            int i = us.loginCheck(username,password);
            //获取输入的验证码
            String checkCode = req.getParameter("checkCode");
            //获取图片上的验证码字符串
            HttpSession session = req.getSession();
            String checkImgCode = (String) session.getAttribute("checkImgCode");

            if (!(checkCode.equalsIgnoreCase(checkImgCode))){
                resp.getWriter().write("验证码输入错误,请稍后>>>>>>>");
                resp.setHeader("refresh","2;url=/day21_hw/index.jsp");
            }else {
                if (i != 0) {
                    resp.getWriter().write("登录成功,请稍后>>>>>>>");
                    resp.setHeader("refresh", "2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");

                } else {
                    resp.getWriter().write("用户名或密码错误,请稍后>>>>>>>");
                    resp.setHeader("refresh", "2;url=/day21_hw/index.jsp");
                }
            }
        }else if ("usernameIsExist".equals(method)){
            Map<String, String[]> map = req.getParameterMap();
            UserService us = new UserService();
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException |InvocationTargetException e) {
                e.printStackTrace();
            }
            int i = us.usernameIsExist(user.getUsername());
            if (i != 0){
                //说明查询到了重复的用户名,不能注册
                resp.getWriter().write("用户名已存在,请换一个");
                resp.setHeader("refresh", "2;url=/day21_hw/registIt.jsp");
            }else{
                //没有查询到,可以注册
                int c = us.registIt(user);
                if (c != 0){
                    resp.getWriter().write("注册成功,请稍后>>>>>>>");
                    resp.setHeader("refresh", "2;url=/day21_hw/index.jsp");
                }else{
                    resp.getWriter().write("注册失败,请稍后>>>>>>>");
                    resp.setHeader("refresh", "2;url=/day21_hw/registIt.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
