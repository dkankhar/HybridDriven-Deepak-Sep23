/*
 * TC1 - Validate the login successful with the credentials
 * https://rahulshettyacademy.com/client/
 */

package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ControlActions;
import pages.LoginPage;

public class LoginTest {
	
	
	@BeforeMethod
	public void setUp() {
		ControlActions.launchBrowser();
	}
	
	@Test
	public void verifyLogin() {
		LoginPage login = new LoginPage();		
		login.login("dgkankhar@gmail.com", "Deepak@21");
		Assert.assertTrue(login.isLoginSuccessMsgDisplayed());
		
	}	

	@AfterMethod
	public void tearDown() {
		ControlActions.closeBrowser();
	}
}
