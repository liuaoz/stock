package com.stone.entry.stocktrade;

import java.sql.Timestamp;

/**
 * 股票基本信息实体类
 * 
 * @author matrix
 * @since 2015-05-14
 */
public class StockEntry {
	/**
	 * 股票代码
	 */
	private String code;
	/**
	 * 股票名称
	 */
	private String name;
	/**
	 * 交易中心，包括上证和深证两种
	 */
	private String exchangeCenter;
	/**
	 * 股票类型，包括A股和B股
	 */
	private String type;

	public String getExchangeCenter() {
		return exchangeCenter;
	}

	public void setExchangeCenter(String exchangeCenter) {
		this.exchangeCenter = exchangeCenter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 发行价
	 */
	private Double price;
	/**
	 * 发行数量
	 */
	private Long num;
	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	/**
	 * 更新时间
	 */
	private Timestamp updateTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
