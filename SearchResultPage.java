package com.flipkartonlineshopping.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BaseUIPage {

	public static String productDetails;
	public String[] productList = new String[] { "Vivo", "Oppo" };

	private final By SEARCH_PRODUCT_RESULTS = By.xpath("//div[@class='_4rR01T']");
	private final By HOME_PAGE_CART_ICON = By.xpath("//span[text()=\"Cart\"]");
	private final By SEARCH_RESULT_PAGE = By.xpath("//span[text()=\"Filters\"]");
	
	List<WebElement> listOfProducts = driver.findElements(SEARCH_PRODUCT_RESULTS);
	
	public SearchResultPage() {
		validateSearchResultPageNavigation();
	}

	public ProductDetailsPage viewProduct(String productName) {
		int productInProductList = 0;
		try {
			if (validateSearchProductResult(productName) == true) {
				productDetails = listOfProducts.get(0).getText();
				listOfProducts.get(0).click();
			}
		} catch (Exception e) {
			if (productInProductList < 2) {
				driver.navigate().back();
				HomePage homePage = new HomePage();
				homePage.enterProductNameIntoSearchTextfield(productList[productInProductList])
						.searchUserEnteredProduct();
				viewProduct(productList[productInProductList]);
				productInProductList++;
			} else {
				System.out.println(e);
			}
		}
		return new ProductDetailsPage();
	}

	public ShoppingCartPage viewProductFromCart() {
		SeleniumActions.waitAndClick(HOME_PAGE_CART_ICON);
		return new ShoppingCartPage();
	}
	
	private boolean validateSearchProductResult(String productName) {
		int productCount = 0;
		for (int i = 0; i < listOfProducts.size(); i++) {
			if (listOfProducts.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
				productCount++;
			}
		}
		return (productCount == listOfProducts.size() ? true : false);
	}
	
	private void validateSearchResultPageNavigation() {
		try {
			SeleniumActions.findElementLocator(SEARCH_RESULT_PAGE);
		} catch (Exception e) {
			SeleniumActions.explicitWait(SEARCH_RESULT_PAGE);
		}
	}
}
