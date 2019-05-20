package cn.wzl.sbc.prod.service.wagu.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.util.SHA1Util;
import cn.wzl.sbc.prod.model.auth.MtAuthModel;
import cn.wzl.sbc.prod.service.wagu.MtAuthService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wzl
 * @date Created in 2019/5/7 22:29
 */
@Service
public class MtAuthServiceImpl implements MtAuthService {

    private final static Logger log = LoggerFactory.getLogger(MtAuthServiceImpl.class);

    @Override
    public MessageResult getMtAuthUrl(MtAuthModel authModel) {
        MessageResult result = new MessageResult();
        if(StringUtils.isBlank(authModel.getDeveloperId())){
            result.setErrorMessage("developerId不能为空");
            return result;
        }
        if(StringUtils.isBlank(authModel.getBusinessId())){
            result.setErrorMessage("businessId不能为空");
            return result;
        }
        if(StringUtils.isBlank(authModel.getEPoiId())){
            result.setErrorMessage("ePoid不能为空");
            return result;
        }
        if(StringUtils.isBlank(authModel.getEPoiName())){
            result.setErrorMessage("ePoiName不能为空");
            return result;
        }
        if(StringUtils.isBlank(authModel.getMtSignKey())){
            result.setErrorMessage("signKey不能为空");
            return result;
        }
        Map<String,String> map = new HashMap<>(8);
        //授权token
        String timeStamp = String.valueOf(System.currentTimeMillis());
        map.put("developerId",authModel.getDeveloperId());
        //业务类型  1团购、2外卖、3闪惠、5支付、7预定、8全渠道会员
        map.put("businessId",authModel.getBusinessId());
        //门店id
        map.put("ePoiId",authModel.getEPoiId());
        //门店名称
        map.put("ePoiName",authModel.getEPoiName());
        map.put("timestamp",timeStamp);
        String sign  = getSignByMap(map,authModel.getMtSignKey());
        String url = "https://open-erp.meituan.com/storemap?developerId="+ authModel.getDeveloperId()+"&businessId="
                + authModel.getBusinessId() + "&ePoiId=" + authModel.getEPoiId() + "&ePoiName=" + authModel.getEPoiName()+ "&timestamp="
                + timeStamp + "&sign=" + sign;
        log.info("美团授权url："+ url);
        result.setData(url);
        return result;
    }

    @Override
    public MessageResult getMtNotAuthUrl(MtAuthModel authModel) {
        MessageResult result = new MessageResult();
        if(StringUtils.isBlank(authModel.getAuthToken())){
            result.setErrorMessage("authToken不能为空");
            return result;
        }
        if(StringUtils.isBlank(authModel.getBusinessId())){
            result.setErrorMessage("businessId不能为空");
            return result;
        }
        if(StringUtils.isBlank(authModel.getMtSignKey())){
            result.setErrorMessage("signKey不能为空");
            return result;
        }
        Map<String,String> map = new HashMap<>(8);
        //授权token
        String authToken = authModel.getAuthToken();
        //业务类型  1团购、2外卖、3闪惠、5支付、7预定、8全渠道会员
        String businessId = authModel.getBusinessId();
        //时间戳
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String mtSignKey = authModel.getMtSignKey();
        map.put("appAuthToken",authToken);
        map.put("businessId",businessId);
        map.put("timestamp",timeStamp);
        String sign = getSignByMap(map,mtSignKey);
        String url = "https://open-erp.meituan.com/releasebinding?sign="+sign+"&businessId="+businessId+"&appAuthToken="+authToken+"&timestamp="+timeStamp;
        log.info("美团解绑url：" + url);
        result.setData(url);
        return result;
    }

    /**
     * 通过map，获取签名
     * @param map 参数集合
     * @param appSecret 设备秘钥
     * @return 签名
     */
    public String getSignByMap(Map<String,String> map,String appSecret){
        Set<String> set = map.keySet();
        //排序
        StringBuilder strBuilder = new StringBuilder();
        set.stream().sorted().forEach(key -> {
            String value = map.get(key);
            strBuilder.append(key);
            strBuilder.append(value);
        });
        //添加设备秘钥
        String result = appSecret + strBuilder.toString();
        return SHA1Util.encode(result);
    }
}
