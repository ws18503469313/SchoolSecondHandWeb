package com.ws.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ws.entity.User;
import com.ws.service.IGodService;
import com.ws.service.IInfoService;
import com.ws.service.INoticeService;
import com.ws.service.IUserService;

@Controller("loginController")
@RequestMapping("SchoolSecondHandWeb")
public class LoginController {
	@Autowired
	private IGodService godService;
	@Autowired
	private IUserService userService;
	@Autowired
	private INoticeService noticeService;
	@Autowired
	private IInfoService infoService;
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String guest(){
		return "index";
	}
	@RequestMapping(value="/top",method=RequestMethod.GET)
	public String top(){
		return "top";
	}
	@RequestMapping(value="/nav",method=RequestMethod.GET)
	public String nav(Model model,HttpServletRequest req){
		noticeService.pagerNotice(req);
		model.addAttribute("pages", godService.pageOnlineGod());
		return "nav";
	}

	
	@RequestMapping(value="/adminlogin",method=RequestMethod.GET)
	public String adminlogin(User user,Model model){
		model.addAttribute("admin", user);
		return "adminlogin";
	}
	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String adminlogin(User user,Model model,HttpServletRequest req){
		try {
			logger.info(user.getUsername()+"登录成功!");
			userService.adminLogin(user, req);
			return "redirect:/SchoolSecondHandWeb/adminmain";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			logger.info(user.getUsername()+"登录失败!");
			return "error";
		}
	}
	@RequestMapping(value="/adminmain",method=RequestMethod.GET)
	public String adminmain(){
		return "user/admin/main";
	}
	@RequestMapping(value="/admintop",method=RequestMethod.GET)
	public String admintop(){
		return "user/admin/top";
	}
	@RequestMapping(value="/adminleft",method=RequestMethod.GET)
	public String adminleft(){
		return "user/admin/left";
	}
	@RequestMapping(value="/adminright",method=RequestMethod.GET)
	public String adminright(){
		return "user/admin/right";
	}
	@RequestMapping(value="/adminindex",method=RequestMethod.GET)
	public String adminindex(){
		return "user/admin/index";
	}
	

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user,String province,String city,
				String country,HttpServletRequest req,Model model){
		try {
			StringBuffer sb = new StringBuffer();
			String address = sb.append(province).append(city).append(country).toString();
			user.setAddress(address);
			userService.add(user);
			req.getSession().setAttribute("loginUser", user);
			return "redirect:/SchoolSecondHandWeb/main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/SchoolSecondHandWeb/main";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest req,Model model){
		
		try {
			userService.userLogin(user,req);
//			noticeService.pagerNotice(req);
			logger.info(user.getUsername()+"登录成功!");
			return "redirect:/SchoolSecondHandWeb/main";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			logger.info(user.getUsername()+"登录失败!");
			return "error";
		}
	}
}
