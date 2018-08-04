package com.ws.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ws.dao.ICollectionDao;
import com.ws.dao.IGodDao;
import com.ws.entity.Collection;
import com.ws.entity.God;
import com.ws.entity.Pager;
import com.ws.entity.User;
import com.ws.exception.MyRuntimeException;
import com.ws.service.ICollectionService;
import com.ws.util.DateUtil;
@Service("collectionService")
public class CollectionSercice implements ICollectionService{
	private IGodDao godDao;
	private ICollectionDao collectionDao;
	@Resource
	public void setGodDao(IGodDao godDao) {
		this.godDao = godDao;
	}
	@Resource
	public void setCollectionDao(ICollectionDao collectionDao) {
		this.collectionDao = collectionDao;
	}

	public void add(HttpServletRequest req) {
		// TODO Auto-generated method stub
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user == null){
			throw new MyRuntimeException("请先登录!");
		}
		int gid = 0;
		try {
			gid = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		God god = godDao.load(gid);
		int uid = user.getId();
		if(god.getPublisher().getId() == uid){
			throw new MyRuntimeException("还想收藏自己的东西?");
		}
		
		String hql = "from Collection where user.id = ? and god.id = ?";
		
		List<Collection> colist = collectionDao.list(hql, new Object[]{uid,gid});
		if(colist.size() > 0){
			throw new MyRuntimeException("已经加入收藏了!");
		}
		Collection collection = new Collection(user, god,DateUtil.getNowTime());
		collectionDao.add(collection);
		
		
	}

	public void delete(int id, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	public Pager<Collection> pageMyCollection(HttpServletRequest req) {
		// TODO Auto-generated method stub
		User u = (User)req.getSession().getAttribute("loginUser");
		if(u == null){
			throw new RuntimeException("请您先登录!~");
		}
		int id = u.getId();
		String hql = "from Collection where user.id = ? and god.state = 0";
		return collectionDao.pages(hql, id);
		
	}
	public String removeCollection(HttpServletRequest req) {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			collectionDao.delete(id);
			return "移除成功!";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "操作失败,请呼叫网管!";
		}
	}

}
