package pageObject.facebook;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.jQuery.UploadFiles.HomePageUI;
import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreatNewAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREAT_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREAT_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public void sendkeyToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public boolean isEmailTextboxUnDisplayed() {

		return isElementUndisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public void clickToCloseButtonInCreateAccountPopup() {
		waitForElementVisible(driver, LoginPageUI.CLOSE_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_BUTTON);

	}

}
