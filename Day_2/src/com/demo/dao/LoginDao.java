package com.demo.dao;

import com.demo.beans.MyUser;

public interface LoginDao {

	MyUser validate(String uname, String pwd);

}
