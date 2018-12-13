package cn.wzl.sbc.common.result;

/**
 * @Author wzl
 * @Date 2018/12/13 19:14
 * @doc ReturnResultEnum
 **/
public enum ReturnResultEnum {
    /**
     * 错误
     */
    ERROR(-10000,"执行失败"),

    /**
     * 成功
     */
    SUCCESS(10000,"执行成功"),

    /**
     * 用户错误
     */
    LOGIN_ERROR(10001,"账号或密码错误");
    private int status;
    private String message;

    ReturnResultEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
