package com.stone.dao.stocktrade;

import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;

/**
 * ��Ʊ����dao����
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockTradeDao {

	/**
	 * ��ѯ��Ʊ������Ϣ�б�
	 * 
	 * @return ��Ʊ������Ϣ�б�
	 */
	public List<StockTradeInfoEntry> selectStockTradeInfoList();

	/**
	 * ���ݹ�Ʊ��������ڲ�ѯ��Ʊ������Ϣ
	 * 
	 * @param code
	 *            ��Ʊ����
	 * @param date
	 *            ����
	 * @return ��Ʊ������Ϣ
	 */
	public StockTradeInfoEntry selectStockTradeInfoByCode(String code,
			String date);

	/**
	 * ������Ʊ������Ϣ
	 * 
	 * @param stockTradeInfo
	 *            ��Ʊ������Ϣ
	 */
	public void insertStockTradeInfo(StockTradeInfoEntry stockTradeInfo);

	/**
	 * ���������Ʊ������Ϣ
	 * 
	 * @param stockTradeInfoList
	 *            ��Ʊ������Ϣ�б�
	 */
	public void batchInsertStockTradeInfo(
			List<StockTradeInfoEntry> stockTradeInfoList);

	/**
	 * ���ݹ�Ʊ��Ϣɾ����Ʊ
	 * 
	 * @param code
	 *            ��Ʊ����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStockTradeInfoByCode(String code);

	/**
	 * ɾ��ָ�����ڵ����й�Ʊ������Ϣ
	 * 
	 * @param date
	 *            ��������
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStockTradeInfoByDate(String date);

	/**
	 * ɾ��ĳֻ��Ʊĳ��Ľ�����Ϣ
	 * 
	 * @param code
	 *            ��Ʊ����
	 * @param date
	 *            ��������
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delteStockTradeInfoByCodeAndDate(String code, String date);
}
