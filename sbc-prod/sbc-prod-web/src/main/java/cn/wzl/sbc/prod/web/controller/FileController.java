package cn.wzl.sbc.prod.web.controller;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.OssConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.util.CodeUtil;
import cn.wzl.sbc.common.util.OssUtil;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.prod.model.file.File;
import cn.wzl.sbc.prod.service.article.FileService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wzl
 * @date Created in 2019/5/20 13:54
 */
@RestController
@RequestMapping(value = "sbc-prod/File")
public class FileController {

    private Logger log = LoggerFactory.getLogger(FileController.class);

    @Resource
    private CodeUtil codeUtil;

    @Resource
    private FileService fileService;

    @RequestMapping(value = "webFile/pictureUpload")
    public MessageResult pictureUpload(@RequestParam(value = "file", required = false) List<MultipartFile> files,
                                       @RequestAttribute(value = CommonConstant.RequestConstant.USERINFO_STR) String userNameStr){
        MessageResult result = new MessageResult();
        if(CollectionUtils.isEmpty(files)){
            result.setErrorMessage("this file is null");
            return result;
        }
        //获取用户信息
        UserInfo userInfo = JSONObject.parseObject(userNameStr,UserInfo.class);
        try {
            for (MultipartFile file : files) {
                InputStream inputStream = file.getInputStream();
                //获取唯一编码
                String code = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.OSS_FILE_CODE);
                String name = OssUtil.generateOssName(code,file.getOriginalFilename());
                //上传文件
                result = OssUtil.uploadFile(inputStream,name);
                if(result.isError()){
                    return result;
                }
                //获取上传文件的文件的访问地址
                result = OssUtil.getUrl(OssConstant.bucketName,name);
                String url = (String)result.getData();
                //拼接file对象
                File saveFile = joinFile(userInfo,url,file.getOriginalFilename());
                //保存file
                result = fileService.insertFile(saveFile);
            }
        } catch (IOException e) {
            log.error("ProdWeb pictureUpload has error...");
            result.setErrorMessage("this file inputStream has a error...");
            return result;
        }
        return result;
    }

    /**
     * 拼接file对象
     * @param userInfo
     * @param url
     * @return
     */
    private File joinFile(UserInfo userInfo,String url,String fileName){
        //保存上传的文件
        File saveFile = new File();
        //用户名
        saveFile.setUserName(userInfo.getUserName());
        //文件名
        saveFile.setFileName(fileName);
        //文件url
        saveFile.setFileUrl(url);
        //文件编码
        saveFile.setFileCode(codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.OSS_FILE_CODE));
        //创建人
        saveFile.setCreateUser(userInfo.getUserName());
        //最后修改人
        saveFile.setLastModifiedUser(userInfo.getUserName());
        return saveFile;
    }

}
