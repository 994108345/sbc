package cn.wzl.sbc.permission.service.log.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.permission.Log;
import cn.wzl.sbc.permission.dao.bean.LogDao;
import cn.wzl.sbc.permission.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2018/12/28 11:16
 * @doc LogServiceImpl
 **/
@Service("logService")
public class LogServiceImpl implements LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Resource
    private LogDao logDao;

    @Override
    public MessageResult insertLog(Log log) {
        MessageResult result = new MessageResult();
        try {
            logDao.insertLog(log);
        } catch (Exception e) {
            logger.error("insert a log has error" + e.getMessage());
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"插入日志出错：" + e.getMessage());
        }
        return result;
    }
}
