package com.projectObjectModel;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;



public class UserManagementTest  extends BaseClass {
	
	AdminPage adp;
	
	
  @Test(priority=1)
  public void adminTest() throws InterruptedException
  
  {
	  adp=new AdminPage(driver);
	  lp.doLogin("Admin","admin123");  
	  
	 int count = adp.getOptionCount();
	 Assert.assertEquals(12,count);
	  System.out.println("Total numbers of options from left side menu :" + count);
	  adp.openAdminPage(); 
	 
  }
  
  
  @Test(priority=2)
  public void searchRecordByUserName() 
  
  {
	  adp=new AdminPage(driver);
    int count=  adp.searchByUserName("Admin");
    System.out.println("Total record found: " +count);
   driver.navigate().refresh();
}
  
  @Test(priority=3)
  public void searchRecordByUserRole() 
  
  {
	  adp=new AdminPage(driver);
    int count=  adp.searchByRole("Admin");
    System.out.println("Total record found: " +count);
   driver.navigate().refresh();
}
  
  @Test(priority=4)
  public void searchRecordByUserStatus() 
  
  {
	  adp=new AdminPage(driver);
    int count=  adp.searchByStatus("Enabled");
    System.out.println("Total record found: " +count);
  
}
}
