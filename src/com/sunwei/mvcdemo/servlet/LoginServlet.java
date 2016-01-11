package com.sunwei.mvcdemo.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunwei.mvcdemo.factory.DAOFactory;
import com.sunwei.mvcdemo.vo.User;
public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//String path = "Login.jsp";
		String userid = req.getParameter("userid");
		String userpassword = req.getParameter("userpassword");
		
		List<String> info = new ArrayList<>();
		
		if(userid == null || userid.equals("")){
			info.add("User id cannot be empty!!!");
		}
		
		if(userpassword == null || userpassword.equals("")){
			info.add("User password cannot be empty!!!");
		}
		
		if(info.size() == 0){
			User user = new User();
			user.setUserid(userid);
			user.setPassword(userpassword);
			
			try{
				if(DAOFactory.getIUserDAOInstance().findLogin(user)){
					info.add("Login Successfully! Welcome "+user.getName()+" to Our Page!");
				}else{
					info.add("Login Failure! Wrong Userid or Password!"+user.getUserid()+"----"+user.getPassword());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		req.setAttribute("info", info);
		req.getRequestDispatcher("Login.jsp").forward(req, resp);	
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doGet(req, resp);
	}
}
