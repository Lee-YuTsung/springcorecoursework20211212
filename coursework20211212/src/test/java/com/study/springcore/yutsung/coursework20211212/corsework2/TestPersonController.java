package com.study.springcore.yutsung.coursework20211212.corsework2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.yutsung.coursework20211212.coursework2.Controller.PersonController;

public class TestPersonController {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		PersonController personController = ctx.getBean("personController", PersonController.class);
		
		personController.printAllPersons();
		personController.addPerson("Bob", 2013, 12, 26);
		personController.printAllPersons();
		
		System.out.println(personController.getPersonByName("Randy"));
		System.out.println(personController.getPersonByName("Tom"));
	}

}