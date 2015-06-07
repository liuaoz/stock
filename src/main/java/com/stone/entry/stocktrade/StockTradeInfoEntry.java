package com.stone.entry.stocktrade;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * ��Ʊ����ʵ����
 * 
 * @author matrix
 * @since 2015-05-14
 */
public class StockTradeInfoEntry {

	/**
	 * ������
	 */
	private String ymd;
	/**
	 * ��Ʊ����
	 */
	private String code;
	/**
	 * ��Ʊ����
	 */
	private String name;
	/**
	 * ��
	 */
	private Double todayOpenPrice;
	/**
	 * ����
	 */
	private Double yestdayClosePrice;
	/**
	 * ����
	 */
	private Double todayClosePrice;
	/**
	 * ��߼�
	 */
	private Double topPrice;
	/**
	 * ��ͼ�
	 */
	private Double bottomPrice;
	/**
	 * �����
	 */
	private Double buyPrice;
	/**
	 * ������
	 */
	private Double salePrice;
	/**
	 * �ɽ���
	 */
	private Long tradeNum;
	/**
	 * �ɽ���
	 */
	private Double tradeAmount;
	/**
	 * ��һ��
	 */
	private Long buyFirstNum;
	/**
	 * ��һ����
	 */
	private Double buyFirstPrice;
	/**
	 * �����
	 */
	private Long buySecondNum;
	/**
	 * �������
	 */
	private Double buySecondPrice;
	/**
	 * ������
	 */
	private Long buyThirdNum;
	/**
	 * ��������
	 */
	private Double buyThirdPrice;
	/**
	 * ������
	 */
	private Long buyFourNum;
	/**
	 * ���ı���
	 */
	private Double buyFourPrice;
	/**
	 * ������
	 */
	private Long buyFiveNum;
	/**
	 * ���屨��
	 */
	private Double buyFivePrice;
	/**
	 * ��һ��
	 */
	private Long saleFirstNum;
	/**
	 * ��һ����
	 */
	private Double saleFirstPrice;
	/**
	 * ������
	 */
	private Long saleSecondNum;
	/**
	 * ��������
	 */
	private Double saleSecondPrice;
	/**
	 * ������
	 */
	private Long saleThirdNum;
	/**
	 * ��������
	 */
	private Double saleThirdPrice;
	/**
	 * ������
	 */
	private Long saleFourNum;
	/**
	 * ���ı���
	 */
	private Double saleFourPrice;
	/**
	 * ������
	 */
	private Long saleFiveNum;
	/**
	 * ���屨��
	 */
	private Double saleFivePrice;
	/**
	 * ����
	 */
	private Date date;

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
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

	public Double getTodayOpenPrice() {
		return todayOpenPrice;
	}

	public void setTodayOpenPrice(Double todayOpenPrice) {
		this.todayOpenPrice = todayOpenPrice;
	}

	public Double getYestdayClosePrice() {
		return yestdayClosePrice;
	}

	public void setYestdayClosePrice(Double yestdayClosePrice) {
		this.yestdayClosePrice = yestdayClosePrice;
	}

	public Double getTodayClosePrice() {
		return todayClosePrice;
	}

	public void setTodayClosePrice(Double todayClosePrice) {
		this.todayClosePrice = todayClosePrice;
	}

	public Double getTopPrice() {
		return topPrice;
	}

	public void setTopPrice(Double topPrice) {
		this.topPrice = topPrice;
	}

	public Double getBottomPrice() {
		return bottomPrice;
	}

	public void setBottomPrice(Double bottomPrice) {
		this.bottomPrice = bottomPrice;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Long getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(Long tradeNum) {
		this.tradeNum = tradeNum;
	}

	public Double getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(Double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public Long getBuyFirstNum() {
		return buyFirstNum;
	}

	public void setBuyFirstNum(Long buyFirstNum) {
		this.buyFirstNum = buyFirstNum;
	}

	public Double getBuyFirstPrice() {
		return buyFirstPrice;
	}

	public void setBuyFirstPrice(Double buyFirstPrice) {
		this.buyFirstPrice = buyFirstPrice;
	}

	public Long getBuySecondNum() {
		return buySecondNum;
	}

	public void setBuySecondNum(Long buySecondNum) {
		this.buySecondNum = buySecondNum;
	}

	public Double getBuySecondPrice() {
		return buySecondPrice;
	}

	public void setBuySecondPrice(Double buySecondPrice) {
		this.buySecondPrice = buySecondPrice;
	}

	public Long getBuyThirdNum() {
		return buyThirdNum;
	}

	public void setBuyThirdNum(Long buyThirdNum) {
		this.buyThirdNum = buyThirdNum;
	}

	public Double getBuyThirdPrice() {
		return buyThirdPrice;
	}

	public void setBuyThirdPrice(Double buyThirdPrice) {
		this.buyThirdPrice = buyThirdPrice;
	}

	public Long getBuyFourNum() {
		return buyFourNum;
	}

	public void setBuyFourNum(Long buyFourNum) {
		this.buyFourNum = buyFourNum;
	}

	public Double getBuyFourPrice() {
		return buyFourPrice;
	}

	public void setBuyFourPrice(Double buyFourPrice) {
		this.buyFourPrice = buyFourPrice;
	}

	public Long getBuyFiveNum() {
		return buyFiveNum;
	}

	public void setBuyFiveNum(Long buyFiveNum) {
		this.buyFiveNum = buyFiveNum;
	}

	public Double getBuyFivePrice() {
		return buyFivePrice;
	}

	public void setBuyFivePrice(Double buyFivePrice) {
		this.buyFivePrice = buyFivePrice;
	}

	public Long getSaleFirstNum() {
		return saleFirstNum;
	}

	public void setSaleFirstNum(Long saleFirstNum) {
		this.saleFirstNum = saleFirstNum;
	}

	public Double getSaleFirstPrice() {
		return saleFirstPrice;
	}

	public void setSaleFirstPrice(Double saleFirstPrice) {
		this.saleFirstPrice = saleFirstPrice;
	}

	public Long getSaleSecondNum() {
		return saleSecondNum;
	}

	public void setSaleSecondNum(Long saleSecondNum) {
		this.saleSecondNum = saleSecondNum;
	}

	public Double getSaleSecondPrice() {
		return saleSecondPrice;
	}

	public void setSaleSecondPrice(Double saleSecondPrice) {
		this.saleSecondPrice = saleSecondPrice;
	}

	public Long getSaleThirdNum() {
		return saleThirdNum;
	}

	public void setSaleThirdNum(Long saleThirdNum) {
		this.saleThirdNum = saleThirdNum;
	}

	public Double getSaleThirdPrice() {
		return saleThirdPrice;
	}

	public void setSaleThirdPrice(Double saleThirdPrice) {
		this.saleThirdPrice = saleThirdPrice;
	}

	public Long getSaleFourNum() {
		return saleFourNum;
	}

	public void setSaleFourNum(Long saleFourNum) {
		this.saleFourNum = saleFourNum;
	}

	public Double getSaleFourPrice() {
		return saleFourPrice;
	}

	public void setSaleFourPrice(Double saleFourPrice) {
		this.saleFourPrice = saleFourPrice;
	}

	public Long getSaleFiveNum() {
		return saleFiveNum;
	}

	public void setSaleFiveNum(Long saleFiveNum) {
		this.saleFiveNum = saleFiveNum;
	}

	public Double getSaleFivePrice() {
		return saleFivePrice;
	}

	public void setSaleFivePrice(Double saleFivePrice) {
		this.saleFivePrice = saleFivePrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTiem() {
		return tiem;
	}

	public void setTiem(Time tiem) {
		this.tiem = tiem;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

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

	/**
	 * ʱ��
	 */
	private Time tiem;
	/**
	 * ��ҵ
	 */
	private String industryType;
	/**
	 * ����ʱ��
	 */
	private Timestamp createTime;
	/**
	 * ����ʱ��
	 */
	private Timestamp updateTime;

	@Override
	public String toString() {
		return "��Ʊ���룺" + this.code + "��Ʊ���ƣ�" + this.name;
	}
}
