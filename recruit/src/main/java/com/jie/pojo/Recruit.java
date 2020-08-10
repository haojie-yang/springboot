package com.jie.pojo;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;
/** 
 * @team mackie Studio 
 * @Author 杰 
 * @Date 2020-08-10 16:13:04 
 */
@Entity
@Table ( name ="tb_recruit" )
@Data
public class Recruit  implements Serializable {

	private static final long serialVersionUID =  482672936953188629L;

	/**
	 * ID
	 */
	@Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
	private String id;

	/**
	 * 职位名称
	 */
   	@Column(name = "jobname" )
	private String jobname;

	/**
	 * 薪资范围
	 */
   	@Column(name = "salary" )
	private String salary;

	/**
	 * 经验要求
	 */
   	@Column(name = "condition" )
	private String condition;

	/**
	 * 学历要求
	 */
   	@Column(name = "education" )
	private String education;

	/**
	 * 任职方式
	 */
   	@Column(name = "type" )
	private String type;

	/**
	 * 办公地址
	 */
   	@Column(name = "address" )
	private String address;

	/**
	 * 企业ID
	 */
   	@Column(name = "eid" )
	private String eid;

	/**
	 * 创建日期
	 */
   	@Column(name = "createtime" )
	private Date createtime;

	/**
	 * 状态
	 */
   	@Column(name = "state" )
	private String state;

	/**
	 * 网址
	 */
   	@Column(name = "url" )
	private String url;

	/**
	 * 标签
	 */
   	@Column(name = "label" )
	private String label;

	/**
	 * 职位描述
	 */
   	@Column(name = "content1" )
	private String content1;

	/**
	 * 职位要求
	 */
   	@Column(name = "content2" )
	private String content2;

}
