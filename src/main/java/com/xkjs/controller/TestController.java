package com.xkjs.controller;

import com.xkjs.mapper.ActivityMapper;
import com.xkjs.mapper.SignUpMapper;
import com.xkjs.mapper.TestMapper;
import com.xkjs.pojo.Activity;
import com.xkjs.pojo.Test;
import com.xkjs.pojo.User;
import com.xkjs.pojo.signUp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    TestMapper testMapper;


    @GetMapping("/test")
    @ResponseBody
    public List<Test> test()
    {
        testMapper.testqurry();
        return testMapper.testqurry();
    }
    @Autowired
    SignUpMapper signUpMapper;
    @GetMapping("/test/findAByUid")
    @ResponseBody
    public List<Activity> findAByUid()
    // public Activity findAById()
    {
        //String iid= map.get("uid");
       // int uid = Integer.parseInt(iid);
        //   testMapper.testqurry();
        // id=2;
        return  signUpMapper.findAllByUid(1);
    }

    @GetMapping("/test/insertJoin")
    @ResponseBody
    public int insertJoin()
    // public Activity findAById()
    {
        //String iid= map.get("uid");
        // int uid = Integer.parseInt(iid);
        //   testMapper.testqurry();
        // id=2;
        signUp signUp=new signUp();
        signUp.setAId(1);
        signUp.setUId(1);
        signUp.setStage(0);
        return  signUpMapper.insertJoin(signUp);
    }


    @Autowired
    ActivityMapper activityMapper;

    @GetMapping("/test/insertA")
    @ResponseBody
    public int  insertA()
    // public Activity findAById()
    {

        int aid;
        java.sql.Timestamp startData;
        java.sql.Timestamp endData;
        String detail;
        String teacher;
        String sponsor;
        String title;
        Activity activity=new Activity();
        activity.setDetail("测试");
        activity.setSponsor("aaaa");
        activity.setTeacher("aaaa");
        Timestamp time = new Timestamp(new Date().getTime());

        System.out.println("当前时间为:"+time);
        activity.setStartDate(time);
        activity.setEndDate(time);

        //String iid= map.get("uid");
        // int uid = Integer.parseInt(iid);
        //   testMapper.testqurry();
        // id=2;

        return  activityMapper.insertActivity(activity);
    }

    @GetMapping("/test/String")
    @ResponseBody
    public String testS()
    {
        testMapper.testqurry();
        Subject subject1 = SecurityUtils.getSubject();
        User currentUser=(User) subject1.getPrincipal();
        return currentUser.getUsername();
    }



}
