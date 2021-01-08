package com.dk.dao;

import com.dk.domain.PageBean;
import com.dk.domain.Phone;
import com.dk.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {
    public List<Phone> getPhoneInfo(PageBean pb) {
        List<Phone> plist = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
             conn = JDBCUtil.getConn();
             pst = conn.prepareStatement("select * from phone order by pid desc limit ?,? ;");
             pst.setInt(1,pb.getStartIndex());
             pst.setInt(2,pb.getPageSize());

             rs = pst.executeQuery();
             while (rs.next()){
                 Phone p = new Phone();
                 p.setPid(rs.getInt("pid"));
                 p.setPname(rs.getString("pname"));
                 p.setPtype(rs.getInt("ptype"));
                 p.setPprice(rs.getDouble("pprice"));
                 p.setPcolor(rs.getInt("pcolor"));
                 p.setPdate(rs.getString("pdate"));

                 plist.add(p);
             }
             return plist;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs,pst,conn);
        }
        return null;
    }

    public int addIt(Phone p) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
             conn = JDBCUtil.getConn();
             pst = conn.prepareStatement("insert into phone values (null,?,?,?,?,?);");
            pst.setString(1,p.getPname());
            pst.setInt(2,p.getPtype());
            pst.setDouble(3,p.getPprice());
            pst.setInt(4,p.getPcolor());
            pst.setString(5,p.getPdate());

            int i = pst.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(null,pst,conn);
        }
        return 0;
    }

    public int deleteIt(String pid) {
        Connection conn = null;
        PreparedStatement pst =null;

        try {
             conn = JDBCUtil.getConn();
             pst = conn.prepareStatement("delete from phone where pid = ?;");
            pst.setInt(1,Integer.valueOf(pid));
            int i = pst.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(null,pst,conn);
        }
        return 0;
    }

    public Phone updateShow(String pid) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        Phone p = null;
        try {
             conn = JDBCUtil.getConn();
             pst = conn.prepareStatement("select * from phone where pid = ?;");
             pst.setString(1,pid);
             rs = pst.executeQuery();
            if (rs.next()){
                p = new Phone();
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPtype(rs.getInt("ptype"));
                p.setPprice(rs.getDouble("pprice"));
                p.setPcolor(rs.getInt("pcolor"));
                p.setPdate(rs.getString("pdate"));

            }
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs,pst,conn);
        }
        return null;
    }

    public int updateIt(Phone p) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
             conn = JDBCUtil.getConn();
             pst = conn.prepareStatement("update phone set pname = ?,ptype=?,pprice=?,pcolor=?,pdate=? where pid =? ;");
            pst.setString(1,p.getPname());
            pst.setInt(2,p.getPtype());
            pst.setDouble(3,p.getPprice());
            pst.setInt(4,p.getPcolor());
            pst.setString(5,p.getPdate());
            pst.setInt(6,p.getPid());

            int i = pst.executeUpdate();
            return i ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(null,pst,conn);
        }
        return 0;
    }

    public int deleteSome(String pids) {
        Connection conn =null;
        PreparedStatement pst = null;
        try {
             conn = JDBCUtil.getConn();
             pst = conn.prepareStatement("delete from phone where pid in(" + pids + ");");
            int i = pst.executeUpdate();

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(null,pst,conn);
        }
        return 0;

    }

    public int getPhoneCount() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int totalCount = 0;
        try {
            conn = JDBCUtil.getConn();
            pst = conn.prepareStatement("select count(*) as totalCount from phone;");
            rs = pst.executeQuery();
            while (rs.next()){
                totalCount = rs.getInt("totalCount");
            }
            return totalCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs,pst,conn);
        }
        return 0;

    }
}
