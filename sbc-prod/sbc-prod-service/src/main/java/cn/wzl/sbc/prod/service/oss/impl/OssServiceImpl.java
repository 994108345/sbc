package cn.wzl.sbc.prod.service.oss.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.model.permission.UserMessage;
import cn.wzl.sbc.prod.service.oss.OssService;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;



/**
 * @author wzl
 * @date Created in 2019/5/5 21:14
 */
@Service
public class OssServiceImpl implements OssService {

    private final static Logger log = LoggerFactory.getLogger(OssServiceImpl.class);

    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    @Override
    public MessageResult getSTSUrl(UserMessage userMessage) {
        MessageResult result = new MessageResult();
        String objectName = "getUrl";
        OSSClient ossClient = null;
        try {
            // 创建OSSClient实例。
            ossClient  = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 生成签名URL。
            Date expiration = DateUtil.parseRfc822Date("Thu, 19 Mar 2030 18:00:00 GMT");
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.PUT);
            // 设置过期时间。
            request.setExpiration(expiration);
            // 设置Content-Type。
            request.setContentType("application/octet-stream");
            // 添加用户自定义元信息。
            request.addUserMetadata("author", userMessage.getUsrInfoUserName());
            // 生成签名URL（HTTP PUT请求）。
            URL signedUrl = ossClient.generatePresignedUrl(request);
            result.setData(signedUrl);
        } catch (ParseException e) {
            log.info("oss获取上传url出现异常");
            e.printStackTrace();
        }finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return result;
    }
}
