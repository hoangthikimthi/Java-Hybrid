package com.facebook;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;

public class Level_12_Element_Display_Undisplay extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreatNewAccountButton();
		verifyTrue(loginPage.isEmailTextboxDisplayed());
	}

	///
	@Test
	public void TC_02_Verify_Element_UnDisplayed_In_Dom() {
		loginPage.sendkeyToEmailTextbox("automationFC@gmail.com");
		verifyTrue(loginPage.isConfirmEmailTextboxDisplayed());

		loginPage.sendkeyToEmailTextbox("");
		sleepInSecond(2);
		verifyFalse(loginPage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void TC_03_Verify_Element_UnDisplayed_Not_In_Dom() {
		loginPage.clickToCloseButtonInCreateAccountPopup();
		sleepInSecond(2);
		verifyTrue(loginPage.isEmailTextboxUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
