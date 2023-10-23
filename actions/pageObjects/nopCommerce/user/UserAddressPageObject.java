package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddAddressFormDisplayed() {
		waitForElementVisible(driver, AddressPageUI.FIRSTNAME_TEXTBOX);
		return isElementDisplayed(driver, AddressPageUI.FIRSTNAME_TEXTBOX);
	}

	public void selectItemFromDropdown(WebDriver driver, String dynamicValue, String textValue) {
		waitForElementClickable(driver, AddressPageUI.DYNAMIC_ADRESS_DROPDOWN, dynamicValue);
		selectItemInDefautDropdown(driver, AddressPageUI.DYNAMIC_ADRESS_DROPDOWN, textValue, dynamicValue);
	}

	public Object isInfoSaved(WebDriver driver, String id) {
		waitForElementVisible(driver, AddressPageUI.INFO_AREA);
		return getElementText(driver, AddressPageUI.DYNAMIC_INFO_VALUE, id);
	}

}
