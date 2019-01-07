package entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>分页结果类</p>
 *
 * @author wanggengen
 * @version $ Id: PageResult.java, v 0.1 2019/1/7 23:15 wanggengen Exp $$
 **/
public class PageResult implements Serializable {

    /**
     * 总记录数
     */
    private long total;
    /**
     * 当前记录
     */
    private List rows;

    public PageResult() {
    }

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
