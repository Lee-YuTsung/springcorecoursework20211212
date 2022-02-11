package com.study.springcore.yutsung.coursework20211212.corsework3;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.yutsung.coursework20211212.coursework3.template.EmpDao;

public class TemplateTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		System.out.println(empDao.queryAll());
		List<Map<String, Object>> emps = empDao.queryAll();
		String ename = emps.stream().filter(e -> (e.get("eid") + "").equals("2")).findFirst().get().get("ename") + "";
		System.out.println(ename);
		
		System.out.println(empDao.queryListEmps());
		System.out.println(empDao.queryListEmps2());
		
		//01/09Homework
		empDao.queryLog().forEach(System.out::println);
	}

}
