package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.Environment;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_21_MultiEnviroment extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInfoPageObject customerInfoPage;
	String validPassword, firstName, lastName, invalidEmail, exittingEmail, notFoundEmail, inValidPassword;
	UserDataMapper userData;
	String loginPageUrl, userID, password;
	Environment env;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		env = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(browserName, env.url());
		System.out.println(env.url());
		System.out.println(env.getDBHostName());
		System.out.println(env.getDBPassword());
	}

	@Test
	public void Login_01_register() {
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
