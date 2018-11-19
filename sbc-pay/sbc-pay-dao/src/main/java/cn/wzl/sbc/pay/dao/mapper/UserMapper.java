package cn.wzl.sbc.pay.dao.mapper;

import cn.wzl.sbc.pay.module.UserInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    int insertSelective(UserInfo userInfo);
}
