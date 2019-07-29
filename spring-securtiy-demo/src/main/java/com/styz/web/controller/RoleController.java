package com.styz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * creat date:2019-07-26 16:52
 * author:xxydliuyss
 * note:
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @RequestMapping("/index")
    public String showRoles(Model model){
        return "role/roleIndex::roleIndex";
    }
}
