package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class DashboardPage extends ControlActions {
	@FindBy(xpath = "//Section[@id='sidebar']//h6[text()='Categories']//following-sibling::div[not(@id)]/label")
	List <WebElement> listOfCategoriesOptions; 
	
	@FindBy(xpath = "//Section[@id='sidebar']//h6[text()='Sub Categories']//following-sibling::div[not(@id)]/label")
	List <WebElement> listOfSubCategoriesOptions;
	
	@FindBy(xpath = "//Section[@id='sidebar']//h6[text()='Search For']//following-sibling::div[not(@id)]/label")
	List <WebElement> listOfSearchForOptions;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getListOfCategoriesOptions() {
		return listOfWebElements(listOfCategoriesOptions);
	}	
	public int getCountOfCategoriesOptions() {
		return listOfWebElements(listOfCategoriesOptions).size();
	}	
	
	public List<String> getListOfSubCategoriesOptions() {
		return listOfWebElements(listOfSubCategoriesOptions);
	}
	public int getCountOfSubCategoriesOptions() {
		return listOfWebElements(listOfSubCategoriesOptions).size();
	}
	
	public List<String> getListOfSearchForOptions() {
		return listOfWebElements(listOfSearchForOptions);
	}
	public int getCountOfSearchForOptions() {
		return listOfWebElements(listOfSearchForOptions).size();
	}
}
