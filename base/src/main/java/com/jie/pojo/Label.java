package com.jie.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 15:54
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id",columnDefinition = "VARCHAR(255) COMMENT '主键'")
    private String id;//主键

    @Column(name = "status",columnDefinition = "int(255) COMMENT '逻辑删除;0 --> 已删除; 1 --> 未删除;'")
    private String status;//逻辑删除

    @Column(name = "label_name",columnDefinition = "VARCHAR(255) COMMENT '标签名称'")
    private String labelName;//标签名称

    @Column(name = "state",columnDefinition = "VARCHAR(255) COMMENT '状态'")
    private String state;//状态

    @Column(name = "count",columnDefinition = "int(255) COMMENT '使用数量'")
    private Long count;//使用数量

    @Column(name = "fans",columnDefinition = "int(255) COMMENT '关注数'")
    private Long fans;//关注数

    @Column(name = "recommend",columnDefinition = "VARCHAR(255) COMMENT '是否推荐'")
    private String recommend;//是否推荐


}
