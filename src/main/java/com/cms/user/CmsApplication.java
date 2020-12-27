package com.cms.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开启定时任务
@EnableScheduling
// springboot启动类
@SpringBootApplication
public class CmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	// 打WAR包需要
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(CmsApplication.class);
	}
}
