package com.dataDrivenTest;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.dataDrivenTest.ExtentReport.class)
public class HrmApp
{
	
  @Test(dataProvider = "dataRead",dataProviderClass = ExcelDataReading.class)
  public void tetsLogin(String un,String psw) throws IOException, InterruptedException 
  {
	
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	
	  driver.findElement(By.name("username")).sendKeys(un);
	  
	  driver.findElement(By.name("password")).sendKeys(psw);
	  
	 
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(5000);
	  
	  String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
	  
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File temp=ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File(System.getProperty("user.dir")+"//Screenshots//hrm"+timestamp+".png");
	  
	  FileHandler.copy(temp, dest);
	  
	 
	  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Fail");
	  System.out.println("Login Completed!");
	  
	
	  
  }
}

