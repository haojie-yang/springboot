package com.jie.pojo;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
/** 
 * @team mackie Studio 
 * @Author 杰 
 * @Date 2020-08-10 16:13:04 
 */
@Entity
@Table ( name ="tb_enterprise" )
@Data
public class Enterprise  implements Serializable {

	private static final long serialVersionUID =  2706316924456252836L;

	/**
	 * ID
	 */
	@Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
	private String id;

	/**
	 * 企业名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 企业简介
	 */
   	@Column(name = "summary" )
	private String summary;

	/**
	 * 企业地址
	 */
   	@Column(name = "address" )
	private String address;

	/**
	 * 标签列表
	 */
   	@Column(name = "labels" )
	private String labels;

	/**
	 * 坐标
	 */
   	@Column(name = "coordinate" )
	private String coordinate;

	/**
	 * 是否热门 0 --> 非热门; 1 --> 热门
	 */
   	@Column(name = "ishot" )
	private String ishot;

	/**
	 * LOGO
	 */
   	@Column(name = "logo" )
	private String logo;

	/**
	 * 职位数
	 */
   	@Column(name = "jobcount" )
	private Long jobcount;

	/**
	 * URL
	 */
   	@Column(name = "url" )
	private String url;

}
