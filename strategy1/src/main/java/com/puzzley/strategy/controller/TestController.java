package com.puzzley.strategy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yhj
 * @Date 2021/9/24
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test1")
    public String test1() throws InterruptedException {
        Thread.sleep(200);
        return "SUCCESS";
    }
}
