package cn.wzl.sbc.permission.dao.bean.impl;

import cn.wzl.sbc.model.permission.Log;
import cn.wzl.sbc.permission.dao.bean.LogDao;
import cn.wzl.sbc.permission.dao.mapper.LogMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/28 11:10
 * @doc LogDaoImpl
 **/
@Repository
public class LogDaoImpl implements LogDao {

    @Resource
    LogMapper logMapper;

    @Override
    public List<Log> listLogByCondition(Log log) throws Exception {
        List<Log> list = logMapper.listLogByCondition(log);
        if(list == null){
            throw new Exception("查询结果为null");
        }
        return list;
    }

    @Override
    public int insertLog(Log log) throws Exception {
        int count = logMapper.insertLog(log);
        if(count < 1){
            throw new Exception("插入记录数小于1");
        }
        return count;
    }
}
