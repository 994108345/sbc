package cn.wzl.sbc.permission.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wzl
 * @Date 2018/12/13 10:51
 * @doc TestController
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("get")
    @ResponseBody
    public String getTest(){
        return "李红波";
    }

    @GetMapping("wzl")
    @ResponseBody
    public String getWzl(){
        return "温在龙是个sb";
    }

    @GetMapping("lhb")
    @ResponseBody
    public String getLhb(){
        return "李红波是个笨蛋";
    }
}
