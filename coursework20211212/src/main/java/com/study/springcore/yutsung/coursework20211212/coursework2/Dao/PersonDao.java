package com.study.springcore.yutsung.coursework20211212.coursework2.Dao;

import java.util.List;

import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

public interface PersonDao {
	// 建立 Person
	public boolean create(Person person);
	// 查詢所有 Person
	public List<Person> readAll();
	
	public void update(List<Person> people);
}