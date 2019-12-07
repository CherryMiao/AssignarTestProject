package com.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testdata.Testdata;


public class CalendarPage {
	public static final String[] months = new String[] 
			{"", "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "Octorber", "November", "December"};
	
	public void selectDate(WebDriver driver, String year, String month, String date) throws Exception{
		String allocationUrl = Testdata.URL + "/#/allocations/calendar/" + year + "-" + month + "-" + date;

		// open a new tab 
	    String a = "window.open('" + allocationUrl + "','_blank');";
	    ((JavascriptExecutor)driver).executeScript(a);
	    Thread.sleep(3000);
	    
	    //switches to new tab
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); 
	}
	
	public void findTheTask(WebDriver driver, String year, String month, String date, String day, String task) throws Exception {
		selectDate(driver, year, month, date);
		Thread.sleep(3000);
		
		//Wednesday, December 4, 2019
		String complteDay = day + ", " + months[Integer.parseInt(month)] + " " + date + ", " + year;
		String taskElementXpath = "//div[@id='" + complteDay +"']//span[contains(text(), '" + task +"')]";
		WebElement taskElement = driver.findElement(By.xpath(taskElementXpath));
		taskElement.click();
		Thread.sleep(3000);
	}

	public void confirmTheTask(WebDriver driver) throws Exception {
		if (getTheTaskStatus(driver).contains("Pending")) {
			WebElement confirmButton = driver.findElement(By.xpath("//span[text()='Confirm']"));
			confirmButton.click();
			Thread.sleep(3000);
			
			WebElement okButton = driver.findElement(By.xpath("//span[text()='Ok']"));
			okButton.click();
			Thread.sleep(3000);
		} else {
			System.out.println("This task has been confirmed.");
		}
	}
	
	public String getTheTaskStatus(WebDriver driver) throws Exception {
		WebElement statusElement = driver.findElement(By.xpath("//span[text()='Status:']/../../div[2]//span[1]"));
		return statusElement.getAttribute("innerHTML");
	}
}
