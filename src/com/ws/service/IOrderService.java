package com.ws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ws.dto.OrderDto;
import com.ws.entity.Order;


public interface IOrderService {
	public String add(HttpServletRequest req);

	public List<OrderDto> listMyOrder(HttpServletRequest req);

	public Object getById(int id);

	public String sendGod(int order_id);

	public String cancleOrder(int order_id);

	public String confirm(int order_id, String comment);
}
