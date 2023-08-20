package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_06_Condition_Statement {

	public static void main(String[] args) {
		boolean status = 5<3;
		System.out.println(status);
		if (status) {
			System.out.println("Go to if");
	}
		WebDriver driver = new FirefoxDriver();
		//Element luon cos trong DOM
		WebElement salePopUp = driver.findElement(By.id(""));
		if (salePopUp.isDisplayed()) {
			driver.findElement(By.id("")).click();
		}
		//Element l cos trong DOM
		List<WebElement> salePopUps = driver.findElements(By.id(""));
		if (salePopUps.size() > 0 && salePopUps.get(0).isDisplayed())  {
			driver.findElement(By.id("")).click();
		}
    }

}
