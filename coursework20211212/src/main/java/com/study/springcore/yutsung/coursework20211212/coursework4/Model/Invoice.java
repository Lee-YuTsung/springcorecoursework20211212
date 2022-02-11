package com.study.springcore.yutsung.coursework20211212.coursework4.Model;

import java.util.Date;

public class Invoice {
	private Integer id;
	private Date invDate;
	
	public Invoice() {
		super();
		this.invDate = new Date();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getInvDate() {
		return invDate;
	}
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}
}
