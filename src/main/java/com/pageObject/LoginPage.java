package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static final By CLIENID_INPUTTEXT_BY = By.name("loginId");
	private static final By USERNAM__INPUTTEXT_BY = By.name("username");
	private static final By PASSWORD__INPUTTEXT_BY = By.name("password");
	private static final By LOGIN_BUTTON_BY = By.xpath("//span[text()='Login']");
		
	public boolean isLoggedIn(WebDriver driver) throws Exception{
		WebElement loginButtonElement = driver.findElement(LOGIN_BUTTON_BY);
		
		if (loginButtonElement.isDisplayed()) {
			return false;
		} 

		return true;
	}
	
	public void login(WebDriver driver, String clientId, String userName, String password) throws Exception{
		if (!isLoggedIn(driver)) {
			WebElement clientIdElement = driver.findElement(CLIENID_INPUTTEXT_BY);
			WebElement usernameElement = driver.findElement(USERNAM__INPUTTEXT_BY);
			WebElement passwordElement = driver.findElement(PASSWORD__INPUTTEXT_BY);
			WebElement loginButtonElement = driver.findElement(LOGIN_BUTTON_BY);
			
			clientIdElement.sendKeys(clientId);
			usernameElement.sendKeys(userName);
			passwordElement.sendKeys(password);
			loginButtonElement.click();	
			Thread.sleep(3000);
		}
	}
}
