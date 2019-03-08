package cn.wzl.sbc.common.constant;

/**常量类
 * Created by 99410 on 2018/12/23.
 */
public  final class CommonConstant {
    /**
     * cookie的常量
     */
    public static final  class CookieConstant{
        /**
         * token 的 key
         */
        public static final String TOKEN = "token";
        public static final int LOGIN_OUT_TIME = 60*60*1;

        /**
         * userName的key
         */
        public static final String USERNAME = "userName";
        public static final int USERNAME_OUT_TIME = 60*60*1;
    }

    /**
     * request常量
     */
    public static final class RequestConstant{
        /**
         * 用户名
         */
        public static final String userName = "userName";
    }

    /**
     * session常量
     */
    public static final  class SessionConstant{
        /**
         * token 的 name
         */
        public static final String TOKEN = "token";

        /**
         * 用户信息的name
         */
        public static final String USERNAME = "userName";
    }

    public static final class CommonParam{
        /**
         * 登出（注销）方法名
         */
        public static final String LOGINOUT_METHOD_NAME = "loginOut";

        /**
         * 登录方法名
         */
        public static final String LOGIN_METHOD_NAME = "login";


        /**
         * 秒杀数量
         */
        public static final int SECKILL_COUNT = 10;
    }
}
