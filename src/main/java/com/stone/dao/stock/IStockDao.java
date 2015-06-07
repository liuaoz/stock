package com.stone.dao.stock;

import java.util.List;

import com.stone.entry.stocktrade.StockEntry;

/**
 * ��Ʊ������Ϣ���ݲ�����ӿ�
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockDao {

	/**
	 * ���ݹ�Ʊ�����ѯ��Ʊ��Ϣ
	 * 
	 * @param code
	 *            ��Ʊ����
	 * @return ��Ʊ��Ϣ
	 */
	public StockEntry selectStockEntryByCode(String code);

	/**
	 * ��ѯ���й�Ʊ��Ϣ
	 * 
	 * @return ���й�Ʊ��Ϣ
	 */
	public List<StockEntry> selectStockEntryList();

	/**
	 * ������Ʊ������Ϣ
	 * 
	 * @param stock
	 *            ��Ʊ��Ϣ
	 */
	public void insertStockEntry(StockEntry stock);

	/**
	 * ���ݹ�Ʊ����ɾ����Ʊ
	 * 
	 * @param code
	 *            ��Ʊ����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStockEntryByCode(String code);

	/**
	 * ���¹�Ʊ��Ϣ
	 * 
	 * @param stockEntry
	 *            ��Ʊ��Ϣ
	 * @return �Ƿ���³ɹ�
	 */
	public boolean updateStockEntry(StockEntry stockEntry);

}
