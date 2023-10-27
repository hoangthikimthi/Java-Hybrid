package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.wordpress.admin.AdminDashboardPUI;

public class AdminDashboardPO extends BasePage {
	private WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostLinkMenu() {
		waitForElementClickable(driver, AdminDashboardPUI.POSTS_MENU_LINK);
		clickToElement(driver, AdminDashboardPUI.POSTS_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
