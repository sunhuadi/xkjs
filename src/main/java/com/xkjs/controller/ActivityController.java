package com.xkjs.controller;

import com.xkjs.mapper.ActivityMapper;
import com.xkjs.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/findAById")
    @ResponseBody
   // public Activity findAById(@RequestBody HashMap<String,String> map)
    public Activity findAById()
    {
        //String iid= map.get("id");
       // int id = Integer.parseInt(iid);
        //   testMapper.testqurry();
       // id=2;
        return  activityMapper.findAById(2);
    }
}
