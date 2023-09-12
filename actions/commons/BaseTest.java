package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaOOP.BrowserList;
import javaOOP.ServerList;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("please enter the correct Browser name!");
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.USER_PAGE_URL);
		return driver;
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
}
