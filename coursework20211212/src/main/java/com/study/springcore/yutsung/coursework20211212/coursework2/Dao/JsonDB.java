package com.study.springcore.yutsung.coursework20211212.coursework2.Dao;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

@Component
public class JsonDB { // Json 資料庫
	
	@Autowired
	private Gson gson;
	
	// Json file 資料庫存放地
	private static final Path PATH = Paths.get("src/main/java/com/study/springcore/yutsung/coursework20211212/coursework2/person.json");
	
	// 查詢全部
	public List<Person> queryAll() throws Exception {
		String jsonStr = Files.readAllLines(PATH).stream().collect(Collectors.joining());
		Type type = new TypeToken<ArrayList<Person>>() {}.getType();
		List<Person> people = gson.fromJson(jsonStr, type);
		// 請將 age 變為最新年齡
		/*
		Date today = new Date();
		LocalDate todayLocalDate = today.toInstant()
									.atZone(ZoneId.systemDefault())
									.toLocalDate();
		for(Person person : people) {
			LocalDate birthLocalDate = person.getBirth().toInstant()
									.atZone(ZoneId.systemDefault())
									.toLocalDate();
			int age = todayLocalDate.getYear() - birthLocalDate.getYear();
			person.setAge(age);
		}
		*/
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int todayYear = calendar.get(Calendar.YEAR);
		for(Person person : people) {
			calendar.setTime(person.getBirth());
			int biythYear = calendar.get(Calendar.YEAR);
			int age = todayYear - biythYear;
			person.setAge(age);
		}
		return people;
	}
	
	public boolean add(Person person) throws Exception {
		List<Person> people = queryAll();
		// 作業 1:
		// 如果 person 已存在則 return false
		// name, age, birth 皆與目前資料庫某一 person 資料相同
		LocalDate ld1, ld2;
		for(Person p : people) {
			ld1 = p.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			ld2 = person.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if(p.getName().equals(person.getName()) && 
					p.getAge().equals(person.getAge()) && 
					ld1.equals(ld2)) {
				break;
			}else {
				people.add(person);
				String newJsonString = gson.toJson(people);
				Files.write(PATH, newJsonString.getBytes("UTF-8"));
				return true;
			}
		}
		return false;
		
	}
	
	public void update(List<Person> people) throws Exception {
		
		String newJsonString = gson.toJson(people);
		Files.write(PATH, newJsonString.getBytes("UTF-8"));
		
		
	}
	
	
}