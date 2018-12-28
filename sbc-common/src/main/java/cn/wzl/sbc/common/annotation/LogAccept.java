package cn.wzl.sbc.common.annotation;

import java.lang.annotation.*;

/**
 * @Author wzl
 * @Date 2018/12/28 11:33
 * @doc LogAccept
 **/

@Target(ElementType.METHOD) //注解放置的目标位置
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface LogAccept {

    /**
     * 模块名
     * @return
     */
    String modleName();

    /**
     * 动作行为
     * @return
     */
    String actionName();
}
