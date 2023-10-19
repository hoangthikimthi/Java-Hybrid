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

	public void selectContryInDropdown() {
		clickToElement(driver, AddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDefautDropdown(driver, AddressPageUI.DYNAMIC_COUNTRY_VALUE, "Viet Nam", "Viet Nam");
	}

	public void selectContryInDropdown(WebDriver driver, String countryName) {
		waitForElementClickable(driver, AddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDefautDropdown(driver, AddressPageUI.COUNTRY_DROPDOWN, "Viet Nam");
	}
}
