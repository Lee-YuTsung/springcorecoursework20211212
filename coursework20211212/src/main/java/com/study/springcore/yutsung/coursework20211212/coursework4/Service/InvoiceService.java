package com.study.springcore.yutsung.coursework20211212.coursework4.Service;

import java.util.List;
import java.util.Map;

public interface InvoiceService {
	List<Map<String, Object>> queryAllByInvoice();
	List<Map<String, Object>> queryAmountByInvoice();
	List<Map<String, Object>> queryValueByInvoice();
	List<Map<String, Object>> queryAmountByItem();
	List<Map<String, Object>> queryMaxValueItem();
	List<Map<String, Object>> queryMaxValueInvoice();
}
