package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESSES_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String REWARD_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";

	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";

	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String LOGOUT_LINK_AS_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGIN_LINK_AS_USER = "xpath=//a[@class='ico-login']";
	public static final String LOGOUT_LINK_AS_ADMIN = "xpath=//a[text()='Logout']";

	public static final String DYNAMIC_MY_ACCOUNT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";

	public static final String DYNAMIC_TEXBOX_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_AREA_ID = "xpath=//textarea[@id='%s']";
	public static final String DYNAMIC_BUTTON_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_VALUE = "xpath=//input[@id='%s']";

	public static final String DYNAMIC_RADIO_ID = "xpath=//input[@id='%s']";
	public static final String MESSAGE_TEXT = "xpath=//p[text()='%s']";
}
