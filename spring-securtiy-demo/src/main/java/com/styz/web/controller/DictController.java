package com.styz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * creat date:2019-07-26 16:51
 * author:xxydliuyss
 * note:
 */
@Controller
@RequestMapping("/dict")
public class DictController {

    @RequestMapping("/index")
    public String showDicts(Model model){
        return "dict/dictIndex::dictIndex";
    }
}
