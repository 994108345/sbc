package cn.wzl.sbc.eureka.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author wzl
 * @Date 2018/12/12 17:33
 * @doc EurekaServerTestController
 **/
@RestController
@RequestMapping("eureka-server")
public class EurekaServerTestController {

    @PostMapping("connect")
    @ResponseBody
    public String eurekaConnect(){
        System.out.println("gogogogo");
        return "eureka success";
    }
}
