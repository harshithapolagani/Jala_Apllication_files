package com.JalaAcadamyt_TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JalaAcadamyPages.EmployeePage;
import com.JalaAcademy.Util.Test_Util;
import com.JalaAcademyBase.BaseTest;

public class EmployeePageTest extends BaseTest {

	
	EmployeePage employee;
	EmployeePageTest employeetest;
	Test_Util utils;
	
	
	public  EmployeePageTest() {
		
		super();
	}
	@BeforeMethod
	public void setUp(){
		//BaseTest = new BaseTest();
		initialization(); // calling
		utils = new Test_Util ();
		employee= new EmployeePage();
	}
	
	@Test
	public void employepagevalidatetitle() throws InterruptedException {
           employee.jalapage(prop.getProperty( "userEmail"), prop.getProperty( "Password"));
           employee.createemployeclick();
          // utils.BrowserSavePasswordPopup();
           Thread.sleep(5000);
   		employee.clickoncreate();
   		Thread.sleep(5000);
		
		String title =employee.validatetitileofthepage();
		Assert.assertEquals(title, "Create Employee"); 
		System.out.println("the title of the page is :" + title);
	}
		@Test
	public void Employecreate() throws InterruptedException {
		System.out.println("loginpage displayed successfully displayed");
		employee.jalapage(prop.getProperty( "userEmail"), prop.getProperty( "Password"));
		
		System.out.println("employeepage is displayed successfully");
		
		employee.createemployeclick();
		//utils.BrowserSavePasswordPopup();
		
		employee.clickoncreate();
		Thread.sleep(5000);
		System.out.println("create employee page is displyed successfully");
		
		
		employee.createemployee(prop.getProperty( "firstname" ), prop.getProperty(" lastname")
		,prop.getProperty( " mail"), prop.getProperty( "dob"), prop.getProperty( "mobilenumber" )
		, prop.getProperty( "address"));
		
		
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	}
	

