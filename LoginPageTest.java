package com.JalaAcadamyt_TestPages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JalaAcadamyPages.LoginPage;
import com.JalaAcadamyPages.HomePage;
import com.JalaAcademyBase.BaseTest;

public class LoginPageTest  extends BaseTest{

	 
	LoginPage loginPage;// so i can  call  Login object throughout the page
	HomePage homePage; 
		
		
		public LoginPageTest ()  // constructor for LoginPageTest
		{
			super(); //its calling super class constructor  nothing but BaseTest class constructor
			
		}
		
		@BeforeMethod
		public void setUp(){
			//BaseTest = new BaseTest();
			initialization(); // calling Properties method using its constructor
			loginPage = new LoginPage ();	 //calling  object for Login Page
		}
		@Test(priority=1)																																	
		public void loginPageTitleTest(){
			String title = loginPage.validateLoginPageTitle();
			Assert.assertEquals(title, "Login"); //to get title of the particular page press ctrl+u
			
			System.out.println( "Title  of the page:"+ title);
			
		}
		
		@Test(priority=2)
		public void JaLogoImageTest(){
			boolean flag =loginPage.validatejamage();
			Assert.assertTrue(flag);
			System.out.println( "result of the page :"+flag);
		}
		
		@Test(priority=3)
		public void loginTest() throws InterruptedException{
			homePage 	= loginPage .login(prop.getProperty("userEmail"), prop.getProperty("Password"));
			Thread.sleep(5000);
			System.out.println("login successfully");
		}
		
		
		
		
	

		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		
		
		
}
