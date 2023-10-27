package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTitlePost(String titlePost) {
		waitForElementVisible(driver, AdminPostAddNewPUI.ADD_TITLE);
		sendkeysToElement(driver, AdminPostAddNewPUI.ADD_TITLE, titlePost);
	}

	public void enterToBodyPost(String bodyPost) {
		waitForElementVisible(driver, AdminPostAddNewPUI.ADD_BODY);
		clickToElement(driver, AdminPostAddNewPUI.ADD_BODY);
		sleepInSecond(1);
		sendkeysToElement(driver, AdminPostAddNewPUI.ADD_BODY, bodyPost);
	}

	public void clickToPublishButton() {
		waitForElementVisible(driver, AdminPostAddNewPUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String publishMessage) {
		waitForElementVisible(driver, AdminPostAddNewPUI.PUBLISHED_MESSAGE, publishMessage);
		return isElementDisplayed(driver, AdminPostAddNewPUI.PUBLISHED_MESSAGE, publishMessage);
	}

	public AdminPostSearchPO openSearchPostPageURL(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);

	}

}
