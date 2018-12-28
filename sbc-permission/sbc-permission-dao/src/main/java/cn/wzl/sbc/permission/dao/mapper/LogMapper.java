package cn.wzl.sbc.permission.dao.mapper;


import cn.wzl.sbc.model.permission.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    /**
     * 查询日志
     * @param log
     * @return
     */
    List<Log> listLogByCondition(Log log);

    /**
     * 插入一条日志
     * @param log
     * @return
     */
    int insertLog(Log log);
}