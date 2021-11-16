package com.flipkartonlineshopping.pageobject;

import org.openqa.selenium.By;

public class HomePage {

	private final By HOME_PAGE_SEARCH_TEXTBOX = By.xpath("//input[@placeholder='Search for products, brands and more']");
	private final By HOME_PAGE_SEARCH_BUTTON = By.xpath("//button[@type='submit']");
	private final By HOME_PAGE_SEARCH_FIELD = By.xpath("//form[@action=\"/search\"]");

	public HomePage() {
		validateHomePageNavigation();
	}

	public HomePage enterProductNameIntoSearchTextfield(String productName) {
		SeleniumActions.waitAndClick(HOME_PAGE_SEARCH_TEXTBOX);
		SeleniumActions.waitAndEnterText(HOME_PAGE_SEARCH_TEXTBOX, productName);
		return this;
	}

	public SearchResultPage searchUserEnteredProduct() {
		SeleniumActions.waitAndClick(HOME_PAGE_SEARCH_BUTTON);
		return new SearchResultPage();
	}
	
	private void validateHomePageNavigation() {
		try {
			SeleniumActions.findElementLocator(HOME_PAGE_SEARCH_FIELD);
		} catch (Exception e) {
			SeleniumActions.explicitWait(HOME_PAGE_SEARCH_FIELD);
		}
	}
}
