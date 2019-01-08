package cn.wzl.sbc.common.constant;

/**
 * @Author wzl
 * @Date 2018/12/27 18:54
 * @doc RedisConstant
 **/
public class RedisConstant {

    /*网站访问次数的自增量*/
    public static final Long WEBSITE_ACCESS_COUNT_ADD_NUM = 1L;

    /**
     * redis的key值
     */
    public static final class RedisKeys{
        public static final String WEBSITE_ACCESS_COUNT_KEY = "website_access_count";
    }

    /**
     * redis的超时时间
     */
    public static final class RedisOutTimes{
        /**
         * token的超时时间
         */
        public static final Long TOKEN_OUT_TIME = 1L;
    }
}
