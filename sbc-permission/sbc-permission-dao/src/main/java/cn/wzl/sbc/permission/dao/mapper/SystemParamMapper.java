package cn.wzl.sbc.permission.dao.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemParamMapper {

    /**
     * 更新秒杀的货品
     * @return
     */
    int updateSysparamOfSeckill();

}