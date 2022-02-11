package com.study.springcore.yutsung.coursework20211212.coursework4.Controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.springcore.yutsung.coursework20211212.coursework4.Service.InvoiceService;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	public List<Map<String, Object>> queryAllByInvoice() {
		return invoiceService.queryAllByInvoice();
	}
	public List<Map<String, Object>> queryAmountByInvoice() {
		return invoiceService.queryAmountByInvoice();
	}
	public List<Map<String, Object>> queryValueByInvoice() {
		return invoiceService.queryValueByInvoice();
	}
	public List<Map<String, Object>> queryAmountByItem() {
		return invoiceService.queryAmountByItem();
	}
	public List<Map<String, Object>> queryMaxValueItem() {
		return invoiceService.queryMaxValueItem();
	}
	public List<Map<String, Object>> queryMaxValueInvoice() {
		return invoiceService.queryMaxValueInvoice();
	}
	
}
