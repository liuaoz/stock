package com.stone.dao.stocktrade;

import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;

/**
 * 股票数据dao操作
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockTradeDao {

	/**
	 * 查询股票交易信息列表
	 * 
	 * @return 股票交易信息列表
	 */
	public List<StockTradeInfoEntry> selectStockTradeInfoList();

	/**
	 * 根据股票代码和日期查询股票交易信息
	 * 
	 * @param code
	 *            股票代码
	 * @param date
	 *            日期
	 * @return 股票交易信息
	 */
	public StockTradeInfoEntry selectStockTradeInfoByCode(String code,
			String date);

	/**
	 * 新增股票交易信息
	 * 
	 * @param stockTradeInfo
	 *            股票交易信息
	 */
	public void insertStockTradeInfo(StockTradeInfoEntry stockTradeInfo);

	/**
	 * 批量插入股票交易信息
	 * 
	 * @param stockTradeInfoList
	 *            股票交易信息列表
	 */
	public void batchInsertStockTradeInfo(
			List<StockTradeInfoEntry> stockTradeInfoList);

	/**
	 * 根据股票信息删除股票
	 * 
	 * @param code
	 *            股票代码
	 * @return 是否删除成功
	 */
	public boolean deleteStockTradeInfoByCode(String code);

	/**
	 * 删除指定日期的所有股票交易信息
	 * 
	 * @param date
	 *            交易日期
	 * @return 是否删除成功
	 */
	public boolean deleteStockTradeInfoByDate(String date);

	/**
	 * 删除某只股票某天的交易信息
	 * 
	 * @param code
	 *            股票代码
	 * @param date
	 *            交易日期
	 * @return 是否删除成功
	 */
	public boolean delteStockTradeInfoByCodeAndDate(String code, String date);
}
