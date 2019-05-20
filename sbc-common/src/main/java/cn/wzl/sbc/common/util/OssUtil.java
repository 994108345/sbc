package cn.wzl.sbc.common.util;

import cn.wzl.sbc.common.constant.OssConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/7 14:09
 * @description：oss工具类
 */
@Configuration
public class OssUtil {

    private static final Logger log = LoggerFactory.getLogger(OssUtil.class);

    /**
     * 上传oss文件
     * @param inputStream 文件流
     * @param objectName 文件名
     * @return
     */
    public static MessageResult uploadFile(InputStream inputStream,String objectName){
        MessageResult result = new MessageResult();
        String endpoint = OssConstant.endpoint;
        String accessKeyId = OssConstant.accessKeyId;
        String accessKeySecret = OssConstant.accessKeySecret;
        String bucketName = OssConstant.bucketName;
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);
            result.setData(putObjectResult.getETag());
        } catch (Exception e) {
            log.error("OssUtil uploadFile has error......" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"oss上传失败"+e.getMessage());
        }finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return result;
    }

    /**
     * 下载oss文件
     * @param objectName
     * @return
     */
    public static MessageResult downLoadFile(String objectName){
        MessageResult result = new MessageResult();
        String endpoint = OssConstant.endpoint;
        String accessKeyId = OssConstant.accessKeyId;
        String accessKeySecret = OssConstant.accessKeySecret;
        String bucketName = OssConstant.bucketName;
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try{
            StringBuilder stringBuilder = new StringBuilder("");
            // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
            // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
            InputStream content = ossObject.getObjectContent();
            if (content != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuilder.append(line);
                }
                // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
                content.close();
            }
            result.setData(stringBuilder);
        }catch (Exception e){
            log.error("OssUtil downLoadFile has error......" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"oss下载失败"+e.getMessage());
        }finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return result;
    }

    /**
     *
     * @param bucketName 分片名字
     * @param key 键值
     * @return
     */
    public static MessageResult getUrl(String bucketName,String key){
        MessageResult result = new MessageResult();
        OSSClient ossClient = createOssClient();
        // 设置URL过期时间为10年3600l* 1000*24*365*10   
        Date expiration =new Date(System.currentTimeMillis() +3600L *1000 *24 *365 *10);
        // 生成URL   
        URL url =ossClient.generatePresignedUrl(bucketName, key, expiration);
        result.setData(url.toString());
        return  result;
    }

    /**
     * 创建oss实例
     * @return
     */
    public static OSSClient createOssClient(){
        String endpoint = OssConstant.endpoint;
        String accessKeyId = OssConstant.accessKeyId;
        String accessKeySecret = OssConstant.accessKeySecret;
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    /**
     * 拼接oss文件上传名
     * @param code:唯一编码
     * @param name：文件名称
     * @return
     */
    public static String generateOssName(String code,String name){
        //获取当前时间戳
        String time = String.valueOf(System.currentTimeMillis());
        String result = code+time+name;
        return result;
    }
}
