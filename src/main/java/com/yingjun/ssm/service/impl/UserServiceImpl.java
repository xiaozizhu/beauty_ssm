package com.yingjun.ssm.service.impl;

import com.yingjun.ssm.cache.RedisCache;
import com.yingjun.ssm.dao.UserDao;
import com.yingjun.ssm.dto.BaseResult;
import com.yingjun.ssm.entity.User;
import com.yingjun.ssm.enums.ResultEnum;
import com.yingjun.ssm.exception.BizException;
import com.yingjun.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisCache cache;
	
	
	@Override
	public List<User> getUserList(int offset, int limit) {
		String cache_key=RedisCache.CAHCENAME+"|getUserList|"+offset+"|"+limit;
		//先去缓存中取
		List<User> result_cache=cache.getListCache(cache_key, User.class);
		if(result_cache==null){
			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache=userDao.queryAll(offset, limit);

			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:"+cache_key);
		}else{
			LOG.info("get cache with key:"+cache_key);
		}
		return result_cache;
	}

	@Override
	public Boolean assertUser(long userPhone,String passwd) {
		User user=userDao.assertUser(userPhone);
		try{
			if (user.getpasswd().equals(passwd)){
				long id=user.getUserId();
				LOG.info("-----------id="+id);
				return true;
			}else{
				return false;
			}

		}catch (BizException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getUserById(long userPhone) {

		User user=userDao.getUserInfo(userPhone);
		try{
			if (user!=null){
				LOG.info("查询到userPhone对应的数据+"+user);
				return user;
			}else{
				return new User();
			}


		}catch (BizException e) {
			return new User();
		} catch (Exception e) {
			return new User();
		}
	}


	@Override
	public Boolean addUser(long userPhone,String userName,String passwd) {
		LOG.info("-----------into+user+service+Impl,userPhone="+userPhone+"userName="+userName+"passwd="+passwd);
		userDao.addUser(userPhone,userName,passwd);
		LOG.info("-----------into+user+service+Impl");
		User user=userDao.queryByPhone(userPhone);

		try{
			if (user.getUserId()!=0){
				LOG.info("-----------id="+user.getUserId());
				return true;
			}else{
				return false;
			}

		}catch (BizException e) {
			return false;
		} catch (Exception e) {
			return false;
		}


	}
}
