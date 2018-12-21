package cn.wzl.sbc.chatboard.dao.mapper;


import cn.wzl.sbc.model.chatboard.Comment;
import cn.wzl.sbc.model.chatboard.page.CommentPageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/20 12:05
 * @doc CommentMapper
 **/
@Mapper
public interface CommentMapper {
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
     * 按条件查询留言
     * @param comment
     * @return
     */
    List<Comment> listCommentByCondition(Comment comment);
}
