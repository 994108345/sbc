package cn.wzl.sbc.chatboard.service.impl;

import cn.wzl.sbc.chatboard.dao.bean.CommentDao;
import cn.wzl.sbc.chatboard.service.CommentService;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.chatboard.Comment;
import cn.wzl.sbc.model.chatboard.page.CommentPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/20 13:24
 * @doc CommentServiceImpl
 **/
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private final static Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Resource
    private CommentDao commentDao;

    @Override
    public PageBeanResult getCommentPageInfo(CommentPageBean pageBean) {
        PageBeanResult result = new PageBeanResult();
        try {
            List<Comment> commentList = commentDao.listCommentByPage(pageBean);
            if(commentList == null){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService getCommentPageInfo:查询结果为null");
                return result;
            }
            int count = commentDao.getCountByPage(pageBean);
            result.setData(commentList);
            result.setTotalRecords(count);
        } catch (Exception e) {
            log.error("查询记录出错：" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService getCommentPageInfo:查询记录出错：" + e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult insertComment(Comment comment) {
        MessageResult result = new MessageResult();
        try {
            int count = commentDao.insertComment(comment);
            if(count < 1){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService insertComment：插入记录数小于1");
            }
        } catch (Exception e) {
            log.error("插入记录出错：" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService insertComment:插入记录出错：" + e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult getComment(Comment param) {
        MessageResult result = new MessageResult();
        try {
            List<Comment> commentList = commentDao.listCommentByCondition(param);
            if(commentList == null){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService getComment:查询结果为null");
                return result;
            }
            if(commentList.size() == 0){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService getComment:未查到对应记录");
            }else{
                Comment comment = commentList.get(0);
                result.setData(comment);
            }
        } catch (Exception e) {
            log.error("查询记录出错：" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"CommentService getComment:查询记录出错：" + e.getMessage());
        }
        return result;
    }
}
