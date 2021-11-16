package com.flipkartonlineshopping.testcases;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;

import com.flipkartonlineshopping.configuration.ConfigProperty;
import com.flipkartonlineshopping.configuration.ManageProperty;
import com.flipkartonlineshopping.pageobject.BaseUIPage;
import com.flipkartonlineshopping.pageobject.UserLoginPage;

public class BasicRequirementTests extends AbstractTestNGSpringContextTests {
	
	@DataProvider(name = "TestObject")
    public Object[][] Test() {
        return new Object[][]{{new UserLoginPage()}};
    }
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProperty.class);
	ManageProperty config = context.getBean(ManageProperty.class);
	BaseUIPage baseUIPage = context.getBean(BaseUIPage.class);

}
