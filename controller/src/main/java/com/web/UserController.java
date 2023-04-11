package com.web;



import com.alibaba.fastjson2.JSON;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String helleSpringMvc(Model model){


        List<Object> query = userService.query();
        System.out.println();
        query.forEach((q)->{
            System.out.println(q);
        });
        String s = JSON.toJSONString(query);
        model.addAttribute("msg",s);
        return "hello";
    }

}
