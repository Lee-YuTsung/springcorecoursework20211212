package com.study.springcore.yutsung.coursework20211212.coursework3.template;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//01/09Homework
@Component
@Aspect
@Order(1)
public class MethodLogAspect {
	
	@Pointcut("execution(* com.study.springcore.yutsung.coursework20211212.coursework3.template.EmpDao.queryAll(..))")
	public void pt1() {
		
	}
	
	@Around("pt1()")
	public Object log(ProceedingJoinPoint  joinPoint) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		Object result = null;
		int start = 0;
		int end = 0;
		String name;
		
		try {
			result = joinPoint.proceed();
			start = joinPoint.toString().lastIndexOf(".") + 1;
			end = joinPoint.toString().lastIndexOf("(");
			name = joinPoint.toString().substring(start, end);
			empDao.createLog(name);
			//System.out.println("環繞通知: 返回通知 result = " + result);
		} catch (Throwable e) {
			System.err.println("環繞通知: 異常通知 ex = " + e);
		}finally {
			//System.out.println("環繞通知: 後置通知");
		}
		return result;
	}
	
	
}
