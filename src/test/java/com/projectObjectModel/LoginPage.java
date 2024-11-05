package com.projectObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		//initializing the page Object
		PageFactory.initElements(driver,this);
	}
	
	
	//locator
	@FindBy(name="username") 
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	//Action methods
	
	
	public void doLogin(String userName,String password)
	{
	uname.sendKeys(userName);
	pass.sendKeys(password);
	loginBtn.click();
	}
	

}
