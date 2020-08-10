package com.jie.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 15:54
 */
@Data
public class LabelParam {
    private String id;//主键

    private String status;//逻辑删除

    private String labelName;//标签名称

    private String state;//状态

    private Long count;//使用数量

    private Long fans;//关注数

    private String recommend;//是否推荐

    private Integer page;//页数

    private Integer size;//页码大小

}
