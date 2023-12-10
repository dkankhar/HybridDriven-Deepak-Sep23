package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ControlActions;

public class LoginPage extends ControlActions{
	
	@FindBy(id = "userEmail")
	WebElement userEmailElement;
	
	@FindBy(id = "userPassword")
	WebElement userPasswordElement;
	
	@FindBy(id = "login")
	WebElement loginButtonElement;
	
	@FindBy(xpath="//div[@aria-label='Login Successfully']")
	WebElement loginSuccessMsgElement;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);		//Constructor to initialize elements
	}
	
	public void login(String uName, String uPassword) {
		
		System.out.println("STEP: User enters email!");
		//driver.findElement(By.id("userEmail")).sendKeys(uName);
		userEmailElement.sendKeys(uName);
		
		System.out.println("STEP: User enters password!");
		//driver.findElement(By.id("userPassword")).sendKeys(uPassword);
		userPasswordElement.sendKeys(uPassword);
		
		System.out.println("STEP: User clicks on Login button.");
		//driver.findElement(By.id("login")).click();
		loginButtonElement.click();
		
	}
	
	public boolean isLoginSuccessMsgDisplayed() {
		//WebElement loginSuccess = getElement("xpath", "//div[@aria-label='Login Successfully']", true);
		waitTillElementIsVisible(loginSuccessMsgElement);
		System.out.println("VERIFY: Login Toast pop-up displayed!");
		return loginSuccessMsgElement.isDisplayed();
	}
}
