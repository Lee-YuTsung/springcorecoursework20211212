package com.study.springcore.yutsung.coursework20211212.corsework2;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.yutsung.coursework20211212.coursework2.Dao.JsonDB;
import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

public class TestJsonDB {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		JsonDB jsonDB = ctx.getBean("jsonDB", JsonDB.class);
		System.out.println(jsonDB.queryAll());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		boolean check = jsonDB.add(new Person("Molly", 29, sdf.parse("1992/8/23")));
		System.out.println(check);
		
		System.out.println(jsonDB.queryAll());
		
	}

}