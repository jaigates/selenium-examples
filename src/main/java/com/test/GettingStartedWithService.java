package com.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
			Thread.sleep(5000); // always pause after every action for browser to load
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Hello Tester");
			searchBox.submit();
			Thread.sleep(1000); 
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}