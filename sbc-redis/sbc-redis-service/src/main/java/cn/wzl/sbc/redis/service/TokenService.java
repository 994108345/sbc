package cn.wzl.sbc.redis.service;

import cn.wzl.sbc.common.result.CommonResult;

public interface TokenService {

    CommonResult setToken(String token);
}
