package com.wordpress.admin;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostAddNewPO adminPostAddNewPage;
	AdminPostSearchPO adminPostSearchPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailpage;
	String searchPostUrl, adminUrl, userUrl;
	String adminUserName = "editor";
	String adminPassword = "Kimthi92#";
	String authorName = "editor editor";
	int randomeNumber = generateFakeNumber();
	String postTitle = "Live Coding TiTle" + randomeNumber;
	String postBody = "Live Coding Body" + randomeNumber;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "adminUrl", "userUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String userUrl) {
		log.info("Pre-conditon - Step 01: Open Brower and adminURL");
		this.adminUrl = adminUrl;
		this.userUrl = userUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
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
		adminPostAddNewPage.enterToTitlePost(postTitle);

		log.info("Create_New_Post - Step 04: Enter to Body");
		adminPostAddNewPage.enterToBodyPost(postBody);

		log.info("Create_New_Post - Step 05: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create_New_Post - Step 06: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void TC_02_Search_And_View_Post() {
		log.info("Search View Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageURL(searchPostUrl);
		// open searchPostUrl
		log.info("Search View Post - Step 02: Input to search textbox by value: " + postTitle);
		adminPostSearchPage.sendkeysToSearchTextbox(postTitle);

		log.info("Search View Post - Step 03: Click to 'Search Post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search View Post - Step 04: Verify search table contains: " + postTitle + authorName);
		adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle);
		adminPostSearchPage.isPostSearchTableDisplayed("author", authorName);

		log.info("Search View Post - Step 05: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserPageURL(driver, this.userUrl);

		log.info("Search View Post - Step 06: Input to search textbox by value: " + postTitle);
		userHomePage.sendkeysToSearchTextbox(postTitle);

		log.info("Search View Post - Step 07: Click to 'Search' button");
		userHomePage.clickToSearchPostButton();

		log.info("Search View Post - Step 08: Verify Post infor displayed at Home page");
		verifyTrue(userHomePage.isPostTitleDisplayed(postTitle));
		verifyTrue(userHomePage.isPostBodyDisplayed(postBody));
		verifyTrue(userHomePage.isPostAuthorDisplayed(authorName));
		verifyTrue(userHomePage.isPostCurrentDayDisplayed(currentDay));

		log.info("Search View Post - Step 09: Click to Post title");
		userPostDetailpage = userHomePage.clickToPostTiTle(postTitle);

		log.info("Search View Post - Step 10: Verify Post info is displayed at Post detail page");
		verifyTrue(userPostDetailpage.isPostTitleDisplayed(postTitle));
		verifyTrue(userPostDetailpage.isPostBodyDisplayed(postBody));
		verifyTrue(userPostDetailpage.isPostAuthorDisplayed(authorName));
		verifyTrue(userPostDetailpage.isPostCurrentDayDisplayed(currentDay));

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