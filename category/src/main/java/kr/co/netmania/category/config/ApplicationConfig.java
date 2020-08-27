package kr.co.netmania.category.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = {"kr.co.netmania.category.service", "kr.co.netmania.category.dao"})
@Import({DBConfig.class})
public class ApplicationConfig {
}
