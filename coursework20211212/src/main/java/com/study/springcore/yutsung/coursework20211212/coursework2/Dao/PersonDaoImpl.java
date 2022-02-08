package com.study.springcore.yutsung.coursework20211212.coursework2.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private JsonDB jsonDB;
	
	@Override
	public boolean create(Person person) {
		Boolean check = null;
		try {
			check = jsonDB.add(person);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public List<Person> readAll() {
		List<Person> people = null;
		try {
			people = jsonDB.queryAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return people;
	}

	@Override
	public void update(List<Person> people) {
		try {
			jsonDB.update(people);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
	
}