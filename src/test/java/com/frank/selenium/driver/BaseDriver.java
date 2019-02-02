package com.frank.selenium.driver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

	WebDriver driver = null;

	public BaseDriver(String browserName) {
		if (driver == null) {

			if (browserName == null)
				driver = new ChromeDriver();

			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new ChromeDriver();
			}
		}
		System.out.println("Start webdriver");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void stop() {
		driver.close();
		System.out.println("Stop webdriver");
	}

	public void takeScreenShot() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
		takeScreenShot((TakesScreenshot) this.getDriver(), path);
	}

	public void takeScreenShot(TakesScreenshot drivername, String path) {
		String currentPath = System.getProperty("user.dir"); // get current work
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Take Screenshot successfully");
		}
	}

	public void get(String url) {
		driver.get(url);
	}

	public void back() {
		driver.navigate().back();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<String> getWindowsHandles() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(winHandels);
		return handles;
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public void switchWindows(String name) {
		driver.switchTo().window(name);
	}

	public void switchAlert() {
		driver.switchTo().alert();
	}

	public void switchToModal() {
		driver.switchTo().activeElement();
	}

	public Set<Cookie> getCookie() {
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies;
	}

	public void deleteCookie() {
		driver.manage().deleteAllCookies();
	}

	public void setCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	public WebElement findElement(By by) {

		return driver.findElement(by);
	}

	public List<WebElement> findElements(By by) {

		return driver.findElements(by);
	}

	public void setDriverImplicitWait(int i) {

		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

}
