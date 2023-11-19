package commons;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;
import javaOOP.BrowserList;
import javaOOP.ServerList;
import packageEnviroment.BrowserstackFactory;
import packageEnviroment.GridFactory;
import packageEnviroment.SourceLabFactory;

public abstract class BaseTest {
	private WebDriver driver;
	protected String projectPath = System.getProperty("user.dir");
	protected final Log log;

	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}

	public BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName, String url, String envName, String ipAddress, String portNumber, String osName, String osVersion) {
		switch (envName) {
		case "local":
			driver = new LocalFactory(browserName).createDriver();
			break;
		case "grid":
			driver = new GridFactory(browserName, ipAddress, portNumber).createDriver();
			break;
		case "browserStack":
			driver = new BrowserstackFactory(browserName, osName, osVersion).createDriver();
			break;
		case "soucelab":
			driver = new SourceLabFactory(browserName, osName).createDriver();
			break;
		default:
			break;
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getEnviromentValue(url));
		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_mansager_enabled", false);
			prefs.put("autofill.profile_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.USER_PAGE_URL);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("autofill.profile_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new BrowserNotSupport(browserName);
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(getEnviromentValue(appUrl));
		return driver;
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	protected String getEnviromentValue(String serverName) {
		String envUrl = null;
		ServerList server = ServerList.valueOf(serverName.toUpperCase());
		switch (server) {
		case DEV:
			envUrl = "";
			break;
		case TEST:
			envUrl = "";
			break;
		default:
			throw new RuntimeException("");
		}
		return envUrl;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);

	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}

}
