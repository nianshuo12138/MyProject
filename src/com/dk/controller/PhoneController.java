package com.dk.controller;

import com.dk.domain.PageBean;
import com.dk.domain.Phone;
import com.dk.service.PhoneService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/phone")
public class PhoneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null || "".equals(method)){
            resp.getWriter().write("method空着干啥呢??");
            return ;
        }
        if ("getPhoneInfo".equals(method)){
            PhoneService ps = new PhoneService();
            //分页操作
            String pageNumber = req.getParameter("pageNumber");
            PageBean pb = new PageBean();
            pb.setPageNumber(Integer.valueOf(pageNumber));
            //设置每页条数为 5
            pb.setPageSize(5);

            //查询总条数,目的获取总页数
            int totalCount = ps.getPhoneCount();
            pb.setTotalCount(totalCount);

            List<Phone> plist = ps.getPhoneInfo(pb);
            //把plist放入到pb对象中的plist属性中,分清楚!!!
            pb.setPlist(plist);

            //然后不用传plist了,传pb就可以了
            req.setAttribute("pb",pb);
            req.getRequestDispatcher("getPhoneInfo.jsp").forward(req,resp);

        }else if("addIt".equals(method)){
            PhoneService ps = new PhoneService();
            Map<String, String[]> map = req.getParameterMap();
            Phone p = new Phone();
            try {
                BeanUtils.populate(p,map);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            int i = ps.addIt(p);
            if (i != 0){
                resp.getWriter().write("增加成功");
            }else{
                resp.getWriter().write("增加失败");
            }
            resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
        }else if("deleteIt".equals(method)){
            String pid = req.getParameter("pid");
            PhoneService ps = new PhoneService();

            int i = ps.deleteIt(pid);
            if (i != 0) {
                resp.getWriter().write("删除成功,请稍后>>>>>>");
            }else{
                resp.getWriter().write("删除失败,请稍后>>>>>>>");
            }
            resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
        }else if("updateShow".equals(method)){
            String pid = req.getParameter("pid");
            PhoneService ps = new PhoneService();
            Phone p = ps.updateShow(pid);
            if (p != null){
                req.setAttribute("p",p);
                req.getRequestDispatcher("updateShow.jsp").forward(req,resp);
            }else{
                resp.getWriter().write(">>>>>对象为空>>>>");
            }

        }else if ("updateIt".equals(method)){
            PhoneService ps = new PhoneService();
            Map<String, String[]> map = req.getParameterMap();
            Phone p = new Phone();
            try {
                BeanUtils.populate(p,map);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            int i = ps.updateIt(p);
            if (i != 0){
                resp.getWriter().write("修改成功,请稍后>>>>>>>");
            }else{
                resp.getWriter().write("修改失败,请稍后>>>>>>>");
            }
            resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
        }else if ("deleteSome".equals(method)){
            String pids = req.getParameter("pid");
            if (pids == null || "".equals(pids)){
                resp.getWriter().write("批量删除你得选几个复选框啊,正在跳转<-_-_-_-_-_-_-_-_-");
                resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
            }else{
                PhoneService ps = new PhoneService();
                int i = ps.deleteSome(pids);
                if (i > 0){
                    resp.getWriter().write("删除成功,请稍后>>>>>>>");
                }else{
                    resp.getWriter().write("删除失败,请稍后>>>>>>>");
                }
                resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
            }


        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
