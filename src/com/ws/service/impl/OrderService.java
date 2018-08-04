package com.ws.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.dao.IGodDao;
import com.ws.dao.IInfoDao;
import com.ws.dao.IOrderDao;
import com.ws.dto.OrderDto;
import com.ws.entity.God;
import com.ws.entity.Info;
import com.ws.entity.Order;
import com.ws.entity.User;
import com.ws.service.IOrderService;
import com.ws.util.DateUtil;
import com.ws.util.SendQQMail;
@Service
public class OrderService implements IOrderService{
	public static void main(String[] args) {
		final User user = new User(1, "王帅", "123", "山西", "123", "123@123", 1);
		user.setAddress("山西介休");
		System.out.println(user);
	}
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IGodDao godDao;
	@Autowired
	private IInfoDao infoDao;

/*	@Transactional
	public String add(final HttpServletRequest req) {
		final God god = godDao.load(Integer.parseInt(req.getParameter("god_id")));
		
		Callable<String> dbThread = new Callable<String>() {
			public String call() throws Exception {
				// TODO Auto-generated method stub
				try {
					//新建订单
					Order order = new Order();
					order.setAddress((String)req.getParameter("address"));
					order.setCreate_date(DateUtil.getNowTime());
					order.setUpdate_date(DateUtil.getNowTime());
					order.setGod(god);
					order.setPurcher((User)req.getSession().getAttribute("loginUser"));
					orderDao.add(order);
					//改变商品状态
					String hql = "update God set state = ? where id = ?";
					int state = 2;
					int id = god.getId();
					godDao.changestate(hql, id, state);
					//新建通知
					Info info = new Info();
					info.setContent("您有新的发布被购买,请及时发货!");
					info.setDate(DateUtil.getNowTime());
					info.setUser(god.getPublisher());
					infoDao.add(info);
					
					return "操作成功!";
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "操作失败!";
				}
			}
		};
		//给用户发邮件通知
		Callable<String> sendMailThread = new Callable<String>() {
			
			public String call() throws Exception {
				// TODO Auto-generated method stub
				MailUtil.sendEmail(god.getPublisher().getEmail());
				return "操作成功!";
			}
		};
		try {
			ExecutorService exec = Executors.newFixedThreadPool(4);
			Set<Callable<String>> set = new HashSet<Callable<String>>();
			set.add(dbThread);
			set.add(sendMailThread);
			List<Future<String>> result = exec.invokeAll(set);
			for(Future<String> rs : result){
				if(rs.get().equals("操作成功!")){ //如果都操作成功,结束循环,返回成功;
					continue;					//有一个失败,则返回失败;
				}else{
					return "操作失败!";
				}
			}
			return "操作成功!";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exec.shutdown();
		}
		
		return "操作失败";
		
	}
*/	
	public String add(final HttpServletRequest req) {
		String mailmessage = null;
		try {
			God god = godDao.getAddInfo(Integer.parseInt(req.getParameter("god_id")));
			System.out.println(god);
			Order order = new Order();
			order.setAddress((String)req.getParameter("address"));
			order.setCreate_date(DateUtil.getNowTime());
			order.setUpdate_date(DateUtil.getNowTime());
			order.setGod(god);
			order.setPurcher((User)req.getSession().getAttribute("loginUser"));
			orderDao.add(order);
			
			//改变商品状态
			String updateGod = "update God set state = ? where id = ?";
			int state = 2;
			int id = god.getId();
			godDao.changestate(updateGod, id, state);
			
			//新建通知
			String info_content = "您在校园二手网站发布的商品已经被被购买,请及时发货!"
									+"<a target=_blank href='http://123.206.14.25:8080/SchoolSecondHandWeb/SchoolSecondHandWeb/main'>"
									+ "点击查看</a>";
				
			Info info = new Info();
			info.setContt(info_content);
			info.setDate(DateUtil.getNowTime());
			info.setUser(god.getPublisher());
			String selectOrder = "from Order o where o.god.id = "+god.getId()+" order by o.id desc";
			Order od = (Order) orderDao.list(selectOrder).get(0);
			info.setOrder(od);
			infoDao.add(info);
			//发送邮件通知用户发货
//			MailUtil.sendEmail(god.getPublisher().getEmail());
			mailmessage = SendQQMail.sendMail(god.getPublisher().getEmail(), info_content);
			return "操作成功!"+mailmessage;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "操作失败!"+mailmessage;
	}
	public List<OrderDto> listMyOrder(HttpServletRequest req) {
		// TODO Auto-generated method stub
		User user = (User) req.getSession().getAttribute("loginUser");
		if(user == null){
			throw new RuntimeException("请您先登录哟~~");
		}
		return orderDao.listMyOrder(user.getId());
		
	}
	public Object getById(int id) {
		// TODO Auto-generated method stub
/*		Object queryObj =  orderDao.getSomeInfo(id);
		String info = JSONObject.toJSONString(queryObj);
		String info1 = info.replaceAll(",", "");
		String info2 = info1.substring(2, info1.length()-2);	
		String [] arr = info2.split("\"");
		String [] nowarr = new String[arr.length];
		
		for(int i = 0,j = 0; i< arr.length; i++){
			if(!arr[i].equals("")){
				nowarr[j] = arr[i];
				j++;
			}
		}
		String [] obj = new String[12];
		
    	for(int i = 0,j = 0; i < nowarr.length; i += 2){
    			obj[i] = String.valueOf(i);
        		obj[i+1] = String.valueOf(nowarr[j]);
        		j++;
    	}
    	return JSONObject.toJSONString(obj);
*/	
		return orderDao.getSomeInfo(id);
	}
	public String sendGod(int order_id) {
		try {
			//修改商品状态为已发货
			Order order = orderDao.get(order_id);
			order.setState(1);
			order.setUpdate_date(DateUtil.getNowTime());
			orderDao.update(order);
			//修改消息状态为-已处理
			Info info = order.getInfo();
			info.setState(1);
			infoDao.update(info);
			
			return "操作成功!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "操作失败!请稍后再试!";
		}
	}
	public String cancleOrder(int order_id) {
		// TODO Auto-generated method stub
		try {
			Order order = orderDao.getOrderIdAndMakerId(order_id);
			if(order.getState() == 1) {
				return "卖家已发货,无法取消订单!";
			}else {
//				order.setState(3);
//				order.setUpdate_date(DateUtil.getNowTime());
//				orderDao.update(order);
				try {
					orderDao.cancleOrder(order_id);
				} catch (Exception e) {
					e.printStackTrace();
					return "操作失败,请联系网管!";
				}
				//改变商品状态
				String updateGod = "update God set state = ? where id = ?";
				int state = 0;
				int id = order.getGod().getId();
				godDao.changestate(updateGod, id, state);
				
				Info info = new Info();
				info.setUser(order.getGod().getPublisher());
				info.setOrder(order);
				info.setContt("您的订单["+order.getGod().getName()+"]已被取消!");
				info.setDate(DateUtil.getNowTime());
				infoDao.add(info);
				return "取消成功!";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "系统错误,请稍后重试!";
		}
	}
	public String confirm(int order_id, String comment) {
		// TODO Auto-generated method stub
		try {
			Order order = orderDao.load(order_id);
			order.setState(2);
			order.setUpdate_date(DateUtil.getNowTime());
			order.setComment(comment);
			orderDao.update(order);
			return "操作成功!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "系统错误,请稍后重试!";
		}
	}
}
