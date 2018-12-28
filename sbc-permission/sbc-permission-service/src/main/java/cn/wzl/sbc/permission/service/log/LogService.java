package cn.wzl.sbc.permission.service.log;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.Log;

/**
 * @Author wzl
 * @Date 2018/12/28 11:15
 * @doc LogService
 **/
public interface LogService {
    /**
     * 插入一条日志
     * @param log
     * @return
     */
    MessageResult insertLog(Log log);
}
