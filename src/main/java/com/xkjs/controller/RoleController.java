package com.xkjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauthor" )//未登录
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "400");
        map.put("msg", "未登录");
        return map;
    }

    @RequestMapping(value = "/unlogin" )//未登录
    @ResponseBody
    public Object unlogin() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "401");
        map.put("msg", "没有权限");
        return map;
    }
}
