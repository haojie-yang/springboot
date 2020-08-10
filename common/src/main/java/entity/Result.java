package entity;

import lombok.Data;

/**
 * @description:
 * 返回结果
 * @author: yanghaojie 31648
 * @date: 2020/8/7 14:16
 */
@Data
public class Result {
    private boolean flag;//是否成功

    private Integer code;//返回码

    private String message;//返回说明

    private Object data;//返回数据

    public Result() {
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
