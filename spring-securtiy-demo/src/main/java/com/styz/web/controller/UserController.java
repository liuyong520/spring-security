package com.styz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * creat date:2019-07-26 16:41
 * author:xxydliuyss
 * note:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String showUsers(Model model){
        return "user/userIndex::userIndex";
    }
}
