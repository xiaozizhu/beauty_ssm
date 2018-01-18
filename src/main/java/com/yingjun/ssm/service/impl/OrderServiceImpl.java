package com.yingjun.ssm.service.impl;

import com.yingjun.ssm.cache.RedisCache;
import com.yingjun.ssm.dao.OrderDao;
import com.yingjun.ssm.entity.Order;
import com.yingjun.ssm.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private RedisCache cache;
	
	
	@Override
	public List<Order> getOrderList(int offset, int limit) {
		String cache_key=RedisCache.CAHCENAME+"|getOrderList|"+offset+"|"+limit;
		//先去缓存中取
		List<Order> result_cache=cache.getListCache(cache_key, Order.class);
//		List<Order> result_cache=null;
		if(result_cache==null){
			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache=orderDao.queryAll(offset, limit);
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:"+cache_key);
		}else{
			LOG.info("get cache with key:"+cache_key);
		}
		return result_cache;
	}
	
	

}
