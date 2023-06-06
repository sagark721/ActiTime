package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;
import com.actitime.generic.WebDriverCommonLib;

public class TaskPage  {

	
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[@class='dropdownContainer addNewMenu']/div[1]")
	private WebElement newCustBtn;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custNameTxb;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement descriptionTxb;
	
	@FindBy(xpath = "(//div[text()='- Select Customer -'])[1]")
	private WebElement existingProject;
	
	@FindBy(xpath = "(//input[@type='text' and @placeholder and @value ])[2]")
	private WebElement exisitngProjTxb;
	
	@FindBy(xpath = "(//div[@class='itemRow cpItemRow '])[1]")
	private WebElement firstOccuranceInExisitingProj;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustBtn;
	
	@FindBy(xpath = "//div[@class='taskManagementHeaderPanel hasSelectedCustomer']//div[@class='title']")
	private WebElement actCustName;
	
	
	
	WebDriverCommonLib w=new WebDriverCommonLib();
	
	public String getActCustName() {
		
		w.waitUntilVisibilityOf(actCustName);
		return actCustName.getAttribute("title");
	}





	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	


	public void setAddNewBtn() {
		addNewBtn.click();
	}


	public void setNewCustBtn() {
		newCustBtn.click();
	}


	public void setCustNameTxb(String custName) {
		custNameTxb.sendKeys(custName);
	}


	public void setDescriptionTxb(String desc) {
		descriptionTxb.sendKeys(desc);
	}


	public void setExistingProject(String existingProj) {
		existingProject.click();
		exisitngProjTxb.sendKeys(existingProj);
		firstOccuranceInExisitingProj.click();
	}


	public void setCreateCustBtn() {
		createCustBtn.click();
	}
	
	
	
}


