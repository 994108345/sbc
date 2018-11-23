package cn.wzl.sbc.redis.build.controller;

import cn.wzl.sbc.common.result.CommonResult;
import cn.wzl.sbc.common.result.ResultConstant;
import cn.wzl.sbc.redis.service.TokenService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author user
 * @Date 2018/11/20 11:02
 **/
@RestController
@RequestMapping("/sbc/redis")
public class TokenController {
    @Resource
    private TokenService tokenService;

    @RequestMapping(value = "/setToken" ,method = RequestMethod.POST)
    public CommonResult setToken(@RequestBody String token){
        CommonResult result = new CommonResult();
        if(StringUtils.isBlank(token)){
            result.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
            result.setStatus(ResultConstant.CODE.ERROR);
            return result;
        }
        return tokenService.setToken(token);
    }
}
