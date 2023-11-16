package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	// Windown(\\)/Mac/Linux
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";

	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";

	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";

	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";

	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final String REPORT_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "ExtentReportV2" + File.separator;

	// DataBase Account/ User/ Pass/ Port

	public static final String DB_DEV_URL = "";
	public static final String DB_DEV_USER = "";
	public static final String DB_DEV_PASS = "";

	public static final String DB_TEST_URL = "";
	public static final String DB_TEST_USER = "";
	public static final String DB_TEST_PASS = "";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;

	public static final String BROWSER_USERNAME = "automationfc";
	public static final String BROWSER_AUTOMATE_KEY = "aaaaaaaaaaaaaaa";
	public static final String BROW_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static final String SOUCE_USERNAME = "automationfc";
	public static final String SOUCE_AUTOMATE_KEY = "aaaaaaaaaaaaaaa";
	public static final String SOUCE_URL = "https://" + SOUCE_USERNAME + ":" + SOUCE_AUTOMATE_KEY + "@ONDEMAND.EU-CENTRAL-1.SAUCELABS.COM:443/wd/hub";

}
