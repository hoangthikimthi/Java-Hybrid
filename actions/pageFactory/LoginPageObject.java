package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(id = "Email-error")
	private WebElement emailError;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement unsucessfullErrorMessage;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getEmailErrorMessageTextbox() {
		waitForElementVisible(driver, emailError);
		return getElementText(driver, emailError);
	}

	public void sendkeysEmailTextbox(String textValue) {
		waitForElementVisible(driver, emailTextbox);
		senkeysToElement(driver, emailTextbox, textValue);
	}

	public String getErrorMessageUnsuccessfulLogin() {
		waitForElementVisible(driver, unsucessfullErrorMessage);
		return getElementText(driver, unsucessfullErrorMessage);
	}

	public void sendkeysPasswordTextbox(String textValue) {
		waitForElementVisible(driver, passwordTextbox);
		senkeysToElement(driver, passwordTextbox, textValue);
	}

}
