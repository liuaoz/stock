package com.stone.service.net;

import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;

/**
 * 股票交易网络数据操作服务
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockTradeNetDataService {

	/**
	 * 根据一只股票代码从网上获取股票交易数据
	 * 
	 * @param code
	 *            股票代码(注意，是8位的。如sz000753表示“漳州发展”的股票代码)
	 * @return 股票交易数据
	 */
	public StockTradeInfoEntry getStockTradeInfoByCode(String code);

	/**
	 * 根据股票代码列表从网上获取股票交易数据
	 * 
	 * @param codeList
	 *            股票代码列表(股票代码是8位)
	 * @return 股票交易列表数据
	 */
	public List<StockTradeInfoEntry> getStockTradeInfoListByCodeList(
			List<String> codeList);

}
