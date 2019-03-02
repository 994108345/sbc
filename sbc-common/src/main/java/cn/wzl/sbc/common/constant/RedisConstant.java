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
        /**
         * 网站访问次数
         */
        public static final String WEBSITE_ACCESS_COUNT_KEY = "website_access_count";

        /**
         * 秒杀list
         */
        public static final String SECKILL_KEY = "seckill_count";

        /**
         * 秒杀开关
         */
        public static final String SECKILL_SWITCH = "IS_SECKILL";

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

    /**
     * redis生成编码
     */
    public static final class RedisCreateCode{
        /**
         * redis生产编码的类型
         */
        public final class CodeType{
            public static final String BRAND_CODE = "brand";
        }
    }
}
