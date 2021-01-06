package com.xkjs.controller;

import com.xkjs.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LoginController {


    @ResponseBody
    @PostMapping("/logins")
    public HashMap<String, String> Test(@RequestBody HashMap<String, String> user) {
        HashMap<String, String> mp = new HashMap<String, String>();
        System.out.println("执行登陆控制！");
        String username = user.get("username");
        String password = user.get("password");
        System.out.println(username);
        System.out.println(password);
        Subject subject = SecurityUtils.getSubject();

        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登陆方法
            Subject subject1 = SecurityUtils.getSubject();
            User currentUser = (User) subject1.getPrincipal();
            mp.put("code", "0");
            mp.put("msg", "密码正确，登陆成功。");
            mp.put("role", currentUser.getRole());
            mp.put("username", currentUser.getUsername());
            ///System.out.println(currentUser.getPassword());

            return mp;
        } catch (UnknownAccountException e)//用户名不存在
        {
            mp.put("code", "1");
            mp.put("msg", "该用户不存在，请重新输入。");
            return mp;
        } catch (IncorrectCredentialsException e) {
            mp.put("code", "2");
            mp.put("msg", "密码错误，请重新输入密码。");
            return mp;
        }
    }
}
