package com.study.springcore.yutsung.coursework20211212.coursework4.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDaoImpl implements InvoiceDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//r
	@Override
	public Integer queryMaxIdByInvoice() {
		String sql = "select max(id) from invoice";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	@Override
	public List<Map<String, Object>> queryAllByInvoice() {
		String sql="select i.invid, ip.text from item i inner join itemproduct ip on i.ipid =ip.id";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryAmountByInvoice(){
		String sql="select i.invid, sum(i.amount) as totle_amount "
				+ "from item i inner join itemproduct ip on i.ipid =ip.id "
				+ "group by i.invid";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryValueByInvoice(){
		String sql ="select i.invid, sum((i.amount*ip.price)) as value	"
				+ "from item i inner join itemproduct ip on i.ipid =ip.id "
				+ "group by i.invid";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryAmountByItem(){
		String sql ="select i.ipid, ip.text, sum(i.amount) as totle_amount "
				+ "from item i inner join itemproduct ip on i.ipid =ip.id "
				+ "group by i.ipid";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryValueByItem(){
		String sql ="select i.ipid, ip.text, sum((i.amount*ip.price)) as value "
				+ "from item i inner join itemproduct ip on i.ipid =ip.id "
				+ "group by i.ipid";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryMaxValueInvoice() {
		String sql = "select m.invid, max(m.value) from "
				+ "(select i.invid, sum((i.amount*ip.price)) as value "
				+ "from item i inner join itemproduct ip on i.ipid =ip.id "
				+ "group by i.invid) m";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> queryMaxValueItem() {
		String sql = "select m.ipid, m.text, max(m.value) "
				+ "from (select i.ipid, ip.text, sum((i.amount*ip.price)) as value "
				+ "from item i inner join itemproduct ip on i.ipid =ip.id "
				+ "group by i.ipid) m";
		return jdbcTemplate.queryForList(sql);
		
	}
	
}
