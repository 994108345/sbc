package cn.wzl.sbc.permission.dao.bean;

import cn.wzl.sbc.model.permission.UserQuestion;

import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/24 15:45
 * @doc UserQuestionDao
 **/
public interface UserQuestionDao {
    /**
     * 根据条件查询用户问题
     * @param userQuestion
     * @return
     */
    List<UserQuestion> queryByCondition(UserQuestion userQuestion);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertByBatch(List<UserQuestion> list) throws Exception;
}
