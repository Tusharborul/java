package com.demo.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;

public class DBUtil {
	private static Connection conn=null;
	public static Connection getMyConnection() {
		if(conn==null) {
			try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac22?useSSL=false";
			conn=DriverManager.getConnection(url,"dac22","welcome");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeMyConnection() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
	}

}
