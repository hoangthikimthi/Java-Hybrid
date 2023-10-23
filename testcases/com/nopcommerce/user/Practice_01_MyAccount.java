package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import pageObjects.nopCommerce.user.ChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserAddProductReviewPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.ChangePasswordPageUI;

public class Practice_01_MyAccount extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserHomePageObject userHomePage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressesPage;
	ChangePasswordPageObject changePasswordPage;
	UserProductDetailPageObject productDetail;
	UserAddProductReviewPageObject addProductReviewPage;
	UserMyProductReviewPageObject myProductReviewPage;
	String replaceEmail, newPassword, productReviewTitle, productReviewText, productReviewPoint, productReviewWidth;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		loginPage = homePage.openLoginPage();
		System.out.println(Common_Register.emailAddress);
		System.out.println(Common_Register.password);
		loginPage.sendkeysEmailTextbox(Common_Register.emailAddress);
		loginPage.sendkeysPasswordTextbox(Common_Register.password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isLogoutLinkDisplayed());

		replaceEmail = "automation" + generateFakeNumber() + "@mail.vn";
		newPassword = "123456";
		productReviewTitle = "Product Review Title";
		productReviewText = "Product Review Text";
		productReviewPoint = "4";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	private String valueOfProductReviewWidth(String productReviewPoint) {
		switch (productReviewPoint) {
		case "1":
			return productReviewWidth = "width:20%";
		case "2":
			return productReviewWidth = "width:40%";
		case "3":
			return productReviewWidth = "width:60%";
		case "4":
			return productReviewWidth = "width:80%";
		case "5":
			return productReviewWidth = "width:100%";
		default:
			throw new RuntimeException("Invalid productViewPoint");
		}
	}

	@Test
	public void MyAccount_01_UpdateCustomerInfo() {
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

	@Test
	public void MyAccount_02_AddAdress() {

		addressesPage = (UserAddressPageObject) customerInfoPage.openMyAccountPageByPageName(driver, "Addresses");
		addressesPage.clickToButtonByText(driver, "Add new");
		verifyTrue(addressesPage.isAddAddressFormDisplayed());
		addressesPage.sendkeysToTextboxByID(driver, "Address_FirstName", "Automation");
		addressesPage.sendkeysToTextboxByID(driver, "Address_LastName", "fc");
		addressesPage.sendkeysToTextboxByID(driver, "Address_Email", "Automationfc.vn@gmail.com");
		addressesPage.sendkeysToTextboxByID(driver, "Address_Company", "Automation");
		addressesPage.selectItemFromDropdown(driver, "Address_CountryId", "Viet Nam");
		addressesPage.selectItemFromDropdown(driver, "Address_StateProvinceId", "Other");
		addressesPage.sendkeysToTextboxByID(driver, "Address_City", "Da Nang");
		addressesPage.sendkeysToTextboxByID(driver, "Address_Address1", "1234 Hai Phong");
		addressesPage.sendkeysToTextboxByID(driver, "Address_Address2", "1234 Le Lai");
		addressesPage.sendkeysToTextboxByID(driver, "Address_ZipPostalCode", "550000");
		addressesPage.sendkeysToTextboxByID(driver, "Address_PhoneNumber", "012345678");
		addressesPage.sendkeysToTextboxByID(driver, "Address_FaxNumber", "0987654323");

		addressesPage.clickToButtonByText(driver, "Save");
		verifyEquals(addressesPage.isInfoSaved(driver, "email"), "Email: Automationfc.vn@gmail.com");
		verifyEquals(addressesPage.isInfoSaved(driver, "phone"), "Phone number: 012345678");
		verifyEquals(addressesPage.isInfoSaved(driver, "fax"), "Fax number: 0987654323");
		verifyEquals(addressesPage.isInfoSaved(driver, "company"), "Automation");
		verifyEquals(addressesPage.isInfoSaved(driver, "address1"), "1234 Hai Phong");
		verifyEquals(addressesPage.isInfoSaved(driver, "address2"), "1234 Le Lai");
		verifyEquals(addressesPage.isInfoSaved(driver, "country"), "Viet Nam");
	}

	@Test
	public void MyAccount_03_ChangePassword() {
		changePasswordPage = (ChangePasswordPageObject) homePage.openMyAccountPageByPageName(driver, "Change password");
		changePasswordPage.sendkeysToTextboxByID(driver, "OldPassword", Common_Register.password);
		changePasswordPage.sendkeysToTextboxByID(driver, "NewPassword", newPassword);
		changePasswordPage.sendkeysToTextboxByID(driver, "ConfirmNewPassword", newPassword);
		changePasswordPage.clickToButtonByText(driver, "Change password");
		verifyTrue(customerInfoPage.isSuccessMessageDisplayed(driver, "Password was changed"));
		changePasswordPage.clickToElement(driver, ChangePasswordPageUI.CLOSE_SUCCESS_MESSAGE);

		homePage = changePasswordPage.clickToLogoutLinkAtUserPage(driver);
		loginPage = homePage.clickToLoginLinkAtUserPage(driver);
		loginPage.sendkeysEmailTextbox(replaceEmail);
		loginPage.sendkeysPasswordTextbox(Common_Register.password);
		homePage = loginPage.clickToLoginButton();
		verifyEquals(loginPage.getErrorMessageUnsuccessfulLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		loginPage.sendkeysPasswordTextbox(newPassword);
		loginPage.clickToLoginButton();
		verifyTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void MyAccount_04_AddProductReview() {

		productDetail = (UserProductDetailPageObject) homePage.clickToProductPicture(driver, "1");
		verifyTrue(productDetail.isProductDetailPageDisplayed());
		addProductReviewPage = productDetail.clickToAddYourReviewLink();
		verifyTrue(addProductReviewPage.addProductReviewPageDisplayed());
		addProductReviewPage.sendkeysToTextboxByID(driver, "AddProductReview_Title", productReviewTitle);
		addProductReviewPage.sendkeysToTextareaByID(driver, "AddProductReview_ReviewText", productReviewText);
		addProductReviewPage.markRattingPoint(driver, productReviewPoint);
		addProductReviewPage.clickToButtonByText(driver, "Submit review");

		verifyTrue(addProductReviewPage.isProductReviewTiTleDisplayed(driver, productReviewTitle));
		verifyTrue(addProductReviewPage.isProductReviewTextDisplayed(driver, productReviewTitle, productReviewText));

		customerInfoPage = homePage.clickToMyAccountLink();
		myProductReviewPage = (UserMyProductReviewPageObject) customerInfoPage.openMyAccountPageByPageName(driver, "My product reviews");
		verifyTrue(myProductReviewPage.isProductReviewTiTleDisplayed(driver, productReviewTitle));
		verifyTrue(myProductReviewPage.isProductReviewTextDisplayed(driver, productReviewTitle, productReviewText));
		verifyTrue(myProductReviewPage.isProductReviewPointDisplayed(driver, productReviewTitle, valueOfProductReviewWidth(productReviewPoint)));

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
		// closeBrowserDriver();
	}
}