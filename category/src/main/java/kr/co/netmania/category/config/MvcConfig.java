package kr.co.netmania.category.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "kr.co.netmania.category.dao", "kr.co.netmania.category.controller" })
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/**")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	public ApiInfo apiInfo() {

		Contact contact = new Contact("ClarXo", "https://github.com/PanicBear", "cheonaru@naver.com");

		ApiInfo apiInfo = new ApiInfoBuilder().title("Swagger Sample").description("APIs Sample")
				.version("Sample Doc 0.1v").contact(contact).license("This sentence will be display.")
				.termsOfServiceUrl("/").build();
		return apiInfo;
	}
}
