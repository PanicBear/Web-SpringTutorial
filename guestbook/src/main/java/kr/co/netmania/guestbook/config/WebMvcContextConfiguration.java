package kr.co.netmania.guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


// 해당 설정들은 DispatcherServlet이 불러들이는 것
// 이 어노테이션들 지운거 실수(9/3커밋된 것)
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.co.netmania.guestbook.controller"})
public class WebMvcContextConfiguration implements WebMvcConfigurer {
	
	// 특정 url이 입력되었을 때 파일로부터 읽어들임
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}
	
	
	// default servlet handler를 사용하게 함
	// mapping 정보가 없는 url이 들어왔을 때 defaultServletHttpRequestHandle이 처리
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	// 특정 url에 대한 처리를 controller 클래스를 작성하지 않고 매핑 할 수 있도록 함
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControll가 호출됩니다");
		System.out.println("id랑 pw 지워놨으니 ApplicationConfig 확인");
		registry.addViewController("/").setViewName("index");
	}

	// 적절한 뷰 resolver가 뷰의 이름을 갖고 어떤 뷰인지에 대해 찾아낼 수 있게 함
	// /WEB-INF/views/"index 자리".jsp
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
