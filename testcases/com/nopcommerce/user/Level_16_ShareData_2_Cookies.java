package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.nopcommerce.common.Common_Register;
import com.nopcommerce.common.Common_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_16_ShareData_2_Cookies extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition-Step1: Navigate to Login Page");
		loginPage = homePage.openLoginPage();
		// set cookies and reload page

		log.info("Pre-condition-Step2: Set cookies and reload page");
		loginPage.setCookies(driver, Common_Register_Cookie.LoggedCookies);
		for (Cookie cookie : Common_Register_Cookie.LoggedCookies) {
			System.out.println("Cookies at 2 Class: " + cookie);

		}
		loginPage.refreshPage(driver);
		log.info("Pre-condition-Step3: Verify Logout Link");
		verifyTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void Login_01_EmptyData() {

	}

	@Test
	public void Login_02_Relative_Production_Name() {

	}

	@Test
	public void Login_03_Absolute_Production_Name() {

	}

	@Test
	public void Login_04_Parent_Category() {

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
