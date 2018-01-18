package com.yingjun.ssm.service;

import com.yingjun.ssm.entity.Order;
import com.yingjun.ssm.entity.User;

import java.util.List;

public interface OrderService {

	List<Order> getOrderList(int offset, int limit);
	 
}
