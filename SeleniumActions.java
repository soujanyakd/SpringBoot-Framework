package com.flipkartonlineshopping.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActions extends BaseUIPage {
	
	public static void explicitWait(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	
	public static void waitAndEnterText(By elementLocator, String value) {
		explicitWait(elementLocator);
		driver.findElement(elementLocator).sendKeys(value);
	}
	
	public static void waitAndClick(By elementLocator) {
		explicitWait(elementLocator);
		driver.findElement(elementLocator).click();
	}
	
	public static void findElementLocator(By elementLocator) {
		driver.findElement(elementLocator);
	}
	
	public static void switchWindow(String newWindow) {
		driver.switchTo().window(newWindow);
	}

}
