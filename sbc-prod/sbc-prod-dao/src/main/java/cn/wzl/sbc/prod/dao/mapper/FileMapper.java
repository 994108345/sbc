package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.file.File;
import cn.wzl.sbc.prod.model.file.page.FilePage;

import java.util.List;

public interface FileMapper {

    /**
     * 文件分页
     * @param filePage
     * @return
     */
    List<File> queryFileByRequest(FilePage filePage);

    /**
     * 插入
     * @param file
     * @return
     */
    int insertFile(File file);

    /**
     * 文件更新
     * @param file
     * @return
     */
    int updateFileByData(File file);

    /**
     * 删除文件名
     * @param file
     * @return
     */
    int deleteFileByRequest(File file);

    /**
     * 查询文件记录数
     * @param filePage
     * @return
     */
    int queryFileCountByRequest(FilePage filePage);
}