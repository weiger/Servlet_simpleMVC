package com.sunwei.mvcdemo.dao;

import com.sunwei.mvcdemo.vo.User;

public interface IUserDAO {
	public boolean findLogin(User user) throws Exception;
}
