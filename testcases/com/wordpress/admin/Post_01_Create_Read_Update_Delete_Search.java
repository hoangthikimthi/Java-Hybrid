package com.wordpress.admin;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.admin.AdminDashboardPO;
import pageObject.wordpress.admin.AdminLoginPO;
import pageObject.wordpress.admin.AdminPostAddNewPO;
import pageObject.wordpress.admin.AdminPostSearchPO;
import pageObject.wordpress.admin.PageGeneratorManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostAddNewPO adminPostAddNewPage;
	AdminPostSearchPO adminPostSearchPage;
	String searchPostUrl;
	String adminUserName = "editor";
	String adminPassword = "Kimthi92#";
	int randomeNumber = generateFakeNumber();
	String titlePost = "Live Coding TiTle" + randomeNumber;
	String bodyPost = "Live Coding Body" + randomeNumber;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-conditon - Step 01: Open Brower and adminURL");
		driver = getBrowserDriver(browserName, url);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-conditon - Step 02: Enter to UserName textbox with value: " + adminUserName);
		adminLoginPage.inputUserNameTextbox(adminUserName);

		log.info("Pre-conditon - Step 03: Enter to PassWord textbox with value: " + adminPassword);
		adminLoginPage.inputPasswordTextbox(adminPassword);

		log.info("Pre-conditon - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Create_New_Post() {

		log.info("Create_New_Post - Step 01: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostLinkMenu();
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create_New_Post - Step 02: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create_New_Post - Step 03: Enter to Title");
		adminPostAddNewPage.enterToTitlePost(titlePost);

		log.info("Create_New_Post - Step 04: Enter to Body");
		adminPostAddNewPage.enterToBodyPost(bodyPost);

		log.info("Create_New_Post - Step 05: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create_New_Post - Step 06: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void TC_02_Search() {
		log.info("Search Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageURL(searchPostUrl);
		// open searchPostUrl
	}

	@Test
	public void TC_03_View_Post() {

	}

	@Test
	public void TC_04_Edit_Post() {
	}

	@Test
	public void TC_05_Delete_Post() {

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}