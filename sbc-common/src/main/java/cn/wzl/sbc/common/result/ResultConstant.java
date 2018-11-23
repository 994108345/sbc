package cn.wzl.sbc.common.result;

/**
 * @Author user
 * @Date 2018/11/20 11:09
 **/
public class ResultConstant {
    public ResultConstant() {
    }

    public static final class MESSAGE {
        public static final String DEFAULT_SUCCESS_MESSAGE = "业务处理成功.";
        public static final String DEFAULT_ERROR_MESSAGE = "业务处理失败.";
        public static final String DEFAULT_NOT_FOUND_MESSAGE = "没有找到对应记录.";
        public static final String DEFAULT_MISS_PARAM_MESSAGE = "业务操作缺少参数.";
        public static final String DEFAULT_NOLONIN_MESSAGE = "用户未登陆,请先登录!";
        public static final String DEFAULT_SYSTEM_ERROR_MESSAGE = "系统无法处理当前操作.";
        public static final String DEFAULT_NOLONIN_MESSAGE_EN = "user is no login, please login...";
        public static final String DEFAULT_NOAUTH_MESSAGE_EN = "user is unauthorized...";

        public MESSAGE() {
        }
    }

    public static final class CODE {
        public static final int SUCCESS = 200;
        public static final int ERROR = 400;
        public static final int UNAUTH = 600;
        public static final int NOLOGIN = 800;

        public CODE() {
        }
    }
}
