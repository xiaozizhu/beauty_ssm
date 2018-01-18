package com.yingjun.common.api;

import java.util.Map;

/**
 * API 响应对象
 * 
 * @author
 * @since 2017年4月20日
 */
public class ApiRes {

    /**
     * @see ApiCode
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 响应体
     */
    private Map<String, Object> body;
    /**
     * 扩展字段
     */
    private Map<String, Object> extra;

    public static final ApiRes InvalidActionResponse = new ApiRes(ApiCode.INVALID, ApiMsg.INVALID_ACTION);

    public ApiRes() {
        this.code = ApiCode.OK;
    }

    public ApiRes(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}