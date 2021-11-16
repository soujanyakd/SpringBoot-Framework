package com.flipkartonlineshopping.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

public class UserLoginPage extends BaseUIPage {

	private final By USER_NAME_TEXT_FIELD = By.xpath("//span[contains(text(),'Enter Email/Mobile number')]//parent::label//parent::div/input");
	private final By USER_PASSWORD_TEXT_FIELD = By.xpath("//span[contains(text(),'Enter Password')]//parent::label//parent::div/input");
	private final By LOGIN_SUBMIT_BUTTON = By.xpath("//button/span[contains(text(), 'Login')]");
	private final By USER_LOGIN_PAGE = By.xpath("//span[contains(text(), 'Login')]//parent::span//parent::div//parent::div");

	public UserLoginPage() {
		validateLoginPageNavigation();
	}

	public UserLoginPage enterUserName(String userName) {
		SeleniumActions.waitAndEnterText(USER_NAME_TEXT_FIELD, userName);
		return this;
	}

	public UserLoginPage enterUserPassword(String userPassword) {
		SeleniumActions.waitAndEnterText(USER_PASSWORD_TEXT_FIELD, userPassword);
		return this;
	}

	public HomePage submitUserLoginDetails() {
		SeleniumActions.waitAndClick(LOGIN_SUBMIT_BUTTON);
		return new HomePage();
	}

	private void validateLoginPageNavigation() {
		try {
			SeleniumActions.findElementLocator(USER_LOGIN_PAGE);
		} catch (StaleElementReferenceException e) {
			SeleniumActions.explicitWait(USER_LOGIN_PAGE);
		}
	}

}
