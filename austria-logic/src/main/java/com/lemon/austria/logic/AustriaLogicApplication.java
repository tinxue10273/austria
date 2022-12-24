package com.lemon.austria.logic;

import com.lemon.austria.service.AustriaServiceApplication;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.lemon.austria.common.util.JsonUtils;

import java.util.List;

@Log4j2
@Configuration
@Import(value = {AustriaServiceApplication.class})
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@ComponentScan(value = {"com.lemon.austria.logic","com.lemon.austria.common"})
public class AustriaLogicApplication  extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		for (int i = 0; i < converters.size(); i++) {
			if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
				MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
				converter.setObjectMapper(JsonUtils.getObjectMapper());
				converters.set(i, converter);
				break;
			}
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}


