package com.ws.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ws.entity.Comment;
import com.ws.entity.Notice;
import com.ws.entity.User;
import com.ws.service.IInfoService;
import com.ws.service.INoticeService;
import com.ws.service.IOrderService;
import com.ws.service.IUserService;

@Controller("userController")
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private INoticeService noticeService;
	@Autowired
	private IInfoService infoService;
	@Autowired
	private IOrderService orderService;
	/**
	 * 
	 * @return			��ת���޸ĸ�����Ϣҳ��
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String udateUser(HttpServletRequest req,Model model){
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user == null){
			model.addAttribute("msg", "请您先登录!");
			return "error";
		}else{
			return "user/update";
		}
		
	}
	/**
	 * 	�޸ĸ�����Ϣ����
	 * @param user		�û��޸ĺõ���user
	 * @param model		��<a>�޸ĳɹ�</a>�������û�
	 * @return			���ص���ʾ����
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String udateUser(User user,Model model){
		userService.update(user);
		String str = "修改成功!";
		model.addAttribute("msg", str);
		return "success";
	}
	/**
	 * ����Ա��ҳ��ȡ�û�
	 * @param model		����ҳ��ѯ��������ݴ洢��Model��
	 * @return			���ص�user�б����
	 */
	@RequestMapping(value="/userManage",method=RequestMethod.GET)
	public String pageruser(Model model){
		model.addAttribute("users", userService.pageUser());
		return "user/admin/userManage";
	}
	/**
	 * 
	 * @param model		��һ���յ�Notice�ŵ�model��
	 * @param notice	spring�Զ�����һ��notice
	 * @return			���ص��������ŵĽ���
	 */
	@RequestMapping(value="/publishNews",method=RequestMethod.GET)
	public String publishNews(Model model,Notice notice){
		model.addAttribute("notice", notice);
		return "user/admin/publishnews";
		
	}
	/**
	 * 
	 * @param notice	bind����Ϣ��notice
	 * @param file		���е�Ҫ�ϴ����ļ�
	 * @param req		
	 * @param model		������ɺ������û�
	 * @return			���ص�������ɽ���
	 */
	@RequestMapping(value="/publishNews",method=RequestMethod.POST)
	public String publishNews(Notice notice,MultipartFile file,HttpServletRequest req,Model model){
		noticeService.addNotice(notice,file,req);
		model.addAttribute("str", "发布成功!");
		return "user/admin/success";
		
	}
	@RequestMapping(value="/checknotice",method=RequestMethod.GET)
	public String checknotice(Model model,int id){
		model.addAttribute("notice", noticeService.checkNotice(id));
		return "checknotice";
		
	}
	/*@RequestMapping(value="/downloadfile",method=RequestMethod.POST)
	public void downloadfile(HttpServletRequest req,HttpServletResponse resp){
			try {
				String result = noticeService.downloadFile(req);
				resp.getWriter().print(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}*/
	/**
	 * 
	 * @param req		��HttpServletRequest�л�ȡsession,��ȡ���������·���µ�("/fileuoload/adminfiles/")��·��
	 * 													����ȡ��ǰ̨��������Ҫ���ص��ļ����
	 * @return			����Ҫ���ص��ļ�ResponseEntity<byte[]>
	 * @throws Exception�ļ�����ʧ��/�Ҳ����ļ�/
	 */
	@RequestMapping(value="/downloadfile",method=RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest req)throws Exception {
		return noticeService.downloadFile(req);
    }
  
    /**
     * @data:2018/4/23
     * 我的消息列表
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/myInfo",method=RequestMethod.GET)
    public String myInfo(HttpServletRequest req,Model model){
    	
    	try {
			model.addAttribute("infos", infoService.listMyInfo(req));
			return "user/myinfo";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
    }
    /**
     * 2018/4/23
     * 订单详情
     * @param resp
     * @param id
     * @throws IOException
     */
    @RequestMapping(value="/orderDetal",method=RequestMethod.GET)
    public void orderDetal(HttpServletResponse resp,int id) throws IOException{
    	Object obj = orderService.getById(id);
    	String info = JSONObject.toJSONString(obj);
    	System.out.println(info);
    	resp.getWriter().print(info);
    }
    /**
     * 2018/4/23
     * 发货
     * @param resp
     * @param order_id
     * @throws IOException
     */
    @RequestMapping(value="/sendGod",method=RequestMethod.GET)
    public void sendGod(HttpServletResponse resp,int order_id) throws IOException{
    	String message = orderService.sendGod(order_id);
    	resp.getWriter().print(message);
    }
    /**
     * 2018/4/23
     * 取消订单
     * @param resp
     * @param order_id
     * @throws IOException
     */
    @RequestMapping(value="/cancleOrder",method=RequestMethod.GET)
    public void cancleOrder(HttpServletResponse resp,int order_id) throws IOException{
    	String message = orderService.cancleOrder(order_id);
    	resp.getWriter().print(message);
    }
    /**
     * 2018/4/23
     * 确认收货
     * @param resp
     * @param order_id
     * @throws IOException
     */
    @RequestMapping(value="/confrimReceive",method=RequestMethod.GET)
    public void confrimReceive(HttpServletResponse resp,int order_id,String comment) throws IOException{
    	String message = orderService.confirm(order_id,comment);
    	resp.getWriter().print(message);
    }
    /**
     * user forget passwrod, then want to change the password,
     * first he should check it's himself do this operation,
     * then goto email click the confirm button
     * last input the new password
     * @param email
     * @param username
     * @param resp
     * @throws IOException
     */
    @RequestMapping(value="/emailConfirm",method=RequestMethod.POST)
    public void emailConfirm(String username,String email,HttpServletResponse resp) throws IOException{
    	String message = userService.emailConfirm(username,email);
    	resp.getWriter().print(message); 
    }
    @RequestMapping(value="/updateState",method=RequestMethod.GET)
    public void updateState(String id,HttpServletResponse resp) throws IOException{
    	userService.updateState(id);
    	resp.setContentType("text/html; charset=utf-8");
    	resp.getWriter().print("成功!");
    }
    @RequestMapping(value="/updateUserPasswrod",method=RequestMethod.POST)
    public void updateUserPasswrod(String id,String password,HttpServletResponse resp) throws IOException{
    	String message = userService.updateUserPassword(id,password);
    	resp.getWriter().print(message);
    }
    /**
     * list the comments which were published by the user who is logging
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="/checkSpeech",method=RequestMethod.GET)
    public String checkSpeech(String id,HttpServletRequest req,Model model){
    	List<Comment> comments = userService.checkSpeech(id);
    	if(comments.size() == 0){
    		model.addAttribute("msg","该用户暂时还没发布言论!");
    	}
    	model.addAttribute("speech",comments);
    	return "user/admin/checkSpeech";
    }
    /**
     * delete the comments which is operated by the admin
     * first delete the replies of this comment
     * then delete this comment
     * @param comment_di
     * @param resp
     * @throws IOException 
     */
    @RequestMapping(value="/deleteComment",method=RequestMethod.POST)
    public void deleteComment(int comment_id,HttpServletResponse resp) throws IOException{
    	String result = userService.deleteComment(comment_id);
    	resp.getWriter().print(result);
    }
}
