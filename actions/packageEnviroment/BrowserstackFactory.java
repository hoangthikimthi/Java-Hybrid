package packageEnviroment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class BrowserstackFactory {
	private WebDriver driver;
	private String browserName, osName, osVersion;

	public BrowserstackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os", osName);
		capability.setCapability("os_version", osVersion);
		capability.setCapability("browser", browserName);
		capability.setCapability("browser_version", "lastest");
		capability.setCapability("browserstack.debug", "true");
		capability.setCapability("project", "Orange HRM");
		capability.setCapability("resolution", "1920x1080");
		capability.setCapability("name", "Run on" + osName + "|" + osVersion + "|" + browserName);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROW_STACK_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
