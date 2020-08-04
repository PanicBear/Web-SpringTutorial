package kr.co.netmania.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.netmania.daoexam.config.ApplicationConfig;
import kr.co.netmania.daoexam.dao.RoleDao;
import kr.co.netmania.daoexam.dto.Role;

public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		List<Role> list = roleDao.selectAll();
		
		for(Role role : list) {
			System.out.println(role);
		}
	}

}
