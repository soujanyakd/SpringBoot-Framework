package com.flipkartonlineshopping.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.flipkartonlineshopping.pageobject.BaseUIPage;

/*@Component*/
@Configuration
@ComponentScan(basePackages = {"com"})
@PropertySource("file:../FlipkartOnlineShopping/config.properties")
public class ConfigProperty {
	
	@Bean
	public ManageProperty manageProperty() {
		return new ManageProperty();
	}
	
	@Bean
	public BaseUIPage baseUIPage() {
		return new BaseUIPage();
	}

}
