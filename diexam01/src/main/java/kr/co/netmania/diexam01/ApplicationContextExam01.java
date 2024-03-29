package kr.co.netmania.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("ClarXo");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		// spring에서 객체 생성 시 싱글턴 패턴을 이용하기에, 재활용되어 동일하다
		if(userBean==userBean2||userBean.equals(userBean2)) {
			System.out.println("동일");
		}
	}
}
