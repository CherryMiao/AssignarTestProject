package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
	public void clickMenu(WebDriver driver, String menuName) throws Exception{
		String menuElementXpath = "//span[text()='" + menuName + "']";
		String menuHeadElementXpath = "//h2[text()='" + menuName + "']";
		
		WebElement menuElement = driver.findElement(By.xpath(menuElementXpath));
		menuElement.click();
		Thread.sleep(3000);
		
		// wait the element show up
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(menuHeadElementXpath)));
	}
}
