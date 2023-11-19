package commons;

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

import exception.BrowserNotSupport;
import factoryBrowser.ChromeDriverMagager;
import factoryBrowser.FireFoxDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.IEDriverManager;
import factoryBrowser.OperaDriverManager;
import factoryBrowser.SafariDriverManager;
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
			driver = new FireFoxDriverManager().getBrowserDriver();
			break;
		case CHROME:
			driver = new ChromeDriverMagager().getBrowserDriver();
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case IE:
			driver = new IEDriverManager().getBrowserDriver();
			break;
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;
		case OPERA:
			driver = new OperaDriverManager().getBrowserDriver();
			break;
		default:
			throw new BrowserNotSupport(browserName);
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
