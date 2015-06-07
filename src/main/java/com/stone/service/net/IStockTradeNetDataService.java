package com.stone.service.net;

import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;

/**
 * ��Ʊ�����������ݲ�������
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockTradeNetDataService {

	/**
	 * ����һֻ��Ʊ��������ϻ�ȡ��Ʊ��������
	 * 
	 * @param code
	 *            ��Ʊ����(ע�⣬��8λ�ġ���sz000753��ʾ�����ݷ�չ���Ĺ�Ʊ����)
	 * @return ��Ʊ��������
	 */
	public StockTradeInfoEntry getStockTradeInfoByCode(String code);

	/**
	 * ���ݹ�Ʊ�����б�����ϻ�ȡ��Ʊ��������
	 * 
	 * @param codeList
	 *            ��Ʊ�����б�(��Ʊ������8λ)
	 * @return ��Ʊ�����б�����
	 */
	public List<StockTradeInfoEntry> getStockTradeInfoListByCodeList(
			List<String> codeList);

}
