package cn.wzl.sbc.prod.service.article;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.file.File;
import cn.wzl.sbc.prod.model.file.page.FilePage;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wzl
 * @date Created in 2019/5/2 16:51
 */
public interface FileService {

    /**
     *  查询文件分页
     * @param filePage
     * @return
     */
    PageBeanResult queryFile(FilePage filePage);

    /**
     *  插入文件
     * @param file
     * @return
     */
    MessageResult insertFile(File file);

    /**
     *  更新文件
     * @param file
     * @return
     */
    MessageResult updateFile(File file);

    /**
     *  删除文件
     * @param file
     * @return
     */
    MessageResult deleteFile(File file);

}
