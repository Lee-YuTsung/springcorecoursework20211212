package com.study.springcore.yutsung.coursework20211212.coursework4.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springcore.yutsung.coursework20211212.coursework4.Dao.InvoiceDao;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public List<Map<String, Object>> queryAllByInvoice() {
		List<Map<String, Object>> invoice1 = invoiceDao.queryAllByInvoice();
		List<Map<String, Object>> invoice2 = new ArrayList<>();
		Map<String, Object> interim =new LinkedHashMap<>();
		//int title = 0;
		for(int i = 1; i <= invoiceDao.queryMaxIdByInvoice(); i++) {
			interim.put("invid",i);
			int number = 0;
			for(int j = 0; j < invoice1.size(); j++) {
				if(invoice1.get(j).get("invid").toString().equals(i + "")) {
					number++;
					interim.put("item_" + number,invoice1.get(j).get("text"));
					//title += (int)a1.get(j).get("小計");
				}
			}
			invoice2.add(new LinkedHashMap<String, Object>(interim));
			interim.clear();
			//t1.put("總計",title);
		}
		return invoice2;
		
	}

	@Override
	public List<Map<String, Object>> queryAmountByInvoice() {
		return invoiceDao.queryAmountByInvoice();
		
	}

	@Override
	public List<Map<String, Object>> queryValueByInvoice() {
		return invoiceDao.queryValueByInvoice();
	}

	@Override
	public List<Map<String, Object>> queryAmountByItem() {
		return invoiceDao.queryAmountByItem();
	}

	@Override
	public List<Map<String, Object>> queryMaxValueItem() {
		return invoiceDao.queryMaxValueItem();
	}
	
	@Override
	public List<Map<String, Object>> queryMaxValueInvoice() {
		return invoiceDao.queryMaxValueInvoice();
	}

}
