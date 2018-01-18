package com.yingjun.ssm.web;

import com.yingjun.common.api.ApiCode;
import com.yingjun.common.api.ApiReq;
import com.yingjun.common.api.ApiRes;
import com.yingjun.ssm.dto.BaseResult;
import com.yingjun.ssm.entity.User;
import com.yingjun.ssm.enums.ResultEnum;
import com.yingjun.ssm.exception.BizException;
import com.yingjun.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/list");
		offset = offset == null ? 0 : offset;//默认便宜0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<User> list = userService.getUserList(offset, limit);
		model.addAttribute("userlist", list);
		return "userlist";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/login");
		return "login";
	}

	@RequestMapping(value = "/mine", method = RequestMethod.GET)
	public String mine(Model model,Long userPhone) {
		LOG.info("invoke----------/user/mine");
		userPhone = userPhone== null ?  0 : userPhone;

		User userinfo = userService.getUserById(userPhone);

		model.addAttribute("mine", userinfo);

		return "mine";
	}


	@RequestMapping(value = "/mineapi", method = RequestMethod.GET)
	public String mineapi(Model model,Long user_phone) {

		user_phone = user_phone == null ? 0 :user_phone;

		LOG.info("invoke----------/user/mineapi");

		User userinfo = userService.getUserById(user_phone);


		model.addAttribute("mineapi", userinfo);

		return "mineapi";
	}


	@RequestMapping(value = "/login01", method = RequestMethod.GET)
	public String login01(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/login01");
		return "login01";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String userAdd(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/add");
		return "useradd";
	}



	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult<Object> userAdd(@Valid User user, BindingResult result) {
		LOG.info("invoke----------/user/add-post");
		long userPhone=user.getUserPhone();
		String userName=user.getUserName();
		String passwd=user.getpasswd();

		try{

			Boolean ret=userService.addUser(userPhone,userName,passwd);
			if (ret){
				return new BaseResult<Object>(true, null);
			}else{
				return new BaseResult<Object>(false, "用户注册失败");
			}

		}catch  (BizException e) {
			return new BaseResult<Object>(false, e.getMessage());
		} catch (Exception e) {
			return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
		}
	}


	@RequestMapping(value = "/assert", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult<Object> assertLogin(@Valid User user, BindingResult result) {
		LOG.info("invoke----------/user/assert");
		long userPhone=user.getUserPhone();
		String passwd=user.getpasswd();
		try{

			Boolean ret=userService.assertUser(userPhone,passwd);
			if (ret){
				return new BaseResult<Object>(true, null);
			}else{
				return new BaseResult<Object>(false, "用户名或者密码错误");
			}

		}catch  (BizException e) {
			return new BaseResult<Object>(false, e.getMessage());
		} catch (Exception e) {
			return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
		}


	}

}
