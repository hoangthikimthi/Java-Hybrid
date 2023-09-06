package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
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

public class Level_09_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserMyProductReviewPageObject myProductReviewPage;
	UserRewardPointPageObject rewardPointPage;

	String validPassword, firstName, lastName, invalidEmail, exittingEmail, notFoundEmail, inValidPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc.com@.vn";
		exittingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail = "automation" + generateFakeNumber() + "@gmail.com";
		validPassword = "12345a";
		inValidPassword = "1234";
		// loginPage = new LoginPageObject(driver);
		// registerPage = new RegisterPageObject(driver);

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.senkeysToFirstNameTextbox(firstName);
		registerPage.senkeysToLastNameTextbox(lastName);
		registerPage.senkeysToEmailTextbox(exittingEmail);
		registerPage.senkeysToPasswordTextbox(validPassword);
		registerPage.senkeysToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToHomePageLink();

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void User_03_MyAccount() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void User_04_SwitchPage() {
		// customer Info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openMyAccountPageByPageName(driver, "Reward points");
		// Reward Point -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openMyAccountPageByPageName(driver, "Addresses");
		// Address -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openMyAccountPageByPageName(driver, "Reward points");
		// Reward Point -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openMyAccountPageByPageName(driver, "My product reviews");
		// My product review -> address
		addressPage = (UserAddressPageObject) myProductReviewPage.openMyAccountPageByPageName(driver, "Addresses");
	}

	@Test
	public void User_05_Dynamic_Page() {
		// customer Info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		// My product review -> address
		addressPage = myProductReviewPage.openAddressPage(driver);
	}

	@Test
	public void User_04_Switch_Role() {
		// role user-> admin
		// admin->user
	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
