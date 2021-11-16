package com.flipkartonlineshopping.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.flipkartonlineshopping.pageobject.UserLoginPage;

public class FlipkartOnlineShoppingTests extends BasicRequirementTests {
	
	@BeforeClass
	public void setupTest() {
		baseUIPage.setupChromeDriver()
				.setupChromePage()
				.navigateToLoginPage(config.getUrl());
	}
	

	@Test(dataProvider = "TestObject")
	public void productPurchaseByValidUserTestCase(UserLoginPage userLoginPage) {
		userLoginPage.enterUserName(config.getUserName())
				.enterUserPassword(config.getPassword())
				.submitUserLoginDetails()
				.enterProductNameIntoSearchTextfield(config.getProductName())
				.searchUserEnteredProduct()
				.viewProduct(config.getProductName())
				.addToTheCart()
				.viewProductFromCart()
				.validateProductPresentInTheCart();
	}
}
