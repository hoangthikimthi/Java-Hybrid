package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.user.UserHomePUI;
import pageUIs.wordpress.user.UserPostDetailPUI;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	protected UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayed(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, UserPostDetailPUI.POST_TITLE, postTitle);
	}

	public boolean isPostBodyDisplayed(String postBody) {
		waitForElementVisible(driver, UserPostDetailPUI.POST_BODY, postBody);
		return isElementDisplayed(driver, UserPostDetailPUI.POST_BODY, postBody);
	}

	public boolean isPostAuthorDisplayed(String authorName) {
		waitForElementVisible(driver, UserPostDetailPUI.POST_AUTHOR, authorName);
		return isElementDisplayed(driver, UserPostDetailPUI.POST_AUTHOR, authorName);

	}

	public boolean isPostCurrentDayDisplayed(String currentDay) {
		waitForElementVisible(driver, UserPostDetailPUI.POST_TIME, currentDay);
		return isElementDisplayed(driver, UserPostDetailPUI.POST_TIME, currentDay);

	}

}
