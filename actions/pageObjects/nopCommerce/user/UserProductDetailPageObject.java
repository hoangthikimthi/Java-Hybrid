package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserAddProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getAddproductReviewPage(driver);
	}

	public boolean isProductDetailPageDisplayed() {
		return isElementDisplayed(driver, UserProductDetailPageUI.PRODUCT_NAME);
	}

}
