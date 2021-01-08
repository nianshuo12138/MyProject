package com.dk.dao;

import com.dk.domain.User;
import com.dk.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public int loginCheck(String username, String password) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
            pst = conn.prepareStatement("select * from user where username = ? and password = ?;");
            pst.setString(1,username);
            pst.setString(2,password);
            rs = pst.executeQuery();
            if (rs.next()){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(rs,pst,conn);
        }
        return 0;
    }


    public int usernameIsExist(String username) {
        try {
            Connection conn = JDBCUtil.getConn();
            PreparedStatement pst = conn.prepareStatement("select * from user where username = ?;");

            pst.setString(1,username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                return 1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int regist(User user) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtil.getConn();
            pst = conn.prepareStatement("insert into user values (null,?,?);");
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            int i = pst.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeAll(null,pst,conn);
        }
        return 0;
    }
}
