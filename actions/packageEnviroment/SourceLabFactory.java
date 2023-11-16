package packageEnviroment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class SourceLabFactory {
	private WebDriver driver;
	private String browserName, osName;

	public SourceLabFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browser", browserName);
		capability.setCapability("name", "Run on" + osName + browserName);

		Map<String, Object> sourceOptions = new HashMap<>();
		if (osName.contains("WinDows")) {
			sourceOptions.put("screenResolution", "1920x1080");
		} else {
			sourceOptions.put("screenResolution", "1920x1440");
		}
		capability.setCapability("souce:options", sourceOptions);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SOUCE_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
