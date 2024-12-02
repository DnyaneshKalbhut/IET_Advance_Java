package com.demo.services;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	LoginDao ldao;
	public LoginServiceImpl() {
		super();
		this.ldao = new LoginDaoImpl();
	}
	@Override
	public MyUser getUser(String uname, String pass) {
		
		return ldao.authentication(uname,pass);
	}

}
