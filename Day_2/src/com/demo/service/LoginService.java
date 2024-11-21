package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser validate(String uname, String pwd);

}
