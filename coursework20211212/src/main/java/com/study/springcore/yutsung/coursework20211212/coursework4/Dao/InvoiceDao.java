package com.study.springcore.yutsung.coursework20211212.coursework4.Dao;

import java.util.List;
import java.util.Map;

public interface InvoiceDao {
	Integer queryMaxIdByInvoice();
	List<Map<String, Object>> queryAllByInvoice();
	List<Map<String, Object>> queryAmountByInvoice();
	List<Map<String, Object>> queryValueByInvoice();
	List<Map<String, Object>> queryAmountByItem();
	List<Map<String, Object>> queryValueByItem();
	List<Map<String, Object>> queryMaxValueInvoice();
	List<Map<String, Object>> queryMaxValueItem();
	
}
