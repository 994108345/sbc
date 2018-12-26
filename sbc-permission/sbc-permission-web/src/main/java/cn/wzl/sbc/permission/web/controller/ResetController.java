package cn.wzl.sbc.permission.web.controller;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.model.permission.UserQuestion;
import cn.wzl.sbc.permission.service.reset.ResetService;
import cn.wzl.sbc.permission.web.controller.bean.ValidQuestionVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/25 19:37
 * @doc ResetController
 **/
@RestController
@RequestMapping("sbc-permission/Reset")
public class ResetController {
    @Resource
    private ResetService resetService;

    /**
     * 根据用户信息查询问题集合
     * @param userQuestion
     * @return
     */
    @PostMapping("queryQuestions")
    @ResponseBody
    public MessageResult queryQuestions(@RequestBody UserQuestion userQuestion){
        MessageResult result = resetService.getUserQuestion(userQuestion);
        List<UserQuestion> list =(List<UserQuestion>) result.getData();
        for (UserQuestion question : list) {
            /*清空问题答案*/
            question.setQuestionAnswer(null);
        }
        return result;
    }

    /**
     * 验证用户名是否存在
     * @param userInfo
     * @return
     */
    @PostMapping("validUserName")
    @ResponseBody
    public MessageResult validUserName(@RequestBody UserInfo userInfo){
        MessageResult result = resetService.validUserInfoExist(userInfo);
        return result;
    }

    /**
     * 修改密码是否存在
     * @param userInfo
     * @return
     */
    @PostMapping("modifyPassword")
    @ResponseBody
    public MessageResult modifyPassword(@RequestBody UserInfo userInfo){
        MessageResult result = resetService.modifyPassword(userInfo);
        return result;
    }

    /**
     * 验证问题集合对不对
     * @param validQuestionVO
     * @return
     */
    @PostMapping("validQuestion")
    @ResponseBody
    public MessageResult validQuestion(@RequestBody ValidQuestionVO validQuestionVO){
        MessageResult result = new MessageResult();
        if(validQuestionVO == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请求信息Param不能为null");
            return result;
        }
        List<UserQuestion> list = validQuestionVO.getUserQuestions();
        if(list == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请求信息List不能为null");
            return result;
        }
        if(list.size() < 1){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请求数据不完整");
            return result;
        }
        UserQuestion question = (UserQuestion) list.get(0);
        /*用户名*/
        String userName = question.getUserName();

        if(StringUtils.isBlank(userName)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户名不能为空");
            return result;
        }
        UserQuestion userQuestion = new UserQuestion();

        userQuestion.setUserName(userName);

        result = resetService.validQuestion(list,userQuestion);

        return result;
    }









}
