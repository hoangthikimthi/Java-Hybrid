package pageUIs.wordpress.user;

public class UserPostDetailPUI {
	public static final String POST_TITLE = "XPATH=//header[@class='entry-header']/h1[text()='%s']";
	public static final String POST_BODY = "XPATH=//div[@class='entry-content']/p[text()='%s']";
	public static final String POST_TIME = "XPATH=//div[@class='entry-meta']//a/time[text()='%s']";

	public static final String POST_AUTHOR = "XPATH=//div[@class='entry-meta']//span//a[text()='%s']";
}
