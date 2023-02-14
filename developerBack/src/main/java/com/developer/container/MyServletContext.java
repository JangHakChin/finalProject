package com.developer.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc //WebApplicationContext 컨테이너임을 알리기위해 붙여야 한다. 
public class MyServletContext implements WebMvcConfigurer { //CORS 설정을 위한 상속

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
					.allowedOrigins("http://192.168.0.198:5500")
					.allowCredentials(true)
					.allowedMethods("GET", "POST", "PUT", "DELETE");
	} 
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		cmr.setMaxUploadSize(1024 * 1000);
		cmr.setMaxUploadSizePerFile(1024* 1000);
		return cmr;
	}
	

}
