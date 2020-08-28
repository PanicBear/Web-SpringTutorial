package kr.co.netmania.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kr.co.netmania.reservation.config.DBConfig;

@Configuration
@ComponentScan(basePackages = {"kr.co.netmania.reservation.service", "kr.co.netmania.reservation.dao"})
@Import({DBConfig.class})
public class ApplicationConfig {
}

