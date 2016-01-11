package com.sunwei.mvcdemo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunwei.mvcdemo.dao.IUserDAO;
import com.sunwei.mvcdemo.vo.User;

public class UserDAOImpl implements IUserDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean findLogin(User user) throws Exception{
		boolean flag = false;
		
		try{
			String sql = "SELECT name FROM user WHERE userid=? AND password=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getUserid());
			this.pstmt.setString(2,user.getPassword());
			
			ResultSet rs = this.pstmt.executeQuery();
			
			if(rs.next()){
				flag = true;
				user.setName(rs.getString(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.pstmt != null){
				try{
					this.pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}
}
