package com.stone.service.net.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stone.entry.stocktrade.StockTradeInfoEntry;
import com.stone.service.net.IStockTradeNetDataService;

/**
 * 从网上获取股票交易数据实现类
 * 
 * @author matrix
 * @since 2015-05-14
 * 
 * 
 */
public class StockTradeNetDataServiceImpl implements IStockTradeNetDataService {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("sz000753");
		list.add("sz000758");
		for (StockTradeInfoEntry stockTradeInfoEntry : new StockTradeNetDataServiceImpl()
				.getStockTradeInfoListByCodeList(list)) {
			System.out.println(stockTradeInfoEntry.getName());
		}
	}

	/**
	 * 获取股票交易数据地址， 1.获取一只股票的交易信息。 如 http://hq.sinajs.cn/list=sz000753
	 * 2.获取多只股票的交易信息。如http://hq.sinajs.cn/list=sz000753,sz000752
	 */
	// private String url = "http://hq.sinajs.cn/list=";

	public StockTradeInfoEntry getStockTradeInfoByCode(String code) {
		String url = "http://hq.sinajs.cn/list=";
		url = url + code;
		try {
			URL u = new URL(url);
			byte[] b = new byte[256];
			InputStream in = null;
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			try {
				in = u.openStream();
				int i;
				while ((i = in.read(b)) != -1) {
					bo.write(b, 0, i);
				}
				String result = bo.toString();

				int start = result.indexOf("\"");
				int last = result.lastIndexOf("\"");
				if (last > start + 1) {
					result = result.substring(start + 1, last);
					String[] datas = result.split(",");
					return getStockTradeInfoEntry(datas);
				} else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<StockTradeInfoEntry> getStockTradeInfoListByCodeList(
			List<String> codeList) {
		String url = "http://hq.sinajs.cn/list=";
		StringBuffer sb = new StringBuffer();
		for (String str : codeList) {
			sb.append(str + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		url = url + sb;
		System.out.println(url);
		List<StockTradeInfoEntry> stockTradeInfoEntries = new ArrayList<StockTradeInfoEntry>();
		try {
			URL u = new URL(url);
			byte[] b = new byte[1024];
			InputStream in = null;
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			try {
				in = u.openStream();
				int i;
				while ((i = in.read(b)) != -1) {
					bo.write(b, 0, i);
				}
				String result = bo.toString();
				String[] stocks = result.split(";");
				/*
				 * for (String str : stocks) { int start = str.indexOf("\"");
				 * int last = str.lastIndexOf("\""); if (last > start + 1) { str
				 * = str.substring(start + 1, last); String[] datas =
				 * str.split(","); StockTradeInfoEntry stockTradeInfoEntry =
				 * getStockTradeInfoEntry( datas).setCode(code);
				 * stockTradeInfoEntries.add(stockTradeInfoEntry); } else {
				 * continue; } }
				 */
				System.out.println("=========codelist.size()========"
						+ codeList.size());
				System.out.println("=========stocks.size()========"
						+ stocks.length);
				for (int j = 0; j < stocks.length; j++) {
					int start = stocks[j].indexOf("\"");
					int last = stocks[j].lastIndexOf("\"");
					if (last > start + 1) {
						stocks[j] = stocks[j].substring(start + 1, last);
						String[] datas = stocks[j].split(",");
						StockTradeInfoEntry stockTradeInfoEntry = getStockTradeInfoEntry(datas);
						stockTradeInfoEntry.setCode(codeList.get(j));
						stockTradeInfoEntries.add(stockTradeInfoEntry);
					} else {
						continue;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stockTradeInfoEntries;
	}

	private StockTradeInfoEntry getStockTradeInfoEntry(String[] datas) {
		StockTradeInfoEntry stockTradeInfoEntry = new StockTradeInfoEntry();
		stockTradeInfoEntry.setYmd(getCurrentDate());
		stockTradeInfoEntry.setName(datas[0]);
		stockTradeInfoEntry.setTodayOpenPrice(Double.parseDouble(datas[1]));
		stockTradeInfoEntry.setYestdayClosePrice(Double.parseDouble(datas[2]));
		stockTradeInfoEntry.setTodayClosePrice(Double.parseDouble(datas[3]));
		stockTradeInfoEntry.setTopPrice(Double.parseDouble(datas[4]));
		stockTradeInfoEntry.setBottomPrice(Double.parseDouble(datas[5]));
		stockTradeInfoEntry.setBuyPrice(Double.parseDouble(datas[6]));
		stockTradeInfoEntry.setSalePrice(Double.parseDouble(datas[7]));
		stockTradeInfoEntry.setTradeNum(Long.parseLong(datas[8]));
		stockTradeInfoEntry.setTradeAmount(Double.parseDouble(datas[9]));
		stockTradeInfoEntry.setBuyFirstNum(Long.parseLong(datas[10]));
		stockTradeInfoEntry.setBuyFirstPrice(Double.parseDouble(datas[11]));
		stockTradeInfoEntry.setBuySecondNum(Long.parseLong(datas[12]));
		stockTradeInfoEntry.setBuySecondPrice(Double.parseDouble(datas[13]));
		stockTradeInfoEntry.setBuyThirdNum(Long.parseLong(datas[14]));
		stockTradeInfoEntry.setBuyThirdPrice(Double.parseDouble(datas[15]));
		stockTradeInfoEntry.setBuyFourNum(Long.parseLong(datas[16]));
		stockTradeInfoEntry.setBuyFourPrice(Double.parseDouble(datas[17]));
		stockTradeInfoEntry.setBuyFiveNum(Long.parseLong(datas[18]));
		stockTradeInfoEntry.setBuyFivePrice(Double.parseDouble(datas[19]));
		stockTradeInfoEntry.setSaleFirstNum(Long.parseLong(datas[20]));
		stockTradeInfoEntry.setSaleFirstPrice(Double.parseDouble(datas[21]));
		stockTradeInfoEntry.setSaleSecondNum(Long.parseLong(datas[22]));
		stockTradeInfoEntry.setSaleSecondPrice(Double.parseDouble(datas[23]));
		stockTradeInfoEntry.setSaleThirdNum(Long.parseLong(datas[24]));
		stockTradeInfoEntry.setSaleThirdPrice(Double.parseDouble(datas[25]));
		stockTradeInfoEntry.setSaleFourNum(Long.parseLong(datas[26]));
		stockTradeInfoEntry.setSaleFourPrice(Double.parseDouble(datas[27]));
		stockTradeInfoEntry.setSaleFiveNum(Long.parseLong(datas[28]));
		stockTradeInfoEntry.setSaleFivePrice(Double.parseDouble(datas[29]));
		return stockTradeInfoEntry;
	}

	private String getCurrentDate() {
		String date = "";
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		date = sdf.format(now);
		return date;
	}

}
