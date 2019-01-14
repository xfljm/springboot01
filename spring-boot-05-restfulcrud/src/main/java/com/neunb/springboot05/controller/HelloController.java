package com.neunb.springboot05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String testOne(){
        return "say hello";
    }

    @RequestMapping("/success")
    public String testTwo(Map<String,Object> map){
        map.put("hello","您好呀");
        map.put("text","<h1>测试内容</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

//    @RequestMapping(value = {"/","/index.html"})
//    public String testThree(){
//        return "login";
//    }
}
