package cn.wzl.sbc.common.result;


import java.util.LinkedList;
import java.util.List;

/**
 * @author wxy
 * @date 2018/9/4
 */
public class CommonResult<T> {

    /**
     * 表示返回结果的状态（成功、延时等等）
     */
    private int status;

    /**
     * 表示当前操作的数量
     */
    private int count;

    /**
     * 表示操作的总数
     */
    private int totalCount;

    /**
     * 表示出现的异常
     */
    private Exception exception;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 返回页码数，在进行查询时，通过该参数可以让客户端知道该次的数据返回的是第几页的内容。
     */
    private int page;

    /**
     * 实际持有的对象列表
     */
    private List<T> values;

    /**
     * 一个对象
     */
    private Object value;

    /**
     * 构造一个新的Result实例,当前处于默认的未处理状态.
     */
    public CommonResult() {
        values = new LinkedList();
        this.message = ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE;
        this.status = ResultConstant.CODE.SUCCESS;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public void addValue(T newValue) {
        values.add(newValue);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "status=" + status +
                ", count=" + count +
                ", totalCount=" + totalCount +
                ", exception=" + exception +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", values=" + values +
                ", value=" + value +
                '}';
    }
}
