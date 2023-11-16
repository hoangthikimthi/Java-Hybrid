package packageEnviroment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;
import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;
import javaOOP.BrowserList;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		// Map<String, Object> prefs = new HashMap<String, Object>();
		// prefs.put("profile.default_content_setting_values.notifications", 2);
		// prefs.put("credentials_enable_service", false);
		// prefs.put("profile.password_manager_enabled", false);
		// prefs.put("autofill.profile_enabled", false);
		// ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("prefs", prefs);
		// options.addArguments("--disable-notifications");
		// options.addArguments("--incognito");
		// options.setExperimentalOption("useAutomationExtension", false);
		// options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		// driver = new ChromeDriver(options);

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		case OPERA:
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			throw new BrowserNotSupport(browserName);
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
