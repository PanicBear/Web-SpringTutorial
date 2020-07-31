package kr.co.netmania.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car constructor");
	}
	
//	public void setEngine(Engine e) {
//		this.v8 = e;
//	}
	
	public void run() {
		System.out.println("use Engine");
		v8.exec();
	}
	
//	public static void main(String[] args) {
//		Engine e = new Engine();
//		Car c= new Car();
//		c.setEngine(e);
//		c.run();
//	}
}
