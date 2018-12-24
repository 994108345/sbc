package cn.wzl.sbc.permission.dao.bean.impl;

import cn.wzl.sbc.model.permission.UserQuestion;
import cn.wzl.sbc.permission.dao.bean.UserQuestionDao;
import cn.wzl.sbc.permission.dao.mapper.UserQuestionMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/24 15:46
 * @doc UserQuestionDaoImpl
 **/
@Repository
public class UserQuestionDaoImpl implements UserQuestionDao {

    @Resource
    private UserQuestionMapper mapper;
    @Override
    public List<UserQuestion> queryByCondition(UserQuestion userQuestion) {
        List<UserQuestion> list = mapper.queryByCondition(userQuestion);
        return list;
    }

    @Override
    public int insertByBatch(List<UserQuestion> list) throws Exception {
        int count = mapper.insertByBatch(list);
        if(count < 1){
            throw new Exception("插入用户问题记录数小于1");
        }
        return count;
    }
}
