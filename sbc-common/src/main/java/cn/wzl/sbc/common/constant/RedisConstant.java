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
            public static final String ARTICLETYPE_CODE = "articletype";
            public static final String ARTICLE_CODE = "article";
            //oss上传文件标识
            public static final String OSS_FILE_CODE = "ossFile";
            public static final String ARTICLE_COMMENT_CODE = "articleComment";
            public static final String ARTICLE_INFO_CODE = "articleInfo";
            //用户明细
            public static final String USER_INFO_DTL_CODE = "userInfoDtlCode";
            //文件管理
            public static final String FILE_CODE = "fileCode";
        }
    }
}
