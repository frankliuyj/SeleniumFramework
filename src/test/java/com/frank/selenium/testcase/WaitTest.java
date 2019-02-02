package com.frank.selenium.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.junit.Test;
//import static org.junit.Assert.*;

import java.util.List;

public class WaitTest {

	WebDriver driver = new ChromeDriver();

	@Test
	public void Wait1Test() {
		// TODO Auto-generated constructor stub

		driver.get("http://www.baidu.com");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fuck")));

		Assert.assertTrue(true);

	}

	@Test
	public void TabCountTest() {
		// TODO Auto-generated constructor stub

		driver.get("http://www.baidu.com");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
		String combine_keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
		element.sendKeys(combine_keys);

		Assert.assertTrue(true);

	}

	@Test
	public void CalenderTest() {
		// TODO Auto-generated constructor stub

		driver.get("https://www.path2usa.com/travel-companions");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement element = driver.findElement(By.xpath("//*[@id=\"travel_date\"]"));
		element.click();

		while (!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']"))
				.getText().contains("April")) {
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> days = driver.findElements(By.className("day"));

		// Go over

		for (int i = 0; i < days.size(); i++) {
			String text = days.get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				days.get(i).click();
				break;
			}

		}

		Assert.assertTrue(true);

	}

}
