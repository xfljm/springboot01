package com.neunb.springbootecharts01.controller;

import com.neunb.springbootecharts01.dao.ShoppingMapper;
import com.neunb.springbootecharts01.pojo.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class EcharstController {
    @Autowired
    private ShoppingMapper shoppingMapper;

    @RequestMapping("/echarts")
    @ResponseBody
    public List<Shopping>  echartsController(HttpServletResponse response){
        List<Shopping> allShopping = shoppingMapper.findAllShopping();
        //注意： 主要有如下几个方法
        //public static final String toJSONString(Object object); //把一个Object对象序列化为JSON文本
        //public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
//        JSONArray array = JSONArray.parseArray(JSON.toJSONString(allShopping));
//
//        try {
//            response.getWriter().print(array);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return allShopping;
    }

    @RequestMapping(value= "/hello")
    public String toEcharts(){
        System.out.println("开始啦===================");
        return "/echarts";
    }
}
