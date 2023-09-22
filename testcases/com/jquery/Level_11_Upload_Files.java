package com.jquery;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.UploadFiles.HomePageObject;
import pageObject.jQuery.UploadFiles.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	String file1 = "1.jpeg";
	String file2 = "2.jpeg";
	String file3 = "3.jpeg";
	String file4 = "4.jpeg";
	String[] files = { file1, file2, file3, file4 };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_UploadFile_01File() {
		homePage.uploadMultipleFiles(driver, file1);
		Assert.assertTrue(homePage.isFileLinkUploadByName(file1));
		Assert.assertTrue(homePage.isFileLoadedByName(file1));
		homePage.clickToStartButton();
	}

	@Test
	public void TC_02_UploadFile_MultiFiles() {
		homePage.uploadMultipleFiles(driver, files);
	}

	@Test
	public void Table_03_getAllRowValue() {
	}

	@Test
	public void Table_04_getAllRowValue() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
