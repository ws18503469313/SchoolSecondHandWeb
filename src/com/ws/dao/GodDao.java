package com.ws.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ws.entity.God;
@Repository("godDao")
public class GodDao extends BaseDao<God> implements IGodDao {

	public String changestate(String hql,int id,int state) {
		// TODO Auto-generated method stub
		try {
			Query query = this.getSession().createQuery(hql);
			query.setParameter(0, state);
			query.setParameter(1, id);
			query.executeUpdate();
			return "操作成功!";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "操作失败!";
		}
	}

	public void updateClickTime(int id) {
		try {
			String hql = "select clickTime from God g where g.id = " +id;
			Session session = this.getSession();
			Object obj = session.createQuery(hql).uniqueResult();
			int clickTime = (Integer)obj +1;
			String updateHql = "update God g set g.clickTime = ? where g.id = ?";
			session.createQuery(updateHql).setParameter(0, clickTime).setParameter(1, id).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}


	public void updateGodState(int id, int state) {
		String hql = "update God set state = ? where id = ?";
		this.getSession().createQuery(hql).setParameter(0, state).setParameter(1, id).executeUpdate();
	
	}

	public int getUserId(int id) {
		String hql = "select u.id from God gd left join gd.publisher u where gd.id = ?";
		
		return (Integer) this.getSession().createQuery(hql).setParameter(0, id).uniqueResult();
	}

	public God getAddInfo(int god_id) {
		String hql = 	"select new com.ws.entity.God "+
						"(g.id as godId,u.id as uId,u.email as email) "+
						"from God g "+
						"left join g.publisher u "+
						"where g.id = ?";
		return (God) this.getSession().createQuery(hql).setParameter(0, god_id).uniqueResult();
	}
	
}
