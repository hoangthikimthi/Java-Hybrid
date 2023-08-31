package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {

		waitForElementInVisible(driver, CustomerInfoPageUI.MY_ACCOUNT_TITLE);
		return isElementDisplayed(driver, CustomerInfoPageUI.MY_ACCOUNT_TITLE);
	}

}
