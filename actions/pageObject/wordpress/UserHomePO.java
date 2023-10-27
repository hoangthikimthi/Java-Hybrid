package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.user.UserHomePUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	protected UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserPostDetailPO clickToPostTiTle(String postTitle) {
		waitForElementVisible(driver, UserHomePUI.POST_TITLE, postTitle);
		clickToElement(driver, UserHomePUI.POST_TITLE, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public void sendkeysToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, UserHomePUI.SEARCH_TEXTBOX, postTitle);
		sendkeysToElement(driver, UserHomePUI.SEARCH_TEXTBOX, postTitle);

	}

	public void clickToSearchPostButton() {
		waitForElementVisible(driver, UserHomePUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePUI.SEARCH_BUTTON);
	}

	public boolean isPostTitleDisplayed(String postTitle) {
		waitForElementVisible(driver, UserHomePUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, UserHomePUI.POST_TITLE, postTitle);
	}

	public boolean isPostBodyDisplayed(String postBody) {
		waitForElementVisible(driver, UserHomePUI.POST_BODY, postBody);
		return isElementDisplayed(driver, UserHomePUI.POST_BODY, postBody);
	}

	public boolean isPostAuthorDisplayed(String authorName) {
		waitForElementVisible(driver, UserHomePUI.EDITOR_NAME, authorName);
		return isElementDisplayed(driver, UserHomePUI.EDITOR_NAME, authorName);

	}

	public boolean isPostCurrentDayDisplayed(String currentDay) {
		waitForElementVisible(driver, UserHomePUI.DATE_TIME, currentDay);
		return isElementDisplayed(driver, UserHomePUI.DATE_TIME, currentDay);

	}

}
