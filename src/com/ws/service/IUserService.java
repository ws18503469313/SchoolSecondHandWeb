package com.ws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ws.entity.Comment;
import com.ws.entity.Pager;
import com.ws.entity.User;
@Service("IUserService")
public interface IUserService {
	/**
	 * 
	 * @param user	��¼ʱֻ��username ��password��User
	 * @param req 	���û���ŵ� {@link HttpServletRequest}��
	 * @return		����ݿ���ҵ�������User(�����)
	 */
	public void userLogin(User user, HttpServletRequest req);
	/**
	 * ����Ա��¼,�����µ�¼ʱ��
	 * @param user	��ҳ�洫����userֻ��username/password
	 * @param req	���û���ŵ� {@link HttpServletRequest}��
	 */
	public void adminLogin(User user, HttpServletRequest req);
	public void add(User user);
	public void delete(int id);
	public void update(User user);
	public User load(int id);
	public List<User> list();
	public List<User> list(Object obj);
	public List<User> list(Object[] obj);
	/**
	 * ����Ա�鿴��վ��Ա��Ϣ
	 * @return	��ҳ���������վ�û�
	 */
	public Pager<User> pageUser();
	public Pager<User> page(Object obj);
	public Pager<User> page(Object[] obj);
	public String emailConfirm(String username, String email);
	public void updateState(String id);
	public String updateUserPassword(String id, String password);
	public List<Comment> checkSpeech(String id);
	
	
	
	/**
	 * delete the comments 
	 * @param comment_id
	 * @return
	 */
	public String deleteComment(int comment_id);

	
}
