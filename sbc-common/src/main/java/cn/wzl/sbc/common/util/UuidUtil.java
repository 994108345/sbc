package cn.wzl.sbc.common.util;

import java.util.UUID;

/**
 * Created by 99410 on 2018/12/23.
 */
public class UuidUtil {


    /**
     * 获取uuid带杠杠(36位)
     * @return
     */
    public static String getUuid(){
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return uuidStr;
    }

    /**
     * 获取uuid不带横线（32位）
     * @return
     */
    public static String getUuidNoLine(){
        String  uuidStr = getUuid();
        String resultUuid = uuidStr.replaceAll("-","");
        return resultUuid;
    }
}
