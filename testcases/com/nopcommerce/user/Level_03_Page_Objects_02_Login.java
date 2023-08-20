package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Objects_02_Login {
	WebDriver driver;
	String emailAdress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		emailAdress = "automation" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_EmptyData() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//button[@name='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
	}

	@Test
	public void TC_02_Register_InvalidEmail() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("PC");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("123@456#");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456a");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456a");

		driver.findElement(By.xpath("//button[@name='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Wrong email");
	}

	@Test
	public void TC_03_Register_ValidEmail() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("PC");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAdress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456a");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456a");

		driver.findElement(By.xpath("//button[@name='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
	}

	@Test
	public void TC_04_Register_Email_Exit() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("PC");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAdress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456a");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456a");

		driver.findElement(By.xpath("//button[@name='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//li")).getText(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_PasswordLessThan6Character() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("PC");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAdress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234a");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1234a");

		driver.findElement(By.xpath("//button[@name='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']/p")).getText(), "Password must meet the following rules:");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']//li")).getText(), "must have at least 6 characters");
	}

	@Test
	public void TC_06_ConfirmPassword() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("PC");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAdress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456a");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123467");

		driver.findElement(By.xpath("//button[@name='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");

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
