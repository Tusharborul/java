package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.DBUtil;
import com.demo.beans.MyUser;
import com.demo.beans.Person;

public class LoginDaoImpl implements LoginDao {
	
	static Connection conn;
	static PreparedStatement selUser,addUser,setdetails;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			selUser=conn.prepareStatement("select uname,passwd,role from users where uname=? and passwd=?");
			addUser=conn.prepareStatement("insert into users (uname,passwd,role) values(?,?,?)");
			setdetails=conn.prepareStatement("insert into Person (fname,lname,gender,degree,city,skills) values (?,?,?,?,?,?)");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public MyUser authentication(String uname, String pass) {
	        try {
				selUser.setString(1,uname);
				selUser.setString(2, pass);
				ResultSet rs=selUser.executeQuery();
				if(rs.next()) {
					return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		return null;
	}

	@Override
	public boolean registerUser(Person p1, MyUser u1) {
		try {
			System.out.println(u1.getUname()+"------"+u1.getPasswd());
			addUser.setString(1,u1.getUname() );
			addUser.setString(2,u1.getPasswd());
			addUser.setString(3,u1.getRole());
			addUser.executeUpdate();
			setdetails.setString(1,p1.getFname());
			setdetails.setString(2,p1.getLname());
			setdetails.setString(3,p1.getGender());
			setdetails.setString(4,p1.getDegree());
			setdetails.setString(5,p1.getCity());
			setdetails.setString(6,String.join(",", p1.getSkills()));
			setdetails.executeUpdate();
			return true;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
