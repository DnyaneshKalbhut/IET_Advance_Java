package com.demo.dao;

import com.demo.beans.MyUser;

public interface LoginDao {

	MyUser authentication(String uname, String pass);

}
