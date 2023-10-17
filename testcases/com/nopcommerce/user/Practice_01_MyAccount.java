package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register;
import com.nopcommerce.common.Common_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class Practice_01_MyAccount extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserHomePageObject userHomePage;
	UserCustomerInfoPageObject customerInfoPage;
	String replaceEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		loginPage = homePage.openLoginPage();

		loginPage.sendkeysEmailTextbox(Common_Register.emailAddress);
		loginPage.sendkeysPasswordTextbox(Common_Register.password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isLogoutLinkDisplayed());

		replaceEmail = "automation" + generateFakeNumber() + "@mail.vn";
	}

	@Test
	public void Login_01_CustomerInfo() {
		customerInfoPage = homePage.clickToMyAccountLink();
		customerInfoPage.clickToRadioButtonByID(driver, "gender-female");
		customerInfoPage.sendkeysToTextboxByID(driver, "FirstName", "Automation");
		customerInfoPage.sendkeysToTextboxByID(driver, "LastName", "FC");
		customerInfoPage.sendkeysToTextboxByID(driver, "Email", replaceEmail);
		customerInfoPage.sendkeysToTextboxByID(driver, "Company", "Automationfc FC");
		customerInfoPage.clickToButtonByText(driver, "Save");
		verifyTrue(customerInfoPage.isSuccessMessageDisplayed(driver, "The customer info has been updated successfully."));
		verifyEquals(customerInfoPage.getRadioButtonValueByID(driver, "gender-female"), "F");
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), "Automation");
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), "FC");
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), replaceEmail);
		verifyEquals(customerInfoPage.getTextboxValueByID(driver, "Company"), "Automationfc FC");

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}