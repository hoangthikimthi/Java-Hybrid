package pageObject.wordpress;

import org.openqa.selenium.WebDriver;
import pageObject.wordpress.PageGeneratorManager;
import commons.BasePage;

import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObjects extends BasePage {
	WebDriver driver;

	public AdminLoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String emailAddress) {
		waitForAllElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForAllElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForAllElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPO loginAsAdmin(String emailAddress, String password) {
		inputToUsernameTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
