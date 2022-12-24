package com.lemon.austria.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@Configuration
@SpringBootApplication(scanBasePackages = "com.lemon.austria.task")
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableScheduling
@EnableAsync
public class AustriaTaskApplication {

	public static void main(String[] args) {
		log.info("[hello world]");
		SpringApplication.run(AustriaTaskApplication.class, args);
	}

}
