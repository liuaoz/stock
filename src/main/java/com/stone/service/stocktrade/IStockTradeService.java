package com.stone.service.stocktrade;

import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;

/**
 * ��Ʊ���׷���
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockTradeService {

	/**
	 * ��ѯ��Ʊ������Ϣ�б�
	 * 
	 * @return ��Ʊ������Ϣ�б�
	 */
	public List<StockTradeInfoEntry> queryStockTradeList();

	/**
	 * ��ӹ�Ʊ������Ϣ
	 * 
	 * @param ��Ʊ������Ϣ
	 */
	public void addStockTradeInfo(StockTradeInfoEntry stockTradeInfo);

	/**
	 * ������ӹ�Ʊ������Ϣ
	 * 
	 * @param stockTradeInfoList
	 */
	public void addStockTradeInfoBatch(
			List<StockTradeInfoEntry> stockTradeInfoList);

	/**
	 * ɾ����Ʊ������Ϣ
	 * 
	 * @param code
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStockTradeInfoByCode(String code);
}
