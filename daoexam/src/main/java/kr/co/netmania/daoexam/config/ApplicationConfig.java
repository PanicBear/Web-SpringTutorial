package kr.co.netmania.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.co.netmania.daoexam.dao"})	// 다중 패키지 선언도 가능
@Import({DBConfig.class})
public class ApplicationConfig {

}
