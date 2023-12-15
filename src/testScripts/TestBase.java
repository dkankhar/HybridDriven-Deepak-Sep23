package testScripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ControlActions;
import pages.LoginPage;

public class TestBase {
	LoginPage login;

	@BeforeMethod
	public void setUp() {
		ControlActions.launchBrowser();
		login = new LoginPage();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ControlActions.captureScreenshot(result.getName());
		}
		ControlActions.closeBrowser();
	}
}
