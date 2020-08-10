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
@Entity
@Table(name = "tb_user")
@Data
public class User implements Serializable {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id",columnDefinition = "VARCHAR(255) COMMENT '主键'")
    private String id;//主键

    @Column(name = "status",columnDefinition = "int(255) COMMENT '逻辑删除;0 --> 已删除; 1 --> 未删除;'")
    private String status;//逻辑删除

    @Column(name = "user_name",columnDefinition = "VARCHAR(255) COMMENT '用户姓名'")
    private String userName;//用户姓名

    @Column(name = "account",columnDefinition = "VARCHAR(255) COMMENT '账号'")
    private String account;//账号

    @Column(name = "password",columnDefinition = "VARCHAR(255) COMMENT '密码'")
    private String password;//密码

    @Column(name = "state",columnDefinition = "VARCHAR(255) COMMENT '状态'")
    private String state;//状态

    @Column(name = "iphone",columnDefinition = "int(255) COMMENT '手机号码'")
    private Long iphone;//使用数量

    @Column(name = "sex",columnDefinition = "VARCHAR(255) COMMENT '性别'")
    private String sex;//性别


}
