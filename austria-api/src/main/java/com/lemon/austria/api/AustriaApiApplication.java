package com.lemon.austria.api;

import com.lemon.austria.logic.AustriaLogicApplication;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@Log4j2
@EnableAsync
@Import(value = {AustriaLogicApplication.class})
@ImportResource("classpath:META-INF/dubbo/api-rpc-server.xml")
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"com.lemon.austria.api"})
public class AustriaApiApplication {

	public static void main(String[] args) {
		log.info("[hello world]");
		SpringApplication.run(AustriaApiApplication.class, args);
	}

}
