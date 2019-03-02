package cn.wzl.sbc.common.result;

import cn.wzl.sbc.model.permission.UserInfo;

/**
 * @Author wzl
 * @Date 2018/12/13 19:18
 * @doc MessageResult
 **/
public class MessageResult {
    /**
     * 表示返回结果的状态（成功、延时等等）
     */
    private int status;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 一个对象
     */
    private Object data;

    /**
     * 用户信息
     */
    private UserInfo userInfo;


    /**
     * 无参构造函数,初始化为success
     */
    public MessageResult() {
        setMessageByResultEnum(ReturnResultEnum.SUCCESS);
    }

    /**
     * 设置状态和返回信息
     * @param status
     * @param message
     */
    public void setMessageAndStatus(int status,String message){
        this.status = status;
        this.message = message;
    }

    /**
     * 传进来一个枚举类，自动复制返回值和返回信息
     * @param resultEnum
     */
    public void setMessageByResultEnum(ReturnResultEnum resultEnum){
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 是否成功
     * @return
     */
    public boolean isSuccess(){
        if(this.status == ReturnResultEnum.SUCCESS.getStatus()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 是否失败
     * @return
     */
    public boolean isError(){
        if(this.status == ReturnResultEnum.ERROR.getStatus()){
            return true;
        }else{
            return false;
        }
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setErrorMessage(String errorMessage){
        this.message = errorMessage;
        this.status = ReturnResultEnum.ERROR.getStatus();
    }

}
