package cn.wzl.sbc.chatboard.dao.bean;

import cn.wzl.sbc.model.chatboard.Comment;
import cn.wzl.sbc.model.chatboard.page.CommentPageBean;

import java.util.List;

public interface CommentDao {
    /**
     * 查询留言板分页数据
     * @param commentPageBean
     * @return
     */
    List<Comment> listCommentByPage(CommentPageBean commentPageBean);

    /**
     * 获取总记录数
     * @param commentPageBean
     * @return
     */
    int getCountByPage(CommentPageBean commentPageBean);


    /**
     * 插入一条留言
     * @param comment
     * @return
     */
    int insertComment(Comment comment);

    /**
     * 根据条件查询留言
     * @return
     */
    List<Comment> listCommentByCondition(Comment comment);
}
