package kr.co.netmania.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam03 {
	public static void main(String[] args) {

		// Bean 어노테이션을 통해 객체를 등록하는 클래스
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		//Car car = (Car) ac.getBean("car");
		
		// 리턴 타입이 Car인 것을 찾아옴
		Car car = (Car) ac.getBean(Car.class);
		car.run();
	}
}
