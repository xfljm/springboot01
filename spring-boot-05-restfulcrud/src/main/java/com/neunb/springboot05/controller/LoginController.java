package com.neunb.springboot05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value="/user/login")
    public String dealLogin(String username, String password, Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username)&&password.equals("123456")){
            //防止重复登录，用重定向功能
            //需要这session中保存用户名
            session.setAttribute("loginname",username);
            return "redirect:/main.html";
            //return "dashboard";
        }else {
            map.put("msg","账号或密码错误");
            return "login";
        }
    }

}
