package com.study.springcore.yutsung.coursework20211212.coursework2.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.springcore.yutsung.coursework20211212.coursework2.Dao.PersonService;
import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

/*
 * 功能:
 * 1. 建立 Person 資料
 * 		-> 輸入 name, birth
 * 2. 取得 Person 全部資料
 * 		-> 不用輸入參數
 * 3. 根據姓名取得 Person
 * 		-> 輸入 name
 * 4. 取得今天生日的 Person
 * 		-> 輸入今天日期
 * 5. 取得某一歲數以上的 Person
 * 		-> 輸入 age
 * 6. 根據姓名來修改Person的生日
 * 		-> 輸入 name, birth
 * 7. 根據姓名來刪除Person
 * 		-> 輸入 name
 * */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	public void addPerson(String name, int yyyy, int mm, int dd) {
		// 1. 判斷 name, yyyy, mm 與 dd 是否有資料?
		// 2. 將 yyyy/mm/dd 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPerson(String name, Date birth) {
		// 1. 判斷 name 與 birth 是否有資料?
		// 2. 建立 Person 資料
		boolean check = personService.append(name, birth);
		System.out.println("add person: " + check);
	}
	
	public void printAllPersons() {
		//System.out.println(personService.findAllPersons());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		// 資料呈現
		List<Person> people = personService.findAllPersons();
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
		System.out.println("+--------------+---------+--------------+");
		for(Person p : people) {
			String birthday = sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
	
	// 根據姓名取得 Person
	public Person getPersonByName(String name) {
		// 1. 判斷 name ?
		// 2. 根據姓名取得 Person
		Person person = personService.getPerson(name);
		return person;
	}
	
	public void getPersonsByBirth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<Person> people = personService.findPersonsByBirth();
		if(people == null) {
			System.out.println("今日無人生日");
		}else {
			System.out.println("+--------------+---------+--------------+");
			System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
			System.out.println("+--------------+---------+--------------+");
			for(Person p : people) {
				String birthday = sdf.format(p.getBirth());
				System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
				System.out.println("+--------------+---------+--------------+");
			}
		}
		
	}
	
	public void getPersonsByAge(Integer old) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<Person> people = personService.findPersonsByAge(old);
		if(people == null) {
			System.out.println("無人年齡在" + old + "以上");
		}else {
			System.out.println("+--------------+---------+--------------+");
			System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
			System.out.println("+--------------+---------+--------------+");
			for(Person p : people) {
				String birthday = sdf.format(p.getBirth());
				System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
				System.out.println("+--------------+---------+--------------+");
			}
		}
	}
	
	public void updataByName(String name, int yyyy, int mm, int dd) {
		List<Person> people = personService.findAllPersons();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			int index = 0;
			for(int i = 0; i < people.size() ; i++, index++) {
				if(people.get(i).getName().equals(name)) {
					break;
				}
			}
			if(index >= people.size() - 1) {
				System.out.println("查無此人");
			}else {
				people.get(index).setBirth(birth);
				personService.setBirthByName(people);
				printAllPersons();
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteByName(String name) {
		List<Person> people = personService.findAllPersons();
		int index = 0;
		for(int i = 0; i < people.size() ; i++, index++) {
			if(people.get(i).getName().equals(name)) {
				break;
			}
		}
		if(index >= people.size()) {
			System.out.println("查無此人");
		}else {
			people.remove(index);
			personService.setBirthByName(people);
			printAllPersons();
		}
	}
}