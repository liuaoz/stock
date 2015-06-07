package com.stone.entry.stocktrade;

import java.sql.Timestamp;

/**
 * ��Ʊ������Ϣʵ����
 * 
 * @author matrix
 * @since 2015-05-14
 */
public class StockEntry {
	/**
	 * ��Ʊ����
	 */
	private String code;
	/**
	 * ��Ʊ����
	 */
	private String name;
	/**
	 * �������ģ�������֤����֤����
	 */
	private String exchangeCenter;
	/**
	 * ��Ʊ���ͣ�����A�ɺ�B��
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
	 * ���м�
	 */
	private Double price;
	/**
	 * ��������
	 */
	private Long num;
	/**
	 * ����
	 */
	private String desc;

	/**
	 * ����ʱ��
	 */
	private Timestamp createTime;
	/**
	 * ����ʱ��
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
