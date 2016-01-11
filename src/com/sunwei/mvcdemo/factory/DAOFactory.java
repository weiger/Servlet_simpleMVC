package com.sunwei.mvcdemo.factory;

import com.sunwei.mvcdemo.dao.IUserDAO;
import com.sunwei.mvcdemo.proxy.UserDAOProxy;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new UserDAOProxy();
	}
}
