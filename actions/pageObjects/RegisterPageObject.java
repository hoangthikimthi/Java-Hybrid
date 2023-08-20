package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.HomePageUI;
import nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR);
		
	}

	public String getErorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR);
	}

	public String getErorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR);
	}

	public String getErorMessageConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}

	public String getErorMessageEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	
	}

	public void senkeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void senkeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void senkeysToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void senkeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

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

}
