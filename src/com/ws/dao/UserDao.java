package com.ws.dao;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ws.entity.User;
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao{

	public List<User> register(String username, String hql) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, username);
		return (List<User>)query.list();
		
	}
	
	public User getByUsername(String username){
		String hql = "from User where username = ?";
		return (User)this.getSession().createQuery(hql).setParameter(0, username).uniqueResult();
	}
}
