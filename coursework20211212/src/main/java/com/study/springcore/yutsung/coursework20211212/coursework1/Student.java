package com.study.springcore.yutsung.coursework20211212.coursework1;

import java.util.Set;

public class Student {
	private Integer id;//學生代號
	private String name;//學生姓名
	private Set<Clazz> clazzs;//所選課程
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clazzs=" + clazzs + "]";
	}
	
}
