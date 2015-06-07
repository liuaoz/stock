package com.stone.dao.stock;

import java.util.List;

import com.stone.entry.stocktrade.StockEntry;

/**
 * 股票基本信息数据层操作接口
 * 
 * @author matrix
 * @since 2015-05-14
 */
public interface IStockDao {

	/**
	 * 根据股票代码查询股票信息
	 * 
	 * @param code
	 *            股票代码
	 * @return 股票信息
	 */
	public StockEntry selectStockEntryByCode(String code);

	/**
	 * 查询所有股票信息
	 * 
	 * @return 所有股票信息
	 */
	public List<StockEntry> selectStockEntryList();

	/**
	 * 新增股票基本信息
	 * 
	 * @param stock
	 *            股票信息
	 */
	public void insertStockEntry(StockEntry stock);

	/**
	 * 根据股票代码删除股票
	 * 
	 * @param code
	 *            股票代码
	 * @return 是否删除成功
	 */
	public boolean deleteStockEntryByCode(String code);

	/**
	 * 更新股票信息
	 * 
	 * @param stockEntry
	 *            股票信息
	 * @return 是否更新成功
	 */
	public boolean updateStockEntry(StockEntry stockEntry);

}
