package cn.wzl.sbc.chatboard.dao.bean.impl;

import cn.wzl.sbc.chatboard.dao.bean.CommentDao;
import cn.wzl.sbc.chatboard.dao.mapper.CommentMapper;
import cn.wzl.sbc.model.chatboard.Comment;
import cn.wzl.sbc.model.chatboard.page.CommentPageBean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/20 12:04
 * @doc CommentDaoImpl
 **/
@Repository
public class CommentDaoImpl implements CommentDao {
    @Resource
    private CommentMapper mapper;

    @Override
    public List<Comment> listCommentByPage(CommentPageBean commentPageBean) {
        List<Comment> list = mapper.listCommentByPage(commentPageBean);
        return list;
    }

    @Override
    public int getCountByPage(CommentPageBean commentPageBean) {
        int count = mapper.getCountByPage(commentPageBean);
        return count;
    }

    @Override
    public int insertComment(Comment comment) {
        int count = mapper.insertComment(comment);
        return count;
    }

    @Override
    public List<Comment> listCommentByCondition(Comment comment) {
        List<Comment> comments= mapper.listCommentByCondition(comment);
        return comments;
    }
}
