package com.rsh.testrelationtable.trt01.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	@Bean
	ServletRegistrationBean h2ServletRegistrationBean() {
		ServletRegistrationBean registrationBean =
				new ServletRegistrationBean(new WebdavServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
	
}
