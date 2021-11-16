package com.flipkartonlineshopping.pageobject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class ProductDetailsPage extends BaseUIPage {

	private final By ADD_TO_CART_BUTTON = By.xpath("//button[text()='ADD TO CART']");
	
	String MainWindow;
	
	public ProductDetailsPage() {
		validateProductDetailsPageNavigation();
	}

	public SearchResultPage addToTheCart() {
		SeleniumActions.waitAndClick(ADD_TO_CART_BUTTON);
		SeleniumActions.switchWindow(MainWindow);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return new SearchResultPage();
	}

	private void validateProductDetailsPageNavigation() {
		this.MainWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		Iterator<String> childWindow = childWindows.iterator();
		while (childWindow.hasNext()) {
			String newWindow = childWindow.next();
			try {
				if (!MainWindow.equalsIgnoreCase(newWindow)) {
					SeleniumActions.switchWindow(newWindow);
					SeleniumActions.findElementLocator(ADD_TO_CART_BUTTON);
				}
			} catch (Exception e) {
				SeleniumActions.explicitWait(ADD_TO_CART_BUTTON);
			}
		}
	}
	
}
