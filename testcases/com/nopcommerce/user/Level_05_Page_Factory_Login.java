package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Page_Factory_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String validPassword, firstName, lastName, invalidEmail, exittingEmail, notFoundEmail, inValidPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new HomePageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc.com@.vn";
		exittingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail = "automation" + generateFakeNumber() + "@gmail.com";
		validPassword = "12345a";
		inValidPassword = "1234";

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.senkeysToFirstNameTextbox(firstName);
		registerPage.senkeysToLastNameTextbox(lastName);
		registerPage.senkeysToEmailTextbox(exittingEmail);
		registerPage.senkeysToPasswordTextbox(validPassword);
		registerPage.senkeysToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_01_EmptyData() throws InterruptedException {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		Thread.sleep(5000);
		Assert.assertEquals(loginPage.getEmailErrorMessageTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_InvalidEmail() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendkeysEmailTextbox("thi.hoang");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessageTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_UnredisteredEmail() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.sendkeysEmailTextbox("thihoang1122334@gmail.com");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_EmptyPassword() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_WrongPassword() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(inValidPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_ValidLogin() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
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
