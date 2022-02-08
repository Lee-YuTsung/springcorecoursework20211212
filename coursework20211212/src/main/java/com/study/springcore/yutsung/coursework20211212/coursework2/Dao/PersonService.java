package com.study.springcore.yutsung.coursework20211212.coursework2.Dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

public interface PersonService {
	boolean append(String name, Date birth);
	boolean append(Person person);
	List<Person> findAllPersons();
	Person getPerson(String name);
	List<Person> findPersonsByBirth();
	List<Person> findPersonsByAge(Integer age);
	void setBirthByName(List<Person> people);
}