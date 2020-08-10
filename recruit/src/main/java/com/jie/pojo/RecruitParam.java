package com.jie.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @team mackie Studio 
 * @Author 杰 
 * @Date 2020-08-10 16:13:04 
 */
@Data
public class RecruitParam implements Serializable {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 职位名称
	 */
	private String jobname;

	/**
	 * 薪资范围
	 */
	private String salary;

	/**
	 * 经验要求
	 */
	private String condition;

	/**
	 * 学历要求
	 */
	private String education;

	/**
	 * 任职方式
	 */
	private String type;

	/**
	 * 办公地址
	 */
	private String address;

	/**
	 * 企业ID
	 */
	private String eid;

	/**
	 * 创建日期
	 */
	private Date createtime;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 网址
	 */
	private String url;

	/**
	 * 标签
	 */
	private String label;

	/**
	 * 职位描述
	 */
	private String content1;

	/**
	 * 职位要求
	 */
	private String content2;

	/**
	 * 页数
	 */
	private Integer page;

	/**
	 * 页码
	 */
	private Integer size;

}
