package com.ws.service.impl;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ws.dao.ICommentDao;
import com.ws.dao.IReplyDao;
import com.ws.dao.IUserDao;
import com.ws.dao.UserDao;
import com.ws.entity.Comment;
import com.ws.entity.Pager;
import com.ws.entity.Reply;
import com.ws.entity.User;
import com.ws.exception.MyRuntimeException;
import com.ws.service.IUserService;
import com.ws.util.DateUtil;
import com.ws.util.ImoocBase64;
import com.ws.util.SendQQMail;
@Service("userService")
public class UserService implements IUserService{
	private IUserDao userDao;
	private Logger logger = Logger.getLogger("looger");
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Autowired
	private ICommentDao commentDao;
	
	
	@Autowired
	private IReplyDao replyDao;
	
	public void add(User user) {
		String hql = "from User where username = ?";
		List<User> userlist = userDao.register(user.getUsername(),hql);
		if(userlist.size() > 0){
			logger.warn("用户名已存在!");
			throw new MyRuntimeException("用户名已存在!");
		}
		String password = ImoocBase64.JDKBase64Encode(user.getPassword());
		user.setPassword(password);
		user.setRole(1);
		user.setDate(DateUtil.getNowTime());
		userDao.add(user);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		user.setPassword(ImoocBase64.JDKBase64Encode(user.getPassword()));
		userDao.update(user);
	}

	public User load(int id) {
		// TODO Auto-generated method stub
		User user =  userDao.load(id);
		String password = ImoocBase64.JDKBase64Decode(user.getPassword());
		user.setPassword(password);
		return user;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		String hql = "from User";
		return userDao.list(hql);
		 
	}
	public List<User> list(Object obj) {
		// TODO Auto-generated method stub
		String hql = "from User u where username = ?";
		return userDao.list(hql, obj);
		
	}
	public List<User> list(Object[] obj){
		return null;
	}
	public Pager<User> pageUser() {
		// TODO Auto-generated method stub
		String hql = "from User where role = 1 ";
		return userDao.pages(hql);
	}
	public Pager<User> page(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	public Pager<User> page(Object[] obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void userLogin(User user, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String hql = "select new com.ws.entity.User(u.id as id,u.username as username,u.password as password,u.state as state) "
					+ "from User u where u.username = ?";
		List<User> userlist =  userDao.list(hql, user.getUsername());
		if(userlist.size() == 0){
			throw new MyRuntimeException("用户名错误");
		}else{
			User loginUser = userlist.get(0);
			if(!user.getPassword().equals(ImoocBase64.JDKBase64Decode(loginUser.getPassword()))){
				throw new MyRuntimeException("密码错误");
			}else{
				if(loginUser.getState() == 1) {
					throw new RuntimeException("您已被管理员限制登录!");
				}
				req.getSession().setAttribute("loginUser", loginUser);
			}
		}
		
		
	}
	
	public void adminLogin(User user, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String hql = "from User where username = ? and role = 2";
		List<User> userList =  userDao.list(hql, user.getUsername());
		if(userList.size() == 0){
			throw new MyRuntimeException("用户名错误!");
		}else{
			User loginUser  = userList.get(0);
			if(!user.getPassword().equals(loginUser.getPassword())){
				throw new MyRuntimeException("密码错误!");
			}else{
				String date = loginUser.getDate();
				//��������û���¼��ʱ��
				loginUser.setDate(DateUtil.getNowTime());
				userDao.update(loginUser);
				//���û�����HttpServletRequest;
				loginUser.setDate(date);
				req.getSession().setAttribute("loginUser", loginUser);
			}
		}
		
		
	}

	public String emailConfirm(String username, String email) {
		User user = userDao.getByUsername(username);
		Map<String, Object> map = new HashMap<String, Object>();
		if(user == null){
			map.put("result", false);
			map.put("msg", "用户名不存在");
			return JSON.toJSONString(map);
		}else if(!user.getEmail().equals(email)){
			map.put("result", false);
			map.put("msg", "邮箱不正确");
			return JSON.toJSONString(map);
		}else{
			if(user.getState() == 1) {
				map.put("user", user);
				map.put("result", true);
				map.put("msg", "邮件已发送");
				return JSON.toJSONString(map);
			}
			String content = "校园二手交易网站修改密码连接,如非本人操作,请勿点击修改,点击确认修改密码:"
							+ "<a href='http://123.206.14.25:8080/SchoolSecondHandWeb/user/updateState?id="+user.getId()+"'>"
							+ "点击确认</a>";
			try {
				SendQQMail.sendMail(email, content);
				map.put("user", user);
				map.put("result", true);
				map.put("msg", "邮件已发送");
				return JSON.toJSONString(map);
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
				map.put("result", false);
				map.put("msg", "邮件发送失败!");
				return JSON.toJSONString(map);
			}
			
		}
	}

	public void updateState(String id) {
		User user = userDao.load(Integer.parseInt(id));
		user.setState(1);
		userDao.update(user);
	}

	public String updateUserPassword(String id, String password) {
		User user = userDao.load(Integer.parseInt(id));
		if(user.getState() == 0){
			return "清先在邮件中确认!";
		}else{
			user.setPassword(ImoocBase64.JDKBase64Encode(password));
			user.setState(0);
			userDao.update(user);
			return "修改成功!";
		}
		
	}

	public List<Comment> checkSpeech(String id) {
		String hql = "from Comment c where c.commenter.id = "+Integer.parseInt(id);
		return  commentDao.list(hql);
		
		
	}

	public String deleteComment(int comment_di) {
		// TODO Auto-generated method stub
		try {
			Comment comment = commentDao.load(comment_di);
			for(Reply re : comment.getReplies()){
				replyDao.delete(re.getId());
			}
			commentDao.delete(comment_di);
			return "操作成功!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "操作失败!";
		}
		
	}

}
