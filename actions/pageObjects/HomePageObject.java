package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new LoginPageObject(driver);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}

}
