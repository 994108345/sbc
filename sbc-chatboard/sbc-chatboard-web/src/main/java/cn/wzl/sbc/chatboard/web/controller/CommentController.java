package cn.wzl.sbc.chatboard.web.controller;

import cn.wzl.sbc.chatboard.service.CommentService;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.model.chatboard.Comment;
import cn.wzl.sbc.model.chatboard.page.CommentPageBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2018/12/20 14:24
 * @doc CommentController
 **/
@RestController
@RequestMapping("sbc-chatboard/Comment")
public class CommentController {


    @Resource
    private CommentService commentService;

    /**
     * 查询分页数据
     * @param pageBean
     * @return
     */
    @PostMapping("pageInfo")
    @ResponseBody
    public PageBeanResult pageInfo(@RequestBody CommentPageBean pageBean){
        PageBeanResult result = commentService.getCommentPageInfo(pageBean);
        return result;
    }

    /**
     * 插入一条留言
     * @param comment
     * @return
     */
    @PostMapping("insertComment")
    @ResponseBody
    public MessageResult insertComment(@RequestBody Comment comment){
        MessageResult result = commentService.insertComment(comment);
        return  result;
    }

    /**
     * 获取一条留言
     * @param comment
     * @return
     */
    @PostMapping("getComment")
    @ResponseBody
    public MessageResult getComment(@RequestBody Comment comment){
        MessageResult result = commentService.getComment(comment);
        return  result;
    }
}
