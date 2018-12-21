package cn.wzl.sbc.common.result;

/**
 * @Author wzl
 * @Date 2018/12/20 13:57
 * @doc PageBeanResult
 **/
public class PageBeanResult extends  MessageResult{

    /**
     * 总记录数
     */
    private int totalRecords;

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
