package com.ws.dao;

import java.util.List;

import com.ws.dto.OrderDto;
import com.ws.entity.Order;

public interface IOrderDao extends IBaseDao<Order>{

	List<OrderDto> listMyOrder(int id);

	Object getSomeInfo(int id);

	Object getById(int order_id);

	void cancleOrder(int order_id);

	Order getOrderIdAndMakerId(int order_id);


	

}
