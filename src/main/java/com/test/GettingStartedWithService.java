package com.test;

import java.io.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.openqa.selenium.remote.*;

public class GettingStartedWithService {

	public static void main(String[] args) {
		try {
			GettingStartedWithService x = new GettingStartedWithService();
			x.createAndStartService();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createAndStartService() throws IOException {
		ChromeDriverService service;
		WebDriver driver;

		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(
				"extras/chromedriver_96.0.4664.45_win32/chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();

		try {
			driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
			driver.get("http://www.google.com/");
			Thread.sleep(5000); // allow website to open
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Hello Tester");
			searchBox.submit();
			Thread.sleep(1000); // allow website to open

			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}