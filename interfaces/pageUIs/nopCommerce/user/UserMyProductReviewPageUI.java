package pageUIs.nopCommerce.user;

public class UserMyProductReviewPageUI {
	public static final String DYNAMIC_PRODUCT_REVIEW_TITLE = "xpath=//div[@class='review-title']/strong[text()='%s']";
	public static final String DYNAMIC_PRODUCT_REVIEW_TEXT = "xpath=//div[@class='review-title']/strong[text()='%s']//ancestor::div[@class='product-review-item']//div[contains(text(),'%s')]";
	public static final String DYNAMIC_PRODUCT_REVIEW_POINT = "xpath=//div[@class='review-title']/strong[text()='%s']//ancestor::div[@class='product-review-item']//div[@style='%s']";

}
