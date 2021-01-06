package com.xkjs.controller;

import com.xkjs.mapper.ActivityMapper;
import com.xkjs.mapper.SignUpMapper;
import com.xkjs.mapper.TestMapper;
import com.xkjs.pojo.Activity;
import com.xkjs.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
        //String iid= map.get("uid");
        // int uid = Integer.parseInt(iid);
        //   testMapper.testqurry();
        // id=2;
        return  activityMapper.insertActivity(activity);
    }



}
