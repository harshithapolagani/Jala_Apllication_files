package com.JalaAcadamyt_TestPages;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JalaAcadamyPages.ForgetPasswordPage;


import com.JalaAcademyBase.BaseTest;

public class ForgetPasswordPageTest extends BaseTest {
	
	
	ForgetPasswordPage forgetpasswordpage ;
	
	public ForgetPasswordPageTest ()
	{
		super();
		
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		forgetpasswordpage =new ForgetPasswordPage();
				
		
	}
	@Test(priority=1)
	
	public void clicknforgetpage() {

		forgetpasswordpage =new ForgetPasswordPage();
		forgetpasswordpage.clickonforgetpassword();
	}
	@Test(priority=2)
	public void  forgetPagevalidatetitle() throws InterruptedException{
		Thread.sleep(10000);
		forgetpasswordpage.clickonforgetpassword();
		System.out.println(driver.getCurrentUrl());
		String title =forgetpasswordpage . validateforgetpasswordPageTitle();
		Assert.assertEquals(title, "Forgot your password?"); //to get title of the particular page press ctrl+u
		System.out.println( "Title :"+ title);
		}
	@Test(priority=3)
	public void backelement() {
		forgetpasswordpage.clickonforgetpassword();
		forgetpasswordpage.clickonbackelement();
		System.out.println(driver.getCurrentUrl());
	}
	@Test(priority=4)
	public void getpassword() {
		forgetpasswordpage.clickonforgetpassword();
		forgetpasswordpage.GetPassword();
		System.out.println(driver.getCurrentUrl());
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
