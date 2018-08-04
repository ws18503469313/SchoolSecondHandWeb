package com.ws.service;

import javax.servlet.http.HttpServletRequest;

import com.ws.entity.Collection;
import com.ws.entity.Pager;

public interface ICollectionService {
	/**
	 * 
	 * @param id	从界面传过来的商品id,查出来赋给一个新的Collection
	 * @param req	从HttpServletRequest中获取操作者,赋给Collection,如果未登录,提示用户先登录
	 */
	public void add(HttpServletRequest req);
	public void delete(int id,HttpServletRequest req);
	/**
	 * 列取我的收藏
	 * @param req	从req中获取 User
	 * @return
	 */
	public Pager<Collection> pageMyCollection(HttpServletRequest req);
	/**
	 * 
	 * @param req	从req中获取要删除的Collection 的id
	 * @return		操作状态
	 */
	public String removeCollection(HttpServletRequest req);
}
