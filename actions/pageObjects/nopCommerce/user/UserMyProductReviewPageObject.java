package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddProductReviewPageUI;
import pageUIs.nopCommerce.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductReviewTiTleDisplayed(WebDriver driver, String productReviewTitle) {
		return isElementDisplayed(driver, UserMyProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_TITLE, productReviewTitle);
	}

	public boolean isProductReviewTextDisplayed(WebDriver driver, String productReviewTitle, String productReviewText) {
		return isElementDisplayed(driver, UserMyProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_TEXT, productReviewTitle, productReviewText);
	}

	public boolean isProductReviewPointDisplayed(WebDriver driver, String productReviewTitle, String productReviewPoint) {
		return isElementDisplayed(driver, UserMyProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_POINT, productReviewTitle, productReviewPoint);
	}
}
