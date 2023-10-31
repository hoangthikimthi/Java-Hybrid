package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.github.javafaker.Faker;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;
import utilities.DataFaker;

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

public class Level_19_DataFaker extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInfoPageObject customerInfoPage;
	String validPassword, firstName, lastName, invalidEmail, exittingEmail, notFoundEmail, inValidPassword;
	DataFaker dataFaker;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new UserHomePageObject(driver);
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		invalidEmail = "afc@afc.com@.vn";
		exittingEmail = dataFaker.getEmail();
		notFoundEmail = "automation" + generateFakeNumber() + "@gmail.com";
		validPassword = dataFaker.getPassword();
		inValidPassword = "1234";
	}

	@Test
	public void Login_01_register() {
		log.info("Register - Steps 01: Navigate to 'Register' page");
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);

		log.info("Register - Steps 02: Enter Firstname textbox with value is '" + firstName + "'");
		registerPage.sendkeysToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Steps 03: Enter lastName textbox with value is '" + lastName + "'");
		registerPage.sendkeysToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Steps 04: Enter exittingEmail textbox with value is '" + exittingEmail + "'");
		registerPage.sendkeysToTextboxByID(driver, "Email", exittingEmail);

		log.info("Register - Steps 05: Enter validPassword textbox with value is '" + validPassword + "'");
		registerPage.sendkeysToTextboxByID(driver, "Password", validPassword);

		log.info("Register - Steps 06: Enter validPassword textbox with value is '" + validPassword + "'");
		registerPage.sendkeysToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register - Steps 07: Click to register button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Steps 08: Enter Firstname textbox with value is '" + firstName + "'");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Login_02_Login() {
		loginPage = homePage.openLoginPage();
		// loginPage.sendkeysEmailTextbox(exittingEmail);
		loginPage.sendkeysToTextboxByID(driver, "Email", exittingEmail);
		// loginPage.sendkeysPasswordTextbox(validPassword);
		loginPage.sendkeysToTextboxByID(driver, "Password", validPassword);
		// loginPage.clickToLoginButton();
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

	}

	@Test
	public void Login_03_MyAccount() {
		customerInfoPage = homePage.clickToMyAccountLink();
		// Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), exittingEmail);
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
