package javaBasic;

public class Topic_14_StringFormat {
	public static String ADDRESSES_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String REWARD_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";

	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";

	public static String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";

	public static String DINAMIC_SIDEBAR_BY_PAGE_NAME = "//div[contains(@class,'%s']";

	public static String DINAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s']//a[text()='%s'";

	public static void main(String[] args) {
		clickToSideBarLink(DINAMIC_LINK_BY_PAGE_NAME, "Addresses", "Customer info");
		clickToSideBarLink(DINAMIC_LINK_BY_PAGE_NAME, "Reward points", "Addresses");
		clickToSideBarLink(DINAMIC_LINK_BY_PAGE_NAME, "My product reviews", "My product reviews");
		clickToSideBarLink(DINAMIC_LINK_BY_PAGE_NAME, "Customer info", "Reward Point");
	}

	public static void clickToSideBarLink(String locator) {
		System.out.print("Clickto: " + locator);
	}

	public static void clickToSideBarLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Clickto: " + locator);
	}

}
