package com.sunwei.mvcdemo.proxy;

import com.sunwei.mvcdemo.dao.IUserDAO;
import com.sunwei.mvcdemo.dao.impl.UserDAOImpl;
import com.sunwei.mvcdemo.dbc.DatabaseConnection;
import com.sunwei.mvcdemo.vo.User;

public class UserDAOProxy implements IUserDAO{
	private DatabaseConnection dbc = null;
	private IUserDAO dao = null;
	
	public UserDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}
	
	public boolean findLogin(User user) throws Exception{
		boolean flag = false;
		
		try{
			flag = this.dao.findLogin(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		
		return flag;
	}
	
}
