package com.ws.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ws.entity.User;
@Repository("IUserDao")
public interface IUserDao extends IBaseDao<User>{
	/**
	 * ע���ʱ����Ҫ��֤�˺�  �Ƿ�����ݿ����Ѵ���
	 * @param username	�˺�
	 * @param hql		��ѯ���
	 * @return			�鵽��User
	 */
	List<User> register(String username, String hql);
	
	
	public User getByUsername(String username);
}
