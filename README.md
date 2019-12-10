# Assignar Test Project

## The Task
#### User Story

As a fieldworker user, I want to be able to confirm an allocation for a current or future date.

#### E2E UI Test

The E2E test should be able to find/confirm an allocation based on DATE and TASK.

#### API Test

The API test should be able to confirm an allocation based on an allocation ID.

## The Test Project
This project uses **Eclipse+Maven+TestNG+Selenium** automation framework to do the E2E UI test and API test.

### How to set up the environment

1. Install Java8+.

2. Install the latest version of Eclipse.
3. Install the latest version of Maven.

4. Add Maven installations in Eclipse.

   1) Open Eclipse and go into this menu:
   Windows->Preferences->Maven->Installations>Add

   2) Add:
   Installation type: External
   Installation home: Maven installation path

5. Download browsers and Webdrivers.

   This project uses Firefox and [geckodriver.exe](https://github.com/mozilla/geckodriver/releases/) to demo. 

   In order to make things easy, please install/update Firefox to the latest versions.

   

### How to run 
**1. Open the project in Eclipse**

**2. Update the project**
    1) Right click the project name, go into menu:
        Maven->Update Project
    2) Check this checkbox: Force Update of Snapshots/Releases.
    3) Click OK.

**3. Run E2E UI test case**

> A simple test case:
> 1. User logins Assignar.
> 2. User goes into Allocations page.
> 3. User finds the task based on the date and the task name.
> 4. User confirms the task. 

>Expected result:
>User confirms the task successfully, the status of the task is turned into *Confirmed*.



Right click this java file: Run As -> 1 TestNG Test.

>src/test/java/selenium.testdemo/AllocationsUITest.java

	Excpected result:
	Firefox pops up and every step in the simple test case is done.
	
	Result displayed in the Eclipse console:
	[RemoteTestNG] detected TestNG version 6.14.3
	...
	This task has been confirmed.
	PASSED: oepnUrl
	PASSED: login
	PASSED: clickMenu
	PASSED: findTheTask
	PASSED: confirmTheTask
	===============================================
		Default test
		Tests run: 5, Failures: 0, Skips: 0
	===============================================
	===============================================
	Default suite
	Total tests run: 5, Failures: 0, Skips: 0
	===============================================

**4. Run API test case**
> A simple test case:
> Call the allocations confirm API to confirm a task based on id.

>Expected Result:
>The API is called successfully, its response is 201.

Right click this java file: Run As -> 1 TestNG Test
>src/test/java/selenium.testdemo/AllocationsAPITest.java

	Excpected result:
	Result displayed in the Eclipse console:
	[RemoteTestNG] detected TestNG version 6.14.3
	PASSED: login
	PASSED: confirmTask
	===============================================
	Default test
	Tests run: 2, Failures: 0, Skips: 0
	===============================================
	===============================================
	Default suite
	Total tests run: 2, Failures: 0, Skips: 0
	===============================================

### How to change test parameters
The test parameters has been hardcoded in this java file:
> src/main/java/com.testdata/Testdata.java

### How to change the browser type
Actually this project can also run on Chrome and IE, you could change the browser type in this java file. While you must install or update your browsers to the latest versions.
> src/test/java/com.util/BaseTest.java

```java
    @BeforeTest
	public void start() throws Exception{
		try {
			// browser type: firefox, chrome, ie
			driver = browser.openBrowser("firefox");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
```

## Technology and approach used on the project

 - Automation framework **Eclipse+Maven+TestNG+Selenium** 
 
 > This framework is popular, powerful and easy to use.
 
 - Java

 - XPath
 
 > It is used to locate the page elements.
 
- HTTP Post request

- JSON

- Network traffic analysis

- Management of test cases

  > It is important to manage test cases well at first. In this project, test scripts are put into these 4 packages:
  > com.util -> common utility functions
  > com.pageObject -> elements and action functions of every single page
  > com.testdata -> data separation principle
  > selenium.testdemo -> test cases

## Challenges

 - **In the UI test case, it is difficult to simulate a user finding the task exactly.**

  > As elements on Allocation calendar page don't have unique attributes like id, name or other distinguishable attributes, it's difficult to locate them.  I use the workaround to go to the calendar page directly by URL.

- **A lot of effort was spent on locating page elements.**

  > Things will get harder when there are so many page elements without any unique identifiers. This is a common challenge to UI automation testing. To improve the test productivity, the team must have the consensus that page elements should be designed with unique identifiers in the early stage.


## Future Improvements

- As test data is changeable, it could be stored in some external files like csv files or in the DB instead of being hardcoded.

- As page elements could be changeable, they could be stored in some external files like csv files or in the DB instead of being hardcoded.

- A Javadoc is necessary to help the team understand the project better if the project is growing.

- This project could be integrated into CI tools such as Jenkins to run regularly as sanity testing or regression testing.