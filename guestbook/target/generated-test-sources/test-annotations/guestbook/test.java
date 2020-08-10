package guestbook;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.concurrent.SuccessCallback;

import junit.framework.Assert;
import kr.co.netmania.guestbook.config.ApplicationConfig;
import kr.co.netmania.guestbook.dao.GuestbookDao;
import kr.co.netmania.guestbook.dao.LogDao;
import kr.co.netmania.guestbook.dto.Guestbook;
import kr.co.netmania.guestbook.dto.Log;
import kr.co.netmania.guestbook.service.GuestbookService;

public class test {

	@Test
	public void test1() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);

		Guestbook guestbook = new Guestbook();
		guestbook.setName("강경미");
		guestbook.setContent("반갑습니다. 여러분.");
		guestbook.setRegdate(new Date());
		long id = guestbookDao.insert(guestbook);
		
		System.out.println(id);

		// assertEquals(19, (long) id);
	}

	@Test
	public void test2() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		LogDao logDao = ac.getBean(LogDao.class);
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);

		System.out.println(log.getIp() + log.getMethod() + log.getRegdate());
	}
	
	@Test
	public void text3() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);

		Guestbook guestbook = new Guestbook();
		guestbook.setName("kang kyungmi22");
		guestbook.setContent("반갑습니다. 여러분. 여러분이 재미있게 공부하고 계셨음 정말 좋겠네요^^22");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
	}
}
