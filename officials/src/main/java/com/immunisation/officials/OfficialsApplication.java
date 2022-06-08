package com.immunisation.officials;

import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xml.sax.SAXException;

@SpringBootApplication
public class OfficialsApplication implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for images
		registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
	
	
	public static void main(String[] args) throws JAXBException, SAXException {
		ApplicationContext applicationContext = SpringApplication.run(OfficialsApplication.class, args);
//		DbRunner.execute(applicationContext);
	}
}
