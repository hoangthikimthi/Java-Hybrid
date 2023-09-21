package com.jquery.dataable;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		homePage.openPagingByPageNumber("5");
		Assert.assertTrue(homePage.isPageNumberActive("5"));
		homePage.openPagingByPageNumber("6");
		Assert.assertTrue(homePage.isPageNumberActive("6"));
		homePage.openPagingByPageNumber("8");
		Assert.assertTrue(homePage.isPageNumberActive("8"));
	}

	// @Test
	public void Table_02_Enter_T0_Header() {
		// viết hàm refresh
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
	}

	// @Test
	public void Table_03_getAllRowValue() {
		// doc du lieu cu file country.txt ra
		// luu vao 1 List<String> = Expected value

		// actual value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();

		// Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}

	@Test
	public void Table_04_getAllRowValue() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(2);
		homePage.enterToTextboxByColumNameAtRowNumber("Company", "1", "IMIP");
		homePage.enterToTextboxByColumNameAtRowNumber("Contact Person", "1", "Thi");

		homePage.enterToDropdownByColumNameAtRowNumber("Country", "1", "Hong Kong");

		homePage.checkToCheckBoxByColumnNameAtRowNumber("NPO?", "2");

		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("NPO?", "1");

		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Move Down");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Move Up");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
