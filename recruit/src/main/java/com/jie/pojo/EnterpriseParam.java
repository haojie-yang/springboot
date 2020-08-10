package com.jie.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @team mackie Studio 
 * @Author 杰 
 * @Date 2020-08-10 16:13:04 
 */
@Data
public class EnterpriseParam implements Serializable {

	private static final long serialVersionUID =  2706316924456252836L;

	/**
	 * ID
	 */
	private String id;

	/**
	 * 企业名称
	 */
	private String name;

	/**
	 * 企业简介
	 */
	private String summary;

	/**
	 * 企业地址
	 */
	private String address;

	/**
	 * 标签列表
	 */
	private String labels;

	/**
	 * 坐标
	 */
	private String coordinate;

	/**
	 * 是否热门 0 --> 非热门; 1 --> 热门
	 */
	private String ishot;

	/**
	 * LOGO
	 */
	private String logo;

	/**
	 * 职位数
	 */
	private Long jobcount;

	/**
	 * URL
	 */
	private String url;

	/**
	 * 页数
	 */
	private Integer page;

	/**
	 * 页码
	 */
	private Integer size;

}
