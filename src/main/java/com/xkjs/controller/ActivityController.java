package com.xkjs.controller;

import com.xkjs.mapper.ActivityMapper;
import com.xkjs.mapper.SignUpMapper;
import com.xkjs.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    ActivityMapper activityMapper;
    @GetMapping("/findA")
    @ResponseBody
    public List<Activity> test()
    {
     //   testMapper.testqurry();
        return activityMapper.findAll();
    }

    @PostMapping("/findAById")
    @ResponseBody
    public Activity findAById(@RequestBody HashMap<String,Integer> map)
    {
        int iid= map.get("id");

        return  activityMapper.findAById(iid);//通过活动id查询详情
    }

    @Autowired
    SignUpMapper signUpMapper;

    @PostMapping("/findAByUid")
    @ResponseBody
    public List<Activity> findAByUid(@RequestBody HashMap<String,String> map)
    {
        String iid= map.get("uid");
        int uid = Integer.parseInt(iid);
        //   testMapper.testqurry();
        // id=2;
        return  signUpMapper.findAllByUid(uid);//通过活动id查询详情
    }







}
