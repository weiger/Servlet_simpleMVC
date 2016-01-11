package com.sunwei.mvcdemo.test;

import com.sunwei.mvcdemo.factory.*;
import com.sunwei.mvcdemo.vo.User;

public class Test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserid("admin");
		user.setPassword("admin");
		boolean res = DAOFactory.getIUserDAOInstance().findLogin(user);
		System.out.println(res+"   "+user.getName());
	}

}
