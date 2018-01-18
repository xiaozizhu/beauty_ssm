package com.yingjun.ssm.service;

import java.util.List;
import java.util.Map;

import com.yingjun.ssm.entity.User;

public interface UserService {

	List<User> getUserList(int offset, int limit);

	Boolean assertUser(long userPhone,String passwd) ;

	Boolean addUser(long userPhone,String userName,String passwd) ;

	User getUserById(long userPhone);
	 
}
