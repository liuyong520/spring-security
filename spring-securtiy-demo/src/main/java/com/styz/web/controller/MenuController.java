package com.styz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * creat date:2019-07-26 16:44
 * author:xxydliuyss
 * note:
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @RequestMapping("/index")
    public String showMenus(Model model){
        return "menu/menuIndex::menuIndex";
    }
}
