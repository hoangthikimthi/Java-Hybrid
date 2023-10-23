package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddProductReviewPageUI;

public class UserAddProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserAddProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void markRattingPoint(WebDriver driver, String valuePoint) {
		waitForElementClickable(driver, UserAddProductReviewPageUI.RATTING_POIT_RADIO_BUTTON, valuePoint);
		clickToElement(driver, UserAddProductReviewPageUI.RATTING_POIT_RADIO_BUTTON, valuePoint);
	}

	public boolean addProductReviewPageDisplayed() {
		return isElementDisplayed(driver, UserAddProductReviewPageUI.TITLE_PAGE);
	}

	public boolean isProductReviewTiTleDisplayed(WebDriver driver, String productReviewTitle) {
		return isElementDisplayed(driver, UserAddProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_TITLE, productReviewTitle);
	}

	public boolean isProductReviewTextDisplayed(WebDriver driver, String productReviewTitle, String productReviewText) {
		return isElementDisplayed(driver, UserAddProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_TEXT, productReviewTitle, productReviewText);
	}

	// public boolean isProductReviewPointDisplayed(WebDriver driver, String productReviewTitle, String productReviewPoint) {
	// return isElementDisplayed(driver, UserAddProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_POINT, productReviewTitle, productReviewText);
	// }

}
