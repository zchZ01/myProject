package com.spring.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页相关的控制器
 */
@Controller
public class IndexController {

    /**
     * 访问首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){

        return "frame/index";
    }
}
