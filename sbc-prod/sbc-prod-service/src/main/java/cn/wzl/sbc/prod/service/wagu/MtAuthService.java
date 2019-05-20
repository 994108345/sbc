package cn.wzl.sbc.prod.service.wagu;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.model.auth.MtAuthModel;

/**
 * @author wzl
 * @date Created in 2019/5/7 22:29
 */
public interface MtAuthService {

    /**
     * 获取美团授权url
     * @return
     */
    MessageResult getMtAuthUrl(MtAuthModel authModel);


    /**
     * 获取美团解绑url
     * @param authModel
     * @return
     */
    MessageResult getMtNotAuthUrl(MtAuthModel authModel);
}
