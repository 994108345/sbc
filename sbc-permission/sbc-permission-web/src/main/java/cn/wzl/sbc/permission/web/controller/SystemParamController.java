package cn.wzl.sbc.permission.web.controller;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.permission.service.systemparam.SystemParamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2019/1/9 17:01
 * @doc SystemParamController
 **/
@RestController
@RequestMapping("sbc-permission/SystemParam")
public class SystemParamController {

    @Resource
    private SystemParamService systemParamService;

    /**
     * 秒杀接口
     * @return
     */
    @PostMapping("secKill")
    @ResponseBody
    public MessageResult secKill(){
        return systemParamService.secKill();
    }
}
