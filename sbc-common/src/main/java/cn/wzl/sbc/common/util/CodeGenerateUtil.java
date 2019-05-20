package cn.wzl.sbc.common.util;

/** 代码生成器
 * @author wzl
 * @date Created in 2019/4/29 18:39
 */
public class CodeGenerateUtil {

    /**
     * 获得独有编码
     * @param field 字段
     * @return
     */
    public String getCode(String field){
        //当前时间
        String time = String.valueOf(System.currentTimeMillis());
        String code = time + field;
        return code;
    }
}
