package cn.wzl.sbc.permission.dao.mapper;

import cn.wzl.sbc.model.permission.UserInfoDtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoDtlMapper {

    /**
     * 查询用户信息
     * @param userInfoDtl
     * @return
     */
    List<UserInfoDtl> queryUserInfos (UserInfoDtl userInfoDtl);

    /**
     * 更新
     * @param userInfoDtl
     * @return
     */
    int updateByCode(UserInfoDtl userInfoDtl);

    /**
     * 插入
     * @param userInfoDtl
     * @return
     */
    int insertByData(UserInfoDtl userInfoDtl);

    /**
     * 删除用户信息
     * @param userInfoDtl
     * @return
     */
    int deleteByRequest(UserInfoDtl userInfoDtl);


}