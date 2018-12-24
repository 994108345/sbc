package cn.wzl.sbc.permission.dao.mapper;

import cn.wzl.sbc.model.permission.UserQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserQuestionMapper {

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
    int insertByBatch(List<UserQuestion> list);
}