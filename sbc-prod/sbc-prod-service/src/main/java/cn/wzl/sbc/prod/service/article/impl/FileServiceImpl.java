package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.util.OssUtil;
import cn.wzl.sbc.prod.dao.mapper.FileMapper;
import cn.wzl.sbc.prod.model.file.File;
import cn.wzl.sbc.prod.model.file.page.FilePage;
import cn.wzl.sbc.prod.service.article.FileService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * @author wzl
 * @date Created in 2019/5/2 16:51
 */
@Service
public class FileServiceImpl implements FileService {

    private final static Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Resource
    private FileMapper fileMapper;

    @Override
    public PageBeanResult queryFile(FilePage filePage) {
        PageBeanResult result = new PageBeanResult();
        try {
            //设置用户名
            filePage.setUserName(filePage.getUsrInfoUserName());
            List<File> files = fileMapper.queryFileByRequest(filePage);
            if(CollectionUtils.isEmpty(files)){
                result.setTotalRecords(0);
            }else{
                int count = fileMapper.queryFileCountByRequest(filePage);
                result.setTotalRecords(count);
            }
            result.setData(files);
        } catch (Exception e) {
            log.error("FileServiceImpl queryFile has error...",e);
            result.setErrorMessage("查询文件出现异常");
        }
        return result;
    }

    @Override
    public MessageResult insertFile(File file) {
        MessageResult result = new MessageResult();
        try {
            int count = fileMapper.insertFile(file);
        } catch (Exception e) {
            log.error("FileServiceImpl insertFile has error...",e);
            result.setErrorMessage("查询文件出现异常");
        }
        return result;
    }

    @Override
    public MessageResult updateFile(File file) {
        MessageResult result = new MessageResult();
        try {
            int count = fileMapper.updateFileByData(file);
        } catch (Exception e) {
            log.error("FileServiceImpl updateFile has error...",e);
            result.setErrorMessage("查询文件出现异常");
        }
        return result;
    }

    @Override
    public MessageResult deleteFile(File file) {
        MessageResult result = new MessageResult();
        try {
            if(StringUtils.isNotBlank(file.getFileCode()) || StringUtils.isNotBlank(file.getUserName())){
                int count = fileMapper.deleteFileByRequest(file);
            }else{
                throw new Exception("删除参数不能全为空," + JSONObject.toJSONString(file));
            }
        } catch (Exception e) {
            log.error("FileServiceImpl deleteFile has error...",e);
            result.setErrorMessage("查询文件出现异常");
        }
        return result;
    }

}
