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

public class Level_17_Custom_Close_Browser extends BaseTest {
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
	}

	@Test
	public void Login_01_register() {
		log.info("Register - Steps 01: Navigate to 'Register' page");
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		log.info("Register - Steps 02: Enter Firstname textbox with value is '" + firstName + "'");
		registerPage.senkeysToFirstNameTextbox(firstName);

		log.info("Register - Steps 03: Enter lastName textbox with value is '" + lastName + "'");
		registerPage.senkeysToLastNameTextbox(lastName);

		log.info("Register - Steps 04: Enter exittingEmail textbox with value is '" + exittingEmail + "'");
		registerPage.senkeysToEmailTextbox(exittingEmail);

		log.info("Register - Steps 05: Enter validPassword textbox with value is '" + validPassword + "'");
		registerPage.senkeysToPasswordTextbox(validPassword);

		log.info("Register - Steps 06: Enter validPassword textbox with value is '" + validPassword + "'");
		registerPage.senkeysToConfirmPasswordTextbox(validPassword);

		log.info("Register - Steps 07: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Steps 08: Enter Firstname textbox with value is '" + firstName + "'");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

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

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowserDriver();
	}

}
