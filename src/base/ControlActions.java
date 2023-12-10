package base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.org.objectweb.asm.Constants;
import constants.ConstantPath;
import utility.PropOperations;

public abstract class ControlActions {
	protected static WebDriver driver;
	private static PropOperations propOperation;
	private static WebDriverWait wait;

	public static void launchBrowser() {
		propOperation = new PropOperations(ConstantPath.ENV_FILEPATH);
		System.setProperty(ConstantPath.CHROME_DRIVER_KEY, ConstantPath.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propOperation.getValue("url"));
		wait = new WebDriverWait(driver, ConstantPath.WAIT);
	}

	public static void closeBrowser() {
		driver.close();
	}

	protected WebElement getElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element = null;
		switch (locatorType.toUpperCase()) {
		case ("XPATH"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			else
				element = driver.findElement(By.xpath(locator));
			break;
		case ("CSS"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			else
				element = driver.findElement(By.cssSelector(locator));
			break;
		case ("ID"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			else
				element = driver.findElement(By.id(locator));
			break;
		case ("NAME"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			else
				element = driver.findElement(By.name(locator));
			break;
		case ("CLASSNAME"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			else
				element = driver.findElement(By.className(locator));
			break;
		case ("LINKEDTEXT"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			else
				element = driver.findElement(By.linkText(locator));
			break;
		case ("PARTIALLINKEDTEXT"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
			else
				element = driver.findElement(By.partialLinkText(locator));
			break;
		}
		return element;
	}
	
	protected void waitTillElementIsVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitTillElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void waitTillElementIsInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ConstantPath.FAST_WAIT);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
