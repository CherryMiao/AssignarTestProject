package com.util;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {
	public static WebDriver driver;
	Browser browser = new Browser();
  
	@BeforeTest
	public void start() throws Exception{
		try {
			// browser type: firefox, chrome, ie
			driver = browser.openBrowser("firefox");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterTest
	public void end() {
		try {
			browser.closeBrowser();;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
