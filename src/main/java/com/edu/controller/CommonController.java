package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共跳转
 *
 * @author ham
 */
@Controller
public class CommonController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
