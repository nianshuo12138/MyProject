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

        list.add("ɵ��");
        list.add("��");
        list.add("��");
        list.add("����");
        list.add("��");
        list.add("ȥ���");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        String username = servletRequest.getParameter("username");
        String pname = servletRequest.getParameter("pname");
        if (username != null && (!("".equals(username)))){
            //˵��������û������ǿմ�,Ҳ��Ϊnull
            for (String s : list) {
                if (username.contains(s)){
                    servletResponse.getWriter().write("����,����ֶ���ô��!");
                    return;
                }
            }
        }else if (pname != null && (!("".equals(pname)))){
            for (String s : list) {
                if (pname.contains(s)){
                    servletResponse.getWriter().write("����,����ֶ���ô��!");
                    return;
                }


            }

        }

        //����
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
