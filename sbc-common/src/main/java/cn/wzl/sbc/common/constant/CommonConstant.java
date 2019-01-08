package cn.wzl.sbc.common.constant;

/**常量类
 * Created by 99410 on 2018/12/23.
 */
public class CommonConstant {
    /**
     * cookie的常量
     */
    public static class CookieConstant{
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
     * session常量
     */
    public static class SessionConstant{
        /**
         * token 的 name
         */
        public static final String TOKEN = "token";

        /**
         * 用户信息的name
         */
        public static final String USERNAME = "userName";
    }
}
