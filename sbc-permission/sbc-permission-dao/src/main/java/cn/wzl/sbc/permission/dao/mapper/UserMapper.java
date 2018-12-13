package cn.wzl.sbc.permission.dao.mapper;


import cn.wzl.sbc.model.permission.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertSelective(UserInfo userInfo);

    /**
     * 查询用户信息集合
     * @param userInfo
     * @return
     */
    List<UserInfo> listUserInfoByCondition(UserInfo userInfo);
}
