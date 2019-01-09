package cn.wzl.sbc.permission.dao.bean.impl;

import cn.wzl.sbc.permission.dao.bean.SystemParamDao;
import cn.wzl.sbc.permission.dao.mapper.SystemParamMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2019/1/9 16:23
 * @doc SystemParamDaoImpl
 **/
@Repository
public class SystemParamDaoImpl implements SystemParamDao {

    @Resource
    private SystemParamMapper mapper;

    @Override
    public int updateSysparamOfSeckill() throws Exception {
        int count = mapper.updateSysparamOfSeckill();
        if(count < 1){
            throw new Exception("更新记录数小于1");
        }
        return count;
    }
}
