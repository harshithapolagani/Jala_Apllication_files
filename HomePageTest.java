package com.JalaAcadamyt_TestPages;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JalaAcadamyPages.HomePage;
import com.JalaAcadamyPages.LoginPage;
import com.JalaAcademy.Util.Test_Util;
import com.JalaAcademyBase.BaseTest;

public class HomePageTest extends BaseTest {
	HomePage homepage;
	
	Test_Util testutils ;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	 public void setup() throws InterruptedException {
		
		 initialization();
		
		testutils = new Test_Util();
		 homepage = new HomePage();
		
	   // homepage = loginpage.login(prop.getProperty("userEmail"), prop.getProperty("Password"));// because homepage is returning this method
		// Thread.sleep(10000);
		
		 }
	@Test(priority=1)
	 public void logovalidation() throws InterruptedException
	 {
		homepage.welcomepage(prop.getProperty("userEmail"), prop.getProperty("Password"));
		Thread.sleep(10000);
		 boolean flag =homepage.validatelogo();
		 
			Assert.assertTrue(flag);
			
			System.out.println( "result of the page :"+flag);
			
	 }
	 @Test(priority=2)
	 public  void homepagetitleytest() throws InterruptedException, IOException {
		homepage.welcomepage(prop.getProperty("userEmail"), prop.getProperty("Password"));
		Thread.sleep(10000);
		 String title = homepage.validateHomePageTitle();
		 Assert.assertEquals(title, "Magnus"); 
		 System.out.println("The title of the page:" + title );
		
		
		
		}
	 @Test(priority=3)
	 public void employee() throws InterruptedException {
		 homepage.welcomepage(prop.getProperty("userEmail"), prop.getProperty("Password"));
		 Thread.sleep(5000);
		 testutils.popupmessage();
		Thread.sleep(10000);
		 homepage.clickonemployee();
		
		 Thread.sleep(10000);
		 
	 }
	 
	@AfterMethod
	public void tearDown(){
		driver.quit();
   
	 }
}
