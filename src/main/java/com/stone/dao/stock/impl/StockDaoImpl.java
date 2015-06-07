package com.stone.dao.stock.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stone.dao.stock.IStockDao;
import com.stone.entry.stocktrade.StockEntry;
import com.stone.util.DBUtil;

/**
 * 股票基本信息数据层操作实现类
 * 
 * @author matrix
 * 
 */
public class StockDaoImpl implements IStockDao {

	public StockEntry selectStockEntryByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StockEntry> selectStockEntryList() {
		List<StockEntry> stockList = new ArrayList<StockEntry>();
		Connection conn = new DBUtil().getConn();
		try {
			Statement st = conn.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("select code,name,exchange_center,type from matrix.stock_basic_info");
			ResultSet rs = st.executeQuery(sb.toString());
			while (rs.next()) {
				StockEntry stock = new StockEntry();
				stock.setCode(rs.getString("code"));
				stock.setName(rs.getString("name"));
				stock.setExchangeCenter(rs.getString("exchange_center"));
				stock.setType("type");
				stockList.add(stock);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stockList;
	}

	public void insertStockEntry(StockEntry stock) {
		// TODO Auto-generated method stub

	}

	public boolean deleteStockEntryByCode(String code) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateStockEntry(StockEntry stockEntry) {
		// TODO Auto-generated method stub
		return false;
	}

}
