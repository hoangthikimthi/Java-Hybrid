package com.nopcommerce.user;

import org.testng.annotations.Test;

import nopcommerce.HomePageUI;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Objects_02_Login {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String emailAdress;
	String password;
	Alert alert;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);

		emailAdress = "automation" + generateFakeNumber() + "@gmail.com";
		password = "12345a";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		homePage.clickToRegisterLink();

		registerPage.senkeysToFirstNameTextbox("thi");
		registerPage.senkeysToLastNameTextbox("hoang");
		registerPage.senkeysToEmailTextbox(emailAdress);
		registerPage.senkeysToPasswordTextbox(password);
		registerPage.senkeysToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		// registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_EmptyData() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessageTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_InvalidEmail() {
		homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox("thi.hoang");
		loginPage.clickToLoginButton();
		alert = driver.switchTo().alert();
		alert.dismiss();
		Assert.assertEquals(loginPage.getEmailErrorMessageTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_UnredisteredEmail() {
		homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox("thihoang1122334@gmail.com");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_EmptyPassword() {
		homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(emailAdress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_WrongPassword() {
		homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(emailAdress);
		loginPage.sendkeysPasswordTextbox("adsggg");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_ValidLogin() {
		homePage.clickToLoginLink();
		loginPage.sendkeysEmailTextbox(emailAdress);
		loginPage.sendkeysPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
