package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObjects;
import pageObjects.nopCommerce.admin.AdminLoginPageObjects;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Switch_Role_Login extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObjects adminLoginPage;
	private AdminDashboardPageObjects adminDashboardPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;

	String userEmailAddress, userPassword, adminEmailAddress, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userEmailAddress = "thi.hoang@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void Role_01_User() {
		userLoginPage = userHomePage.openLoginPage();
		// login as user role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isLogoutLinkDisplayed());
		// Home Page -> Customer infor
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		// Customer Info -> Click Logout -> Home Page
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);
		// User Home Page -> Open Admin Page -> login Page (admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		// Dashboard Page -> click logout -> login Page
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}

	@Test
	public void Role_02_Admin() {
		// Login Page (admin) -> open User url -> homepage (user)
		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		// homepage -> login page User
		userLoginPage = userHomePage.openLoginPage();

		// login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isLogoutLinkDisplayed());
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
