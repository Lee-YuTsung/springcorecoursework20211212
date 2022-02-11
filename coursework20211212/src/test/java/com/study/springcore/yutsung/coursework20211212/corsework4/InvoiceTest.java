package com.study.springcore.yutsung.coursework20211212.corsework4;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.yutsung.coursework20211212.coursework4.Controller.InvoiceController;

public class InvoiceTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
	InvoiceController invoiceController = ctx.getBean("invoiceController", InvoiceController.class);
	private boolean stop;

	public static void main(String[] args) {
		new InvoiceTest().start();
	}
	
	public void start() {
		while (!stop) {
			menu();
		}
	}
	
	private void menu() {
		System.out.println("=========================================");
		System.out.println("1. 每一張發票有那些商品");
		System.out.println("2. 每一張發票有幾件商品");
		System.out.println("3. 每一張發票價值多少");
		System.out.println("4. 每一樣商品各賣了多少");
		System.out.println("5. 哪一件商品賣得錢最多");
		System.out.println("6. 哪一張發票價值最高");
		System.out.println("0. 離開系統");
		System.out.println("=========================================");
		System.out.print("請選擇: ");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				invoiceController.queryAllByInvoice().forEach(System.out::println);
				break;
			case 2:
				invoiceController.queryAmountByInvoice().forEach(System.out::println);
				break;
			case 3:
				invoiceController.queryValueByInvoice().forEach(System.out::println);
				break;
			case 4:
				invoiceController.queryAmountByItem().forEach(System.out::println);
				break;
			case 5:
				invoiceController.queryMaxValueItem().forEach(System.out::println);
				break;
			case 6:
				invoiceController.queryMaxValueInvoice().forEach(System.out::println);
				break;
			case 0://離開
				System.out.println("離開系統");
				stop = true;
				break;
		}
	}
}
