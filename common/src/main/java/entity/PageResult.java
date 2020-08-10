package entity;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * 分页结果
 * @author: yanghaojie 31648
 * @date: 2020/8/7 14:22
 */
@Data
public class PageResult<T> {
    private long total;//总数量

    private List<T> rows;//数据

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
