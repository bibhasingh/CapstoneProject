package com.projectObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class BaseClass {
 

	public WebDriver driver;
	public LoginPage lp;
//	public AdminPage adp;
	
	@BeforeClass
	public void setUp()
	{
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	lp=new LoginPage(driver);
	
	}
}
