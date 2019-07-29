package com.styz.web.controller;

import com.styz.api.model.SysActionLog;
import com.styz.service.SyslogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * creat date:2019-07-25 15:08
 * author:xxydliuyss
 * note:
 */
@Controller
@RequestMapping("/syslog")
@Slf4j
public class SyslogController {
    @Autowired
    private SyslogService syslogService;
    @RequestMapping("/index")
    public String showlogs(Model model, HttpSession session){
        List<SysActionLog> syslogs = syslogService.getSyslogs();
        log.info("日志管理....");
        model.addAttribute("syslogs","hello test");
        log.info("Menu:\t{}",session.getAttribute("treeMenu"));
        return "syslog/test::syslog";
    }
}
