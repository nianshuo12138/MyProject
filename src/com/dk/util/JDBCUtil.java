package com.dk.util;

import java.sql.*;

//ע�⵼��İ�Ӧ����java.sql.*


public class JDBCUtil {
	//ע������,����ʱ������,ֻ����һ��
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//��ȡ����
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/day21_hw","root","root");
		
	}
	
	//�ر���Դ
	public static void closeAll(ResultSet rs,Statement st, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
