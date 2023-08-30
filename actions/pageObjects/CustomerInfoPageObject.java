package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {

		waitForElementInVisible(driver, CustomerInfoPageUI.MY_ACCOUNT_TITLE);
		return isElementDisplayed(driver, CustomerInfoPageUI.MY_ACCOUNT_TITLE);
	}
}
