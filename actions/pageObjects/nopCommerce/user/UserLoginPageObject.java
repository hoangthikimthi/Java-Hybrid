package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		// return new HomePageObject(driver);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getEmailErrorMessageTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR);
	}

	public void sendkeysEmailTextbox(String textValue) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, textValue);
	}

	public String getErrorMessageUnsuccessfulLogin() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULL_LOGIN_ERROR);
		return getElementText(driver, LoginPageUI.UNSUCCESSFULL_LOGIN_ERROR);
	}

	public void sendkeysPasswordTextbox(String textValue) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXBOX);
		senkeysToElement(driver, LoginPageUI.PASSWORD_TEXBOX, textValue);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		sendkeysEmailTextbox(emailAddress);
		sendkeysPasswordTextbox(password);
		return clickToLoginButton();
	}

}
