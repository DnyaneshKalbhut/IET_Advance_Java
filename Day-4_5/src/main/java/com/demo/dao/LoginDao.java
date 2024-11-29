package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginDao {

	MyUser validateUser(String name, String passwd);

	boolean registerUserDetails(Person p1, MyUser u1);

}
