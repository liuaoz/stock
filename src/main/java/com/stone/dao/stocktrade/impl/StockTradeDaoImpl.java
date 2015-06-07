package com.stone.dao.stocktrade.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stone.dao.stocktrade.IStockTradeDao;
import com.stone.entry.stocktrade.StockTradeInfoEntry;
import com.stone.util.DBUtil;

/**
 * 股票交易信息数据层操作实现类
 * 
 * @author matrix
 * @since 2015-05-14
 */
public class StockTradeDaoImpl implements IStockTradeDao {
	public static void main(String[] args) {

		new StockTradeDaoImpl().deleteStockTradeInfoByDate("20150514");
		// new StockTradeDaoImpl().selectStockTradeInfoList();

		// stockTradeInfoEntry.setYmd("20150514");
		// stockTradeInfoEntry.setCode("SZ600033");
		// stockTradeInfoEntry.setName("福建高速");
		// new StockTradeDaoImpl().insertStockTradeInfo(stockTradeInfoEntry);

	}

	public List<StockTradeInfoEntry> selectStockTradeInfoList() {
		List<StockTradeInfoEntry> stockTradeInfoEntries = new ArrayList<StockTradeInfoEntry>();
		try {
			Statement st = new DBUtil().getConn().createStatement();
			ResultSet rs = st
					.executeQuery("select ymd,code,name from matrix.stock_trade_info");

			while (rs.next()) {
				StockTradeInfoEntry stockTradeInfoEntry = new StockTradeInfoEntry();
				stockTradeInfoEntry.setYmd(rs.getString("ymd"));
				stockTradeInfoEntry.setCode(rs.getString("code"));
				stockTradeInfoEntry.setName(rs.getString("name"));
				stockTradeInfoEntries.add(stockTradeInfoEntry);
				System.out.println("=====");
			}
			for (int i = 0; i < stockTradeInfoEntries.size(); i++) {
				System.out.println("日期: "
						+ stockTradeInfoEntries.get(i).getYmd() + "股票代码: "
						+ stockTradeInfoEntries.get(i).getCode() + "股票名称: "
						+ stockTradeInfoEntries.get(i).getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockTradeInfoEntries;

	}

	public StockTradeInfoEntry selectStockTradeInfoByCode(String code,
			String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertStockTradeInfo(StockTradeInfoEntry stockTradeInfo) {
		if (null == stockTradeInfo) {
			return;
		}
		try {
			Statement st = new DBUtil().getConn().createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into matrix.stock_trade_info(ymd,code,name,today_Open_Price,yestday_close_price,today_Close_Price,top_Price,bottom_Price,buy_Price,sale_Price,trade_Num,trade_Amount"
					+ ",buy_First_Num,buy_First_Price,buy_Second_Num,buy_Second_Price,buy_Third_Num,buy_Third_Price,buy_Four_Num,buy_Four_Price,buy_Five_Num,buy_Five_Price,"
					+ "sale_First_Num,sale_First_Price,sale_Second_Num,sale_Second_Price,sale_Third_Num,sale_Third_Price,sale_Four_Num,sale_Four_Price,sale_Five_Num,sale_Five_Price) values("
					+ "'"
					+ stockTradeInfo.getYmd()
					+ "'"
					+ ","
					+ "'"
					+ stockTradeInfo.getCode()
					+ "'"
					+ ","
					+ "'"
					+ stockTradeInfo.getName()
					+ "'"
					+ ","
					+ stockTradeInfo.getTodayOpenPrice()
					+ ","
					+ stockTradeInfo.getYestdayClosePrice()
					+ ","
					+ stockTradeInfo.getTodayClosePrice()
					+ ","
					+ stockTradeInfo.getTopPrice()
					+ ","
					+ stockTradeInfo.getBottomPrice()
					+ ","
					+ stockTradeInfo.getBuyPrice()
					+ ","
					+ stockTradeInfo.getSalePrice()
					+ ","
					+ stockTradeInfo.getTradeNum()
					+ ","
					+ stockTradeInfo.getTradeAmount()
					+ ","
					+ stockTradeInfo.getBuyFirstNum()
					+ ","
					+ stockTradeInfo.getBuyFirstPrice()
					+ ","
					+ stockTradeInfo.getBuySecondNum()
					+ ","
					+ stockTradeInfo.getBuySecondPrice()
					+ ","
					+ stockTradeInfo.getBuyThirdNum()
					+ ","
					+ stockTradeInfo.getBuyThirdPrice()
					+ ","
					+ stockTradeInfo.getBuyFourNum()
					+ ","
					+ stockTradeInfo.getBuyFourPrice()
					+ ","
					+ stockTradeInfo.getBuyFiveNum()
					+ ","
					+ stockTradeInfo.getBuyFivePrice()
					+ ","
					+ stockTradeInfo.getSaleFirstNum()
					+ ","
					+ stockTradeInfo.getSaleFirstPrice()
					+ ","
					+ stockTradeInfo.getSaleSecondNum()
					+ ","
					+ stockTradeInfo.getSaleSecondPrice()
					+ ","
					+ stockTradeInfo.getSaleThirdNum()
					+ ","
					+ stockTradeInfo.getSaleThirdPrice()
					+ ","
					+ stockTradeInfo.getSaleFourNum()
					+ ","
					+ stockTradeInfo.getSaleFourPrice()
					+ ","
					+ stockTradeInfo.getSaleFiveNum()
					+ ","
					+ stockTradeInfo.getSaleFivePrice() + ")");
			System.out.println(sql);
			st.execute(sql.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean deleteStockTradeInfoByCode(String code) {
		try {
			Statement st = new DBUtil().getConn().createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from matrix.stock_trade_info where code =" + "'"
					+ code + "'");
			st.executeUpdate(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean deleteStockTradeInfoByDate(String date) {
		try {
			Statement st = new DBUtil().getConn().createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from matrix.stock_trade_info where ymd =" + "'"
					+ date + "'");
			System.out.println(sb);
			st.executeUpdate(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean delteStockTradeInfoByCodeAndDate(String code, String date) {
		// TODO Auto-generated method stub
		return false;
	}

	public void batchInsertStockTradeInfo(
			List<StockTradeInfoEntry> stockTradeInfoList) {
		// TODO Auto-generated method stub

	}

}
