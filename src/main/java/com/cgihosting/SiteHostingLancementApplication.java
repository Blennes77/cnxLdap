package com.cgihosting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SiteHostingLancementApplication extends SpringBootServletInitializer {

@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SiteHostingLancementApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SiteHostingLancementApplication.class, args);
	}
}
