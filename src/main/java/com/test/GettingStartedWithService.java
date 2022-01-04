package com.test;

import java.io.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.openqa.selenium.remote.*;

public class GettingStartedWithService {

	public static void main(String[] args) {
		try {
			createAndStartService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createAndStartService() throws IOException {
		ChromeDriverService service;
		WebDriver driver;

		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(
				"extras/chromedriver_96.0.4664.45_win32/chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();

		try {
			driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
			driver.get("http://www.google.com/");

			Thread.sleep(5000); // Let the user actually see something!

			WebElement searchBox = driver.findElement(By.name("q"));

			searchBox.sendKeys("Hello Tester");

			searchBox.submit();

			Thread.sleep(1000); // Let the user actually see something!

			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}