package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPUI;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputUserNameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPUI.USERNAME_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPUI.USERNAME_TEXTBOX, adminUserName);

	}

	public void inputPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPUI.PASSWORD_TEXTBOX, adminPassword);

	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);

	}

}
