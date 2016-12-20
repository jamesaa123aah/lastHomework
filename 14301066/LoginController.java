package cn.edu.bjtu.weibo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import cn.edu.bjtu.weibo.service.LoginService;
import cn.edu.bjtu.weibo.service.LogoutService;



@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LogoutService logoutService;
	
	
	/**
	 * 登陆
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value="/login")  
	    public String login(HttpSession session,String id,String username,String password) throws Exception{        
	        //在Session里保存信息  
	        session.setAttribute("id", id);  
	        
	       boolean tag =  loginService.loginService(username, password);
	        
	         if(tag){
	        	 return "success"; 
	         }else{
	        	 return "failure";  
	         }
	          
	    }  
	      
	    
	 /**
	  * 退出
	  * @param session
	  * @return
	  * @throws Exception
	  */
	    @RequestMapping(value="/logout")  
	    public String logout(HttpSession session) throws Exception{  
	        //清除Session  
	      //  session.invalidate();  
	        
	      boolean tag =   logoutService.logout((int) session.getAttribute("id"));
	        
	      
	        return "logout";  
	    }  
}
