package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager implements IBrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.BROWSER_LOG_PATH);
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FILE);
		options.addPreference("browser.download.userDowloadDir", true);
		options.addPreference("pdfjs.disabled", "true");
		return new FirefoxDriver(options);
	}

}
