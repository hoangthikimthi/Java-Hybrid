package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import nopcommerce.HomePageUI;
import nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@name='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameError;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameError;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordError;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordError;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailError;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMassage;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement emailExitMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameError);
		return getElementText(driver, firstNameError);

	}

	public String getErorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameError);
		return getElementText(driver, lastNameError);
	}

	public String getErorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordError);
		return getElementText(driver, passwordError);
	}

	public String getErorMessageConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordError);
		return getElementText(driver, confirmPasswordError);
	}

	public String getErorMessageEmailTextbox() {
		waitForElementVisible(driver, emailError);
		return getElementText(driver, emailError);

	}

	public void senkeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		senkeysToElement(driver, firstNameTextbox, firstName);

	}

	public void senkeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		senkeysToElement(driver, lastNameTextbox, lastName);
	}

	public void senkeysToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		senkeysToElement(driver, emailTextbox, email);
	}

	public void senkeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeysToElement(driver, passwordTextbox, password);
	}

	public void senkeysToConfirmPasswordTextbox(String confrirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		senkeysToElement(driver, confirmPasswordTextbox, confrirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMassage);
		return getElementText(driver, registerSuccessMassage);

	}

	public String getErorMessageExitEmail() {
		waitForElementVisible(driver, emailExitMessage);
		return getElementText(driver, emailExitMessage);

	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
