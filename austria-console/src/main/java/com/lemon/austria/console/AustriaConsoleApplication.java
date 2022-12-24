package com.lemon.austria.console;

import com.lemon.austria.logic.AustriaLogicApplication;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log4j2
@EnableAsync
@Configuration
@EnableScheduling
@Import(value = {AustriaLogicApplication.class})
@ImportResource("classpath:META-INF/dubbo/console-rpc-server.xml")
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = "com.lemon.austria.console")
public class AustriaConsoleApplication {

	public static void main(String[] args) {
		log.info("[hello world]");
		SpringApplication.run(AustriaConsoleApplication.class, args);
	}

}
