package com.lemon.austria.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
@ComponentScan("com.lemon.austria.service")
//@Import(value = {AustriaCommonApplication.class, ErkeIntegrationContext.class})
public class AustriaServiceApplication {

}
