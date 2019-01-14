package com.neunb.springboot05.controller;

import com.neunb.springboot05.dao.EmployeeDao;
import com.neunb.springboot05.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emp")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //将结果放在请求域中
        model.addAttribute("emps",employees);


        //thyemleaf会自动拼接，注意不能再emp前面添加/
        return "emp/list";
    }
}
