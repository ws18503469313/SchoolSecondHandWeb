package com.ws.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ws.dto.OrderDto;
import com.ws.entity.Order;
import com.ws.util.DateUtil;
@Repository
public class OrderDao extends BaseDao<Order> implements IOrderDao{

	public List<OrderDto> listMyOrder(int id) {
		// TODO Auto-generated method stub
		String hql = 	"select new com.ws.dto.OrderDto" +
						"(od.id as odId,gd.id as godId,gd.name as godname,gd.price as price,od.address as address,"+ 
						"od.state as state,od.create_date as createTime,od.update_date as updateTime) "+ 
						"from Order od " +
						"left join od.god gd " +
						"left join od.purcher u " +
						"where u.id = ?" ;	
		Query query = this.getSession().createQuery(hql)
										.setParameter(0,id);
		
		return query.list();
	}

	public Object getSomeInfo(int id) {
		System.out.println("id"+id+"____________---");
		// TODO Auto-generated method stub
/*		<tr><td>商品名称</td><td class="god_name"></td></tr>
		<tr><td>商品价格</td><td class="god_name"></td></tr>
		<tr><td>卖家姓名</td><td class="purcher_name"></td></tr>
		<tr><td>卖家联系方式</td><td class="purcher_phone"></td></tr>
		<tr><td>卖家地址</td><td class="purcher_address"></td></tr>
		<tr><td>下单时间</td><td class="create_time"></td></tr>
*/		String sql  = 	"select " +
							" gd.name,gd.price,u.username,u.phone,u.address,od.address as realaddress, " +
							" od.create_date,od.state,od.update_date,od.comment " +
						" from " +
						" t_order od " +
							" left outer join t_gods gd " +
								" on od.god_id = gd.id " +
							" left outer join t_user u " +
								" on od.pucher_id = u.id " +
						"where od.id = "+id;
		Query query = this.getSession().createSQLQuery(sql);
/*										.addEntity("gd", God.class)
										.addEntity("u", User.class)
										.addEntity("od", Order.class)
										.setResultTransformer(Transformers.aliasToBean(Order.class));
*/		return query.uniqueResult();
		 
	}

	public Object getById(int order_id) {
		String hql = "select od.id,gd.id form Order od left join od.god gd where od.id = ?";
		return  this.getSession().createQuery(hql).setParameter(0, order_id).uniqueResult();
	}

	public void cancleOrder(int order_id) {
//			String hql = "update Order od set od.update_date = ?, od.state = 3 where od.id = ?";
//			this.getSession().createQuery(hql).setParameter(0, DateUtil.getNowTime()).setParameter(1, order_id).executeUpdate();
		String sql = "update t_order od set od.update_date = '"+DateUtil.getNowTime()+"', od.state = 3 where od.id = "+order_id;
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	public Order getOrderIdAndMakerId(int order_id) {
		String hql = "select new com.ws.entity.Order(od.id as id,u1.id as purcherId, u2.id as godPublisherId,od.state as state,gd.name as godname) "+
						"from Order od "+
						"left join od.purcher u1 "+
						"left join od.god gd "+
						"left join gd.publisher u2 "+
						"where od.id = ?";
		
		return (Order) this.getSession().createQuery(hql).setParameter(0, order_id).uniqueResult();
	}

}
