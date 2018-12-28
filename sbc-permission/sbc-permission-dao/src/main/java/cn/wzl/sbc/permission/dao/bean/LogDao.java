package cn.wzl.sbc.permission.dao.bean;

import cn.wzl.sbc.model.permission.Log;

import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/28 11:10
 * @doc LogDao
 **/
public interface LogDao {

    /**
     * 查询日志
     * @param log
     * @return
     */
    List<Log> listLogByCondition(Log log) throws Exception;

    /**
     * 插入一条日志
     * @param log
     * @return
     */
    int insertLog(Log log) throws Exception;
}
