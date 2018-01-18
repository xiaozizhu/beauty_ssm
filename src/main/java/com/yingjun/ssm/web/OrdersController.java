package com.yingjun.ssm.web;

import com.yingjun.ssm.entity.Order;
import com.yingjun.ssm.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/orders/list");
		offset = offset == null ? 0 : offset;//默认便宜0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<Order> list = orderService.getOrderList(offset, limit);
		model.addAttribute("orderslist", list);
		return "orderslist";
	}

}
