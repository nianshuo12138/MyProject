package com.dk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class Filter_Regist_Login_CRUD implements Filter {
    List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        list.add("傻逼");
        list.add("操");
        list.add("妈");
        list.add("祖宗");
        list.add("滚");
        list.add("去你的");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        String username = servletRequest.getParameter("username");
        String pname = servletRequest.getParameter("pname");
        if (username != null && (!("".equals(username)))){
            //说明输入的用户名不是空串,也不为null
            for (String s : list) {
                if (username.contains(s)){
                    servletResponse.getWriter().write("我淦,你打字都这么脏!");
                    return;
                }
            }
        }else if (pname != null && (!("".equals(pname)))){
            for (String s : list) {
                if (pname.contains(s)){
                    servletResponse.getWriter().write("我淦,你打字都这么脏!");
                    return;
                }


            }

        }

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
