package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;
import reportConfig.ExtentManager;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
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

public class Level_15_allure extends BaseTest {
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

	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register(Method method) {
		registerPage = homePage.openRegisterPage();

		registerPage.senkeysToFirstNameTextbox(firstName);

		registerPage.senkeysToLastNameTextbox(lastName);

		registerPage.senkeysToEmailTextbox(exittingEmail);

		registerPage.senkeysToPasswordTextbox(validPassword);

		registerPage.senkeysToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your completed");
	}

	// @Description("Login to system")
	// @Severity(SeverityLevel.NORMAL)
	// @Test
	// public void User_02_Login(Method method) {
	// homePage = registerPage.clickToLogoutLinkAtUserPage(driver);
	// loginPage = homePage.openLoginPage();
	//
	// loginPage.sendkeysEmailTextbox(exittingEmail);
	//
	// loginPage.sendkeysPasswordTextbox(validPassword);
	//
	// homePage = loginPage.clickToLoginButton();
	//
	// Assert.assertFalse(homePage.isLogoutLinkDisplayed());
	//
	// }

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
