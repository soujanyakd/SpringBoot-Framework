package com.flipkartonlineshopping.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ManageProperty {
	
	@Value("${com.flipkartUrl}")
    public String url;	
	
    @Value("${com.userName}")
    public String userName;
	
    @Value("${com.userPassword}")
    public String password;
	
    @Value("${com.productName}")
    public String productName;
	 
}
