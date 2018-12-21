package cn.wzl.sbc.chatboard.service;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.model.chatboard.Comment;
import cn.wzl.sbc.model.chatboard.page.CommentPageBean;

/**
 * @Author wzl
 * @Date 2018/12/20 13:24
 * @doc CommentService
 **/
public interface CommentService {

    /**
     * 获取留言的记录
     * @param pageBean
     * @return
     */
    PageBeanResult getCommentPageInfo(CommentPageBean pageBean);

    /**
     * 插入一条留言记录
     * @param comment
     * @return
     */
    MessageResult insertComment(Comment comment);

    /**
     * 获取一条留言
     * @param comment
     * @return
     */
    MessageResult getComment(Comment comment);
}
