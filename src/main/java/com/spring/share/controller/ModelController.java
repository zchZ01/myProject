package com.spring.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 各个板块跳转
 */
@Controller
public class ModelController {

    @RequestMapping("/single")
    public String singleMovie(){
        return "frame/single";
    }
}
