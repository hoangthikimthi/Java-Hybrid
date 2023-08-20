package com.nopcommerce.user;

import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Objects_01_Register {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String emailAdress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		emailAdress = "automation" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void Register_01_EmptyData() {
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErorMessageConfirmPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErorMessageEmailTextbox(), "Email is required.");
	}

	@Test
	public void Register_02_InvalidEmail() {
		homePage.clickToRegisterLink();
		
		registerPage.senkeysToFirstNameTextbox();
		registerPage.senkeysToLastNameTextbox();
		registerPage.senkeysToEmailTextbox();
		registerPage.senkeysToPasswordTextbox();
		registerPage.senkeysToConfirmPasswordTextbox();

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErorMessageEmailTextbox(), "Wrong email");

}

	@Test
	public void Register_03_ValidEmail() {
		
		homePage.clickToRegisterLink();
		
		registerPage.senkeysToFirstNameTextbox();
		registerPage.senkeysToLastNameTextbox();
		registerPage.senkeysToEmailTextbox();
		registerPage.senkeysToPasswordTextbox();
		registerPage.senkeysToConfirmPasswordTextbox();

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
}

	@Test
	public void Register_04_Email_Exit() {
		homePage.clickToRegisterLink();

		registerPage.senkeysToFirstNameTextbox();
		registerPage.senkeysToLastNameTextbox();
		registerPage.senkeysToEmailTextbox();
		registerPage.senkeysToPasswordTextbox();
		registerPage.senkeysToConfirmPasswordTextbox();

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErorMessageEmailTextbox(), "The specified email already exists");
}

	@Test
	public void Register_05_PasswordLessThan6Character() {
		homePage.clickToRegisterLink();
		
		registerPage.senkeysToFirstNameTextbox();
		registerPage.senkeysToLastNameTextbox();
		registerPage.senkeysToEmailTextbox();
		registerPage.senkeysToPasswordTextbox();
		registerPage.senkeysToConfirmPasswordTextbox();

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErorMessagePasswordTextbox(), "Password must meet the following rules:/nmust have at least 6 characters");
		}

	@Test
	public void Register_06_ConfirmPassword() {
		homePage.clickToRegisterLink();
		
		registerPage.senkeysToFirstNameTextbox();
		registerPage.senkeysToLastNameTextbox();
		registerPage.senkeysToEmailTextbox();
		registerPage.senkeysToPasswordTextbox();
		registerPage.senkeysToConfirmPasswordTextbox();

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErorMessageConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	
	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
