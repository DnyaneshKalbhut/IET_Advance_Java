package com.demo.services;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginService {

	MyUser validateUser(String name, String passwd);

	boolean registerdetails(Person p1, MyUser u1);

	
	
}
