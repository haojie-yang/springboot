package entity;

/**
 * @description:
 * 状态码定义
 * @author: yanghaojie 31648
 * @date: 2020/8/7 14:26
 */
public class StatusCode {
    public static final int OK = 20000;//成功
    public static final int ERROR = 20001;//失败
    public static final int LOGINERROR = 20002;//用户名或者密码错误
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int REMOTRERROR = 20004;//远程调用失败
    public static final int REPERROR = 20005;//重复操作
}
