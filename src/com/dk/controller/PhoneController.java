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
            resp.getWriter().write("method���Ÿ�ɶ��??");
            return ;
        }
        if ("getPhoneInfo".equals(method)){
            PhoneService ps = new PhoneService();
            //��ҳ����
            String pageNumber = req.getParameter("pageNumber");
            PageBean pb = new PageBean();
            pb.setPageNumber(Integer.valueOf(pageNumber));
            //����ÿҳ����Ϊ 5
            pb.setPageSize(5);

            //��ѯ������,Ŀ�Ļ�ȡ��ҳ��
            int totalCount = ps.getPhoneCount();
            pb.setTotalCount(totalCount);

            List<Phone> plist = ps.getPhoneInfo(pb);
            //��plist���뵽pb�����е�plist������,�����!!!
            pb.setPlist(plist);

            //Ȼ���ô�plist��,��pb�Ϳ�����
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
                resp.getWriter().write("���ӳɹ�");
            }else{
                resp.getWriter().write("����ʧ��");
            }
            resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
        }else if("deleteIt".equals(method)){
            String pid = req.getParameter("pid");
            PhoneService ps = new PhoneService();

            int i = ps.deleteIt(pid);
            if (i != 0) {
                resp.getWriter().write("ɾ���ɹ�,���Ժ�>>>>>>");
            }else{
                resp.getWriter().write("ɾ��ʧ��,���Ժ�>>>>>>>");
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
                resp.getWriter().write(">>>>>����Ϊ��>>>>");
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
                resp.getWriter().write("�޸ĳɹ�,���Ժ�>>>>>>>");
            }else{
                resp.getWriter().write("�޸�ʧ��,���Ժ�>>>>>>>");
            }
            resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
        }else if ("deleteSome".equals(method)){
            String pids = req.getParameter("pid");
            if (pids == null || "".equals(pids)){
                resp.getWriter().write("����ɾ�����ѡ������ѡ��,������ת<-_-_-_-_-_-_-_-_-");
                resp.setHeader("refresh","2;url=/day21_hw/phone?method=getPhoneInfo&pageNumber=1");
            }else{
                PhoneService ps = new PhoneService();
                int i = ps.deleteSome(pids);
                if (i > 0){
                    resp.getWriter().write("ɾ���ɹ�,���Ժ�>>>>>>>");
                }else{
                    resp.getWriter().write("ɾ��ʧ��,���Ժ�>>>>>>>");
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
