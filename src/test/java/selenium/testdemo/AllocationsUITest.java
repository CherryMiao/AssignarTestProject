package selenium.testdemo;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.pageObject.CalendarPage;
import com.pageObject.LoginPage;
import com.pageObject.MenuPage;
import com.testdata.Testdata;
import com.util.BaseTest;

public class AllocationsUITest extends BaseTest{
	@Test(priority = 1)
	public void oepnUrl() throws Exception{
		driver.get(Testdata.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 2)
	public void login() throws Exception{
		LoginPage loginPage = new LoginPage();
		loginPage.login(driver, Testdata.CLIENTID, Testdata.USERNAME, Testdata.PASSWORD);
	}
  
	@Test(priority = 3)
	public void clickMenu() throws Exception{
		MenuPage menuPage = new MenuPage();
		menuPage.clickMenu(driver, "Allocations");
	}
	
	CalendarPage calendarPage = new CalendarPage();
	
	@Test(priority = 4)
	public void findTheTask() throws Exception{
		calendarPage.findTheTask(driver, Testdata.YEAR, Testdata.MONTH, Testdata.DATE, Testdata.DAY, Testdata.TASK);
	}
	
	@Test(priority = 5)
	public void confirmTheTask() throws Exception{
		calendarPage.confirmTheTask(driver);
		assertTrue(calendarPage.getTheTaskStatus(driver).contains("Confirmed"));
	}
}
