package com.projectObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage
{
WebDriver driver;
	
	//constructor
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		//initializing the page Object
		PageFactory.initElements(driver,this);
	}
	
	
	//locator
	
	
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']/ul/li")
	List <WebElement> menu;
	
	@FindBy(linkText="Admin")
	WebElement admin;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement nameSearchBox;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	WebElement roleSearchDropdown;
	
	@FindBy(xpath="//div[@class='oxd-select-option']")
	List<WebElement> roleSearchDropdownList;
	

	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	WebElement statusSearchDropdown;
	
	@FindBy(xpath="//div[@class='oxd-select-option']")
	List<WebElement> statusSearchDropdownList;
	
	@FindBy(css="button[type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath="//div/span[@class='oxd-text oxd-text--span']")
	WebElement recordCount;
	
	
	//Action methods
	
	
	public int getOptionCount()
	{
	return menu.size();
	}
	
	public void openAdminPage() 
	{
	admin.click();
	}
	public int searchByUserName(String userName) {
		
		nameSearchBox.sendKeys(userName);		
	     searchButton.click();
	   String txt=  recordCount.getText();
	   int count=Integer.valueOf(txt.split("\\)")[0].split("\\(")[1]);
	   
	   return count;
	}

	public int searchByRole(String roleName) {
		roleSearchDropdown.click();

		
		for(WebElement i:roleSearchDropdownList)
		{
			
			if(i.getText().equals(roleName))
			{
				
				i.click();
				break;
			}
		}		
	     searchButton.click();
	   String txt=  recordCount.getText();
	   int count=Integer.valueOf(txt.split("\\)")[0].split("\\(")[1]);
	   
	   return count;
	}
	
	
	public int searchByStatus(String status) {
		statusSearchDropdown.click();

		
		for(WebElement i:statusSearchDropdownList)
		{
			
			if(i.getText().equals(status))
			{
				
				i.click();
				break;
			}
		}		
	     searchButton.click();
	   String txt=  recordCount.getText();
	   int count=Integer.valueOf(txt.split("\\)")[0].split("\\(")[1]);
	   
	   return count;
	}
	
}
