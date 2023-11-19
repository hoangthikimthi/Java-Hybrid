package factoryBrowser;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager implements IBrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		if (!IS_OS_MAC) {
			throw new BrowserNotSupportedException("SAFARI is not supported on" + System.getProperty("os.name"));
		}
		SafariOptions options = new SafariOptions();
		return new SafariDriver(options);
	}

}
