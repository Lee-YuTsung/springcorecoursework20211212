package com.study.springcore.yutsung.coursework20211212.coursework4.Model;

public class Item {
	private Integer id;
	private Integer amount;
	private Integer ipid;
	private Integer invid;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Integer amount, Integer ipid, Integer invid) {
		super();
		this.amount = amount;
		this.ipid = ipid;
		this.invid = invid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getIpid() {
		return ipid;
	}
	public void setIpid(Integer ipid) {
		this.ipid = ipid;
	}
	public Integer getInvid() {
		return invid;
	}
	public void setInvid(Integer invid) {
		this.invid = invid;
	}
	
}
