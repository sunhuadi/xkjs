package com.xkjs.controller;

import com.xkjs.mapper.SignUpMapper;
import com.xkjs.pojo.Bala;
import com.xkjs.pojo.User;
import com.xkjs.pojo.signUp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SignUpController {

    @Autowired
    SignUpMapper signUpMapper;

    @ResponseBody
    @PostMapping ("/insertJoin")
    public HashMap<String, String> insertJoin(@RequestBody  signUp s, HttpServletRequest request)
    {
        HashMap<String, String> mp = new HashMap<String, String>();
        System.out.println("已经接受请求，正在处理......");
        System.out.println(s);
        Object loginuid = request.getSession().getAttribute("uid");
        System.out.println(loginuid);
        if (loginuid!=null)
        {
            s.setUId((int) loginuid);
        }
        System.out.println(s);
        if(signUpMapper.findSByUidAid(s)!=null)
        {
            mp.put("code","0");
            mp.put("msg","该比赛你已经报名");
            return mp;
        }

        System.out.println(loginuid);
        signUpMapper.insertJoin(s);
        mp.put("code","1");
        mp.put("msg","报名成功");
       // System.out.println(currentUser);
        return mp;
    }
    @ResponseBody
    @PostMapping ("/insertCheck")
    public int insertCheck(@RequestBody signUp signUp)
    {
        return  signUpMapper.updataS(signUp);
    }

    @ResponseBody
    @GetMapping ("/findAllCheck")
    public List<Bala>findAllCheck() {
        return signUpMapper.findAllCheck();
    }

}
