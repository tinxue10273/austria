package com.lemon.austria.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Log4j2
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.lemon.austria.common")
public class AustriaCommonApplication {

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(100);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setQueueCapacity(100);
		executor.setKeepAliveSeconds(60);
		executor.setAwaitTerminationSeconds(60);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}

}
