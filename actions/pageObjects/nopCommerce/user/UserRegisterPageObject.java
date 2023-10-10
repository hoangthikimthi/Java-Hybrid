package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Get Eror Message At FirstName Textbox")
	public String getErorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR);
	}

	@Step("Get Eror Message At LastName Textbox")
	public String getErorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR);
	}

	@Step("Get Eror Message At Password Textbox")
	public String getErorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR);
	}

	@Step("get Eror Message Confirm Password Textbox")
	public String getErorMessageConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}

	@Step("get Eror Message Email Textbox")
	public String getErorMessageEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}

	@Step("Enter to Firstname Textbox {0}")
	public void senkeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	@Step("Enter to Lasttname Textbox {0}")
	public void senkeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	@Step("Enter to Email Textbox {0}")
	public void senkeysToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Enter to Password Textbox {0}")
	public void senkeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to ConfrirmPassword Textbox {0}")
	public void senkeysToConfirmPasswordTextbox(String confrirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confrirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MASSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MASSAGE);

	}

	public String getErorMessageExitEmail() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EXIT_MASSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_EXIT_MASSAGE);

	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);

	}

	public UserHomePageObject clickToHomePageLink() {
		waitForElementClickable(driver, RegisterPageUI.IMG_HOME_LINK);
		clickToElement(driver, RegisterPageUI.IMG_HOME_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
