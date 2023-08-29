package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Switch_Page_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	String validPassword, firstName, lastName, invalidEmail, exittingEmail, notFoundEmail, inValidPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
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
		registerPage = homePage.clickToRegisterLink();

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
		loginPage = homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void User_03_MyAccount() {

	}

	@Test
	public void User_04_SwitchPage() {
		loginPage = homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_WrongPassword() {
		loginPage = homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(inValidPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_ValidLogin() {
		loginPage = homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

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
