package com.JalaAcadamyt_TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JalaAcadamyPages.AdminPage;
import com.JalaAcademy.Util.Test_Util;
import com.JalaAcademyBase.BaseTest;

public class AdminPageTest extends BaseTest {
 
 AdminPage adminpage;
 Test_Util testutil;
 
	public AdminPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setup() {
		initialization();
		
		adminpage = new AdminPage();
		
	}
	@Test(priority=1)
	public void Stringvalidatetitle()
	{
		adminpage.clickadminlogin();
		String title =adminpage.validateadminTitle();
		Assert.assertEquals(title, "Admin Login"); //to get title of the particular page press ctrl+u
		System.out.println( "Title :"+ title);
		System.out.println(" admin-sighinpage lanuched successfully"); 
	}
	@Test(priority=2)
	public void adminsigninelement() throws InterruptedException, IOException
	{
		adminpage.clickadminlogin();
		System.out.println(" adminpage lanuched successfully");
		
		Thread.sleep(5000);
		
		adminpage.clickonadminsighin(prop.getProperty("AdminuserEmail"), prop.getProperty("AdminPassword"));
		adminpage.SignIn();
		
		Thread.sleep(1000);
		Test_Util testutil = new Test_Util();
		testutil.Adminsighinscreenshort();
		
		Thread.sleep(1000);
		
		adminpage.Back();
		
		Thread.sleep(1000);
		
		System.out.println("  Browser is back to LoginPage successfully");
	}
	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
	}
}
	


