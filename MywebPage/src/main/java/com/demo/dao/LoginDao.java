package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginDao {

	MyUser authentication(String uname, String pass);

	boolean registerUser(Person p1, MyUser u1);

}
