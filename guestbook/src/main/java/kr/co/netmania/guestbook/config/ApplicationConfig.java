package kr.co.netmania.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.co.netmania.guestbook.dao",  "kr.co.netmania.guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {
}
