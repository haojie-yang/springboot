package com.jie.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 15:54
 */
@Data
public class UserParam implements Serializable {
    private String id;//主键

    private String status;//逻辑删除

    private String userName;//用户姓名

    private String account;//账号

    private String password;//密码

    private String state;//状态

    private Long iphone;//使用数量

    private String sex;//性别


}
