package packageEnviroment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import commons.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory implements EnvironmentFactory {
	private WebDriver driver;
	private String browserName, ipAddress, portNumber;

	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	public WebDriver createDriver() {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);

			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.merge(capability);

		} else if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);

			ChromeOptions fOptions = new ChromeOptions();
			fOptions.merge(capability);

		} else if (browser == Browser.OPERA) {
			WebDriverManager.operadriver().setup();
			capability = DesiredCapabilities.opera();
			capability.setBrowserName("opera");
			capability.setPlatform(Platform.WINDOWS);

			OperaOptions fOptions = new OperaOptions();
			fOptions.merge(capability);
		} else if (browser == Browser.SAFARI) {
			WebDriverManager.safaridriver().setup();
			capability = DesiredCapabilities.safari();
			capability.setBrowserName("safari");
			capability.setPlatform(Platform.WINDOWS);

			SafariOptions fOptions = new SafariOptions();
			fOptions.merge(capability);
		} else {
			throw new RuntimeException("Please input valid browser name value!");
		}

		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

}
