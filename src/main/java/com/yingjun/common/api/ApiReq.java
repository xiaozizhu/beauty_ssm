package com.yingjun.common.api;

import java.util.Map;

/**
 * API 请求对象
 *
 */
public class ApiReq {

    /**
     * 路径或动作
     */
    private String path;
    /**
     * 请求体
     */
    private Map<String, Object> body;
    /**
     * 额外扩展信息
     */
    private Map<String, Object> extra;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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