package com.demo.services;

import com.demo.beans.MyUser;
import com.demo.beans.Person;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{

	LoginDao ldao;
	public LoginServiceImpl() {
		ldao=new LoginDaoImpl();
	} 
	
	
	@Override
	public MyUser validateUser(String name, String passwd) {
	      
		return ldao.validateUser(name,passwd);
	}


	@Override
	public boolean registerdetails(Person p1, MyUser u1) {
		// TODO Auto-generated method stub
		return ldao.registerUserDetails(p1,u1);
	}

	     
}
