package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Objects_02_Login extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String validPassword;
	String firstName;
	String lastName;
	String invalidEmail;
	String exittingEmail;
	String notFoundEmail;
	String inValidPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new UserHomePageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc.com@.vn";
		exittingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail = "automation" + generateFakeNumber() + "@gmail.com";
		validPassword = "12345a";
		inValidPassword = "1234";
		// loginPage = new LoginPageObject(driver);
		// registerPage = new RegisterPageObject(driver);

		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);
		registerPage.senkeysToFirstNameTextbox(firstName);
		registerPage.senkeysToLastNameTextbox(lastName);
		registerPage.senkeysToEmailTextbox(exittingEmail);
		registerPage.senkeysToPasswordTextbox(validPassword);
		registerPage.senkeysToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		// registerPage.clickToLogoutLink();
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_EmptyData() throws InterruptedException {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		Thread.sleep(5000);
		Assert.assertEquals(loginPage.getEmailErrorMessageTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_InvalidEmail() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.sendkeysEmailTextbox("thi.hoang");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessageTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_UnredisteredEmail() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		loginPage.sendkeysEmailTextbox("thihoang1122334@gmail.com");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_EmptyPassword() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_WrongPassword() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(inValidPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_ValidLogin() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		homePage = new UserHomePageObject(driver);
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
