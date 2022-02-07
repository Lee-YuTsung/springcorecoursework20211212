package com.study.springcore.yutsung.coursework20211212.corsework1;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.yutsung.coursework20211212.coursework1.Clazz;
import com.study.springcore.yutsung.coursework20211212.coursework1.Student;
import com.study.springcore.yutsung.coursework20211212.coursework1.Teacher;

public class Text1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
		
		Student john = ctx.getBean("s1", Student.class);
		//System.out.println(john);
		
		Student mary = ctx.getBean("s2", Student.class);
		//System.out.println(mary);
		
		
		//=============================================================================
		Teacher t1 = ctx.getBean("t1", Teacher.class);
		Teacher t2 = ctx.getBean("t2", Teacher.class);
		Teacher[] ts = {t1, t2};
		Set<Teacher> teachers = new LinkedHashSet<>();
		Set <Clazz> set1 =mary.getClazzs();
		System.out.println(set1);
		List<Integer> list2 =mary.getClazzs().stream().map(Clazz::getId).collect(Collectors.toList());
		System.out.println(list2);
		Set<Teacher> set3 = new LinkedHashSet<>();
		set3.add(t1);
		set3.add(t2);
		Set<Teacher> ans = set3.stream().filter(t -> list2.retainAll(t.getClazzs().stream().map(Clazz::getId)
				.collect(Collectors.toList()))).collect(Collectors.toSet());
		ans.stream().map(t -> t.getName()).forEach(System.out::println);
		//=============================================================================
		
//		for(Clazz c : mary.getClazzs()) {
//			System.out.println(c.getId());
//			clazz_loop:
//			for(Teacher t : ts) {
//				System.out.println(t.getClazzs());
//				
//				for(Clazz ct : t.getClazzs()) {
//					if(ct.getId().equals(c.getId())) {
//						//System.out.println(t.getName());
//						//teachers.add(t);
//						break clazz_loop;
//					}
//				}
//			}
//		}
//		//System.out.println(teachers.stream().map(Teacher::getName).collect(Collectors.toSet()));
	}
}
