package com.yingjun.ssm.api;




import com.yingjun.common.api.ApiCode;
import com.yingjun.common.api.ApiRes;
import com.yingjun.ssm.dto.BaseResult;
import com.yingjun.ssm.entity.User;
import com.yingjun.common.HttpRequest.HttpUtil;
import com.yingjun.ssm.enums.ResultEnum;
import com.yingjun.ssm.exception.BizException;
import com.yingjun.ssm.service.UserService;
import com.yingjun.ssm.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserApiController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;


	@ResponseBody
	@RequestMapping(value = "/mine/api", method = RequestMethod.GET)
	public Map mine_api(@CookieValue("userPhone") Long userPhone,
		@RequestParam("user_phone" ) Long user_phone) {
		LOG.info("invoke----------/user/mine/api-------------apiController");

		HashMap<String,Object> resBody = new HashMap<>();

		userPhone = userPhone == null ? 0 : userPhone;

		userPhone = userPhone == 0 ? user_phone : userPhone;

		User userinfo = userService.getUserById(userPhone);
		resBody.put("code",ApiCode.OK);
		resBody.put("msg","获取用户信息成功");
		resBody.put("data",userinfo);
		LOG.info("invoke----------/user/mine/api+result="+resBody);
		return resBody;
	}

	@RequestMapping(value = "/misc", method = RequestMethod.GET)
	@ResponseBody
	public Map getUserMisc(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/misc");
		HashMap<String,Object> mm = new HashMap<>();
		mm.put("code",ApiCode.OK);
		mm.put("message","success");

		try{
			HashMap<String,String> param = new HashMap<>();

			param.put("ids","12,13,14");
			param.put("search_column","deal_city_id");
			param.put("fields","deal_city_name");

			HttpUtil http= new HttpUtil();

			String  obj = http.get("/goods/list",param);
			LOG.info(obj);

			mm.put("data",obj);


		}catch (Exception e){
			mm.put("data","error");

		}




		return mm;
	}



	/*
        * 获取code(int)
        */
//	public static JSONObject jsonGetcode(String jsonString) throws JSONException{
//
//		JSONObject json= new JSONObject();
//
//		json.getJSONObject(jsonString);
//
//		return json;
//	}



}
