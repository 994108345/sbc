package cn.wzl.sbc.permission.service.reset;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.model.permission.UserQuestion;

import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/25 19:29
 * @doc ResetService
 **/
public interface ResetService {

    /**
     * 查询用户的问题
     * @param param
     * @return
     */
    MessageResult getUserQuestion(UserQuestion param);

    /**
     * 查询用户是否存在
     * @return
     */
    MessageResult validUserInfoExist(UserInfo usrInfo);

    /**
     * 修改密码
     * @param userInfo
     * @return
     */
    MessageResult modifyPassword(UserInfo userInfo);

    /**
     * 验证密保问题对不对
     * @param list
     * @return
     */
    MessageResult validQuestion(List<UserQuestion> list,UserQuestion userQuestion);

}
