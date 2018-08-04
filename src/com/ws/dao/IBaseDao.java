package com.ws.dao;

import java.util.List;

import com.ws.entity.Pager;
/**
 * 
 * @author polunzi
 *
 * @param <T> ���������ʱ��
 * 
 */
public interface IBaseDao<T> {
	public void add(T t);
	public void delete(int id);
	public void update(T t);
	/**
	 * Load 		������ѯʵ����ķ���
	 * @param id	������ײ�ѯ�����ID
	 * @return		�����ݿ�鵽�Ķ���
	 */
	public T load(int id);
	public T get(int id);
	/**
	 * 
	 * 
	 * @param hql	Hibernate�Ĳ�ѯ���
	 * 					Ȼ�����(String hql,Object obj)����,objΪnull
	 * @return		��ѯ���Ľ����
	 */
	public List<T> list(String hql);
	/**
	 * 
	 * @param hql	Hibernate�Ĳ�ѯ���
	 * @param obj	��ѯ����еĲ�����,��obj�ŵ�obj�����е���
	 * 					list(String hql,Object [] obj)����
	 * @return		
	 */
	public List<T> list(String hql,Object obj);
	/**
	 * 
	 * @param hql	Hibernate�Ĳ�ѯ���
	 * @param obj	��ѯ����еĲ���������ʽ,�ù�ѭ�����ò���
	 * @return		
	 */
	public List<T> list(String hql,Object [] obj);
	/**
	 * 				ֱ�ӵ���pages(String hql,Object obj)����,obj����Ϊnull
	 */
	public Pager<T> pages(String hql);
	/**
	 * 
	 * @param obj		����һ��������HQL���,��obj�Ŵ�Ŷobj������,����
	 * 						pages(String hql,Object [] obj)�����õ���ҳ�Ľ����
	 */
	public Pager<T> pages(String hql,Object obj);
	/**
	 * @param obj		HQL����еĶ����������,ͨ��ѭ�����ò���
	 */
	public Pager<T> pages(String hql,Object [] obj);
}
