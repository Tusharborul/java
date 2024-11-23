package com.demo.services;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginService {

	MyUser validateUser(String uname, String pass);

	boolean registeruser(Person p1, MyUser u1);

}
