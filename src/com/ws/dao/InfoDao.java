package com.ws.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.ws.dto.InfoDto;
import com.ws.entity.Info;
@Repository
public class InfoDao extends BaseDao<Info> implements IInfoDao{

	public List<InfoDto> listMyInfo(int id) {
//		String hql = "from Info where user.id = "+user.getId();
		try {
			String hql = 	"select new com.ws.dto.InfoDto "+
							"(i.id as infoId, gd.id as godId,od.id as orderId,i.contt as content,i.date as date,i.state as state)"+
							"from Info i "+
							"left join i.user u "+
							"left join i.order od "+
							"left join od.god gd "+
							"where u.id = ?";
			
			return this.getSession().createQuery(hql).setParameter(0, id).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			String hql = 	"select new com.ws.dto.InfoDto "+
							"(i.id as infoId,i.contt as content,i.date as date,i.state as state)"+
							"from Info i "+
							"left join i.user u "+
							"where u.id = ?";
			return this.getSession().createQuery(hql).setParameter(0, id).list();
		}
	}

}
