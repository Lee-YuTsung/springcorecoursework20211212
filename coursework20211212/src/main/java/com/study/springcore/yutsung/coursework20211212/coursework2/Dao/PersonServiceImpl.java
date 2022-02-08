package com.study.springcore.yutsung.coursework20211212.coursework2.Dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springcore.yutsung.coursework20211212.coursework2.Model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Override
	public boolean append(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		return append(person);
	}

	@Override
	public boolean append(Person person) {
		return personDao.create(person);
	}

	@Override
	public List<Person> findAllPersons() {
		return personDao.readAll();
	}

	@Override
	public Person getPerson(String name) {
		Optional<Person> optPerson = findAllPersons()
				.stream()
				.filter(p -> p.getName().equals(name))
				.findFirst();
		return optPerson.isPresent() ? optPerson.get() : null;
	}

	@Override
	public List<Person> findPersonsByBirth() {
		// TODO Auto-generated method stub
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		String nows = sdf.format(now);
		List<Person> birthday = findAllPersons()
				.stream()
				.filter(p -> sdf.format(p.getBirth()).equals(nows))
				.collect(Collectors.toList());
		
		return birthday.size() != 0 ? birthday : null;
	}

	@Override
	public List<Person> findPersonsByAge(Integer age) {
		List<Person> old = findAllPersons()
				.stream()
				.filter(p -> p.getAge() >= age)
				.collect(Collectors.toList());
		
		return old.size() != 0 ? old : null;
	}

	@Override
	public void setBirthByName(List<Person> people) {
		personDao.update(people);
		
	}
	
}