package cn.wzl.sbc.prod.model.auth;

import lombok.Data;

/**
 * @author wzl
 * @date Created in 2019/5/7 22:31
 */
@Data
public class MtAuthModel {

    private String developerId;

    private String businessId;

    private String ePoiId;

    private String ePoiName;

    private String mtSignKey;

    private String authToken;

}
