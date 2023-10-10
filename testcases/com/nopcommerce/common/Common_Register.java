package com.nopcommerce.common;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
import org.testng.annotations.AfterTest;

public class Common_Register extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	public static String firstName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Thi";
		lastName = "Hoang";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "12345a";

	}

	@Test
	public void Login_01_register() {
		log.info("Register - Steps 01: Navigate to 'Register' page");
		homePage.openRegisterPage();
		registerPage = homePage.openRegisterPage();

		log.info("Register - Steps 02: Enter Firstname textbox with value is '" + firstName + "'");
		registerPage.senkeysToFirstNameTextbox(firstName);

		log.info("Register - Steps 03: Enter lastName textbox with value is '" + lastName + "'");
		registerPage.senkeysToLastNameTextbox(lastName);

		log.info("Register - Steps 04: Enter exittingEmail textbox with value is '" + emailAddress + "'");
		registerPage.senkeysToEmailTextbox(emailAddress);

		log.info("Register - Steps 05: Enter validPassword textbox with value is '" + password + "'");
		registerPage.senkeysToPasswordTextbox(password);

		log.info("Register - Steps 06: Enter validPassword textbox with value is '" + password + "'");
		registerPage.senkeysToConfirmPasswordTextbox(password);

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

	@AfterTest()
	public void afterClass() {
		driver.quit();
	}

}
