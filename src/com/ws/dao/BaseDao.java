package com.ws.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ws.entity.Pager;
import com.ws.entity.SystemContext;
@Repository("baseDao")
public class BaseDao<T> implements IBaseDao<T>{
	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//��ȡ���͵�����ʱ��
	public Class<?> clz;
	public Class<?> getClz(){
		if(clz==null){
			clz = (Class<?>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
		}
		return clz;
	}
	
	public void add(T t) {
		// TODO Auto-generated method stub
		this.getSession().save(t);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(this.load(id));
		session.flush();
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.update(t);
		session.flush();
	}

	public T load(int id) {
		// TODO Auto-generated method stub
		T t =   (T)this.getSession().load(getClz(), id);
		return t;
		
	}
	public T get(int id) {
		// TODO Auto-generated method stub
		T t =   (T)this.getSession().get(getClz(), id);
		return t;
		
	}
	public List<T> list(String hql) {
		// TODO Auto-generated method stub
		return this.list(hql, null);
	}
	
	public List<T> list(String hql, Object obj) {
		// TODO Auto-generated method stub
		return this.list(hql, new Object [] {obj});
	}

	public List<T> list(String hql, Object[] obj) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery(hql);
		if(obj != null){
			for(int i = 0;i<obj.length;i++){
				query.setParameter(i, obj[i]);
			}
		}
		return query.list();
	}
	
	public Pager<T> pages(String hql, Object[] obj) {
		// TODO Auto-generated method stub
		Pager<T> pages = new Pager<T>();
		int pageSize = SystemContext.getPageSize();
		int pageIndex = SystemContext.getPageIndex();
		
		int start = (pageIndex - 1)*pageSize;
		
		Query q = this.getSession().createQuery(hql);
		Query cq = this.getSession().createQuery(countHql(hql));
		if(obj != null) {
			for(int i = 0;i < obj.length;i++) {
				q.setParameter(i, obj[i]);
				cq.setParameter(i, obj[i]);
			}
		}
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<T> datas = q.list();
		long t = (Long)cq.uniqueResult();
		int totalRecord = (int) t;
		int totalPage = (totalRecord - 1)/pageSize + 1;
		pages.setDatas(datas);
		pages.setPageIndex(pageIndex);
		pages.setTotalPage(totalPage);
		pages.setTotalRecord(totalRecord);
		System.out.println("总记录数"+pages.getTotalRecord());
		return pages; 
	}
	
	public String countHql(String hql) {
		//�õ�fromǰ����ַ�
	//select name form User
		String f = hql.substring(0, hql.indexOf("from"));
		//��fromǰ��������滻��select count(*)
		if(f == null || f.equals("")) {
			hql = "select count(*) " + hql;
		}
		else {
			hql = hql.replace(f, "select count(*) ");
		}
		return hql;
	}

	public Pager<T> pages(String hql, Object obj) {
		// TODO Auto-generated method stub
		return this.pages(hql, new Object[]{obj});
	}

	public Pager<T> pages(String hql) {
		// TODO Auto-generated method stub
		return this.pages(hql,null);
	}

}
