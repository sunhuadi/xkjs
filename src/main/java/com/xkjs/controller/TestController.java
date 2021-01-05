package com.xkjs.controller;

import com.xkjs.mapper.TestMapper;
import com.xkjs.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
