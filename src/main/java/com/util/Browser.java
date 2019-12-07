package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
	
	// open a browser
	// browser type: firefox, chrome, ie
	public WebDriver openBrowser(String browserType) throws Exception {
		try {
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}			
		} catch (Exception e) {
			System.out.println("Something goes wrong with opening a browser!");
		}
		
		return driver;
	}
	
	// close a browser
	public void closeBrowser() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Something goes wrong with closing a browser!");
		}
	}
}
