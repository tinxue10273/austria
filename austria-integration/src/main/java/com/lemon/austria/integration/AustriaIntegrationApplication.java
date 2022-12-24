package com.lemon.austria.integration;

import com.lemon.austria.common.AustriaCommonApplication;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Log4j2
@Configuration
@Import(AustriaCommonApplication.class)
@ComponentScan("com.lemon.austria.integration")
@ImportResource("classpath:META-INF/dubbo/rpc-client.xml")
public class AustriaIntegrationApplication {

}
