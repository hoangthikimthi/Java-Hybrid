package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import nopcommerce.HomePageUI;

public class HomePageObject extends BasePageFactory {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageUI

	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(css = "a[class='ico-logout']")
	private WebElement logoutLink;

	// Page object/action
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return new LoginPageObject(driver);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

}
