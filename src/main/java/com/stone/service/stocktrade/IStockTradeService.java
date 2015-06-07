package com.stone.service.stocktrade;

import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;

/**
 * 股票交易服务
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockTradeService {

	/**
	 * 查询股票交易信息列表
	 * 
	 * @return 股票交易信息列表
	 */
	public List<StockTradeInfoEntry> queryStockTradeList();

	/**
	 * 添加股票交易信息
	 * 
	 * @param 股票交易信息
	 */
	public void addStockTradeInfo(StockTradeInfoEntry stockTradeInfo);

	/**
	 * 批量添加股票交易信息
	 * 
	 * @param stockTradeInfoList
	 */
	public void addStockTradeInfoBatch(
			List<StockTradeInfoEntry> stockTradeInfoList);

	/**
	 * 删除股票交易信息
	 * 
	 * @param code
	 * @return 是否删除成功
	 */
	public boolean deleteStockTradeInfoByCode(String code);
}
