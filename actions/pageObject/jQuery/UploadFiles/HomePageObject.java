package pageObject.jQuery.UploadFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.jQuery.UploadFiles.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListElement(driver, HomePageUI.START_BUTTON);
		for (WebElement button : startButtons) {
			button.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileLinkUploadByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUI.FILE_NAME_LOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_LOADED_IMAGE, fileName);
	}

}
