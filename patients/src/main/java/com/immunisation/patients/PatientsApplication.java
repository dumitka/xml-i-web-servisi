package com.immunisation.patients;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PatientsApplication implements WebMvcConfigurer{ //ima razlike

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for images
		registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PatientsApplication.class, args);

		FirstTimeSetup.execute(applicationContext);
		SpringApplication.run(PatientsApplication.class, args);
	}

}
