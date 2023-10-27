package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.wordpress.UserHomePO;
import pageUIs.wordpress.admin.AdminPostSearchPUI;

public class AdminPostSearchPO extends BasePage {
	private WebDriver driver;

	protected AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void sendkeysToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPUI.SEARCH_TEXTBOX);
		sendkeysToElement(driver, AdminPostSearchPUI.SEARCH_TEXTBOX, postTitle);

	}

	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.SEARCH_POSTS_BUTTON);
	}

	public boolean isPostSearchTableDisplayed(String idHeader, String postTitle) {
		int elementSize = getElementSize(driver, AdminPostSearchPUI.TABLE_HEADER_INDEX_BY_ID, idHeader) + 1;
		waitForElementVisible(driver, AdminPostSearchPUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(elementSize), postTitle);
		return isElementDisplayed(driver, AdminPostSearchPUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(elementSize), postTitle);

	}

}
