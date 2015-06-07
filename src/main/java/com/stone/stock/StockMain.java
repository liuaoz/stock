package com.stone.stock;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stone.dao.stock.IStockDao;
import com.stone.dao.stock.impl.StockDaoImpl;
import com.stone.dao.stocktrade.IStockTradeDao;
import com.stone.dao.stocktrade.impl.StockTradeDaoImpl;
import com.stone.entry.stocktrade.StockEntry;
import com.stone.entry.stocktrade.StockTradeInfoEntry;
import com.stone.service.net.IStockTradeNetDataService;
import com.stone.service.net.impl.StockTradeNetDataServiceImpl;

/**
 * ��ȡ��Ʊ����
 * 
 * @author matrix
 * 
 */
public class StockMain {
	public static void main(String[] args) {
		StockMain sm = new StockMain();
		IStockTradeNetDataService iStockTradeNetDataService = new StockTradeNetDataServiceImpl();
		IStockDao stockDao = new StockDaoImpl();
		IStockTradeDao iStockTradeDao = new StockTradeDaoImpl();
		iStockTradeDao.deleteStockTradeInfoByDate(sm.getCurrentDate());
		List<String> list = new ArrayList<String>();
		List<String> tmplist = new ArrayList<String>();

		for (StockEntry stockEntry : stockDao.selectStockEntryList()) {
			if (stockEntry.getExchangeCenter().equals("��֤"))
				list.add("sh" + stockEntry.getCode().trim());
			else if (stockEntry.getExchangeCenter().equals("��֤"))
				list.add("sz" + stockEntry.getCode().trim());
			else
				System.out.println("��Ʊ����Ϊ��" + stockEntry.getCode()
						+ "��������δ֪!!!");
		}

		for (int i = 1; i <= list.size(); i++) {
			tmplist.add(list.get(i - 1));
			if (i % 20 == 0) {
				for (StockTradeInfoEntry stockTradeInfoEntry : iStockTradeNetDataService
						.getStockTradeInfoListByCodeList(tmplist)) {
					iStockTradeDao.insertStockTradeInfo(stockTradeInfoEntry);
				}
				tmplist.clear();
			}
		}

	}

	public void initStockTradeData() {
		// 1.�������������ظ�����

		// 2.�����Ʊ��������
	}

	public void initDataMethodNormal() {
		// 1.��������
		StockMain sm = new StockMain();
		StockTradeDaoImpl std = new StockTradeDaoImpl();
		std.deleteStockTradeInfoByDate(sm.getCurrentDate());
		long start = System.currentTimeMillis();
		// 2.��������
		IStockDao stockDao = new StockDaoImpl();
		List<StockEntry> stockList = stockDao.selectStockEntryList();
		for (StockEntry stock : stockList) {
			if (stock.getExchangeCenter().equals("��֤"))
				std.insertStockTradeInfo(sm.getData("sh" + stock.getCode()));
			else if (stock.getExchangeCenter().equals("��֤"))
				std.insertStockTradeInfo(sm.getData("sz" + stock.getCode()));

		}
		long end = System.currentTimeMillis();
		System.out.println("�ܹ���ʱ��" + (end - start));

	}

	public String getCurrentDate() {
		String date = "";
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		date = sdf.format(now);
		return date;
	}

	public void clearData() {

	}

	/**
	 * ��ȡurl
	 * 
	 * @return
	 */
	public String getURL() {
		return null;
	}

	public List<String> getStockCodeList() {

		return null;
	}

	/**
	 * ���ݹ�Ʊ�����ȡ��Ʊ��������
	 * 
	 * @param code
	 *            ��Ʊ����
	 * @return ��Ʊ��������
	 */
	public StockTradeInfoEntry getData(String code) {
		System.out.println("========��ʼ��ȡ��Ʊ����Ϊ��" + code + " ������");
		StockTradeInfoEntry stockTradeInfo = new StockTradeInfoEntry();
		// String url = "http://hq.sinajs.cn/list=sz000753,sz000830,sh600151";
		String url = "http://hq.sinajs.cn/list=" + code;
		try {
			URL u = new URL(url);
			byte[] b = new byte[256];
			InputStream in = null;
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			boolean flag = false;
			while (!flag) {
				try {
					in = u.openStream();
					int i;
					while ((i = in.read(b)) != -1) {
						bo.write(b, 0, i);
					}
					String result = bo.toString();
					String[] stocks = result.split(";");
					for (String stock : stocks) {
						if (stock.equals("\n"))
							return stockTradeInfo;
						int first = stock.indexOf("\"");
						int last = stock.lastIndexOf("\"");
						if (first + 1 == last) {
							return null;
						}
						stock = stock.substring(first + 1, last);
						String[] datas = stock.split(",");
						// ���ݶ����Լ���Ӧ����
						for (String data : datas) {
							System.out.print(data + " ");
						}
						System.out.println();
						stockTradeInfo = getStockTradeInfoEntry(datas);
						stockTradeInfo.setCode(code);
					}
					bo.reset();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				} finally {
					if (in != null) {
						in.close();
					}
				}
				flag = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		System.out.println("========��ɻ�ȡ��Ʊ����Ϊ��" + code + " ������");
		return stockTradeInfo;
	}

	/**
	 * ���ַ����������ӳ���ϵת���ɹ�Ʊ����ʵ����
	 * 
	 * @param datas
	 *            ��url��ȡ��ĳһֻ��Ʊ��������
	 * @return ��Ʊ����ʵ�������
	 */
	public StockTradeInfoEntry getStockTradeInfoEntry(String[] datas) {
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
}
