package com.demo.services;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser getUser(String uname, String pass);

}
