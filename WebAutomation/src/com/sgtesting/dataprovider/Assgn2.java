package com.sgtesting.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assgn2 {
public static WebDriver oBrowser=null;
	
	@Test(priority=1)
	public void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "H:\\ExampleAutomation\\Automation\\WebAutomation\\Library\\Driver\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void navigate()
	{
		try
		{
			oBrowser.get("http://localhost:83/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void createUser1()
	{
		try {
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[2]")).click();
			oBrowser.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("User1");
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("Last Name");
			oBrowser.findElement(By.id("userDataLightBox_emailField")).sendKeys("User1.Lastname@gmail.com");
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys("User1");
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Welcome123");
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Welcome123");
			oBrowser.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(5000);
			System.out.println("User1 created successfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=5)
	public void modifyUser1()
	{
		try {
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("Lastname10");
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Welcome123");
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Welcome123");
			oBrowser.findElement(By.xpath("//*[@id='userDataLightBox_commitBtn']/div/span")).click();
			Thread.sleep(4000);
			System.out.println("User1 modified successfully");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=6)
	public void closeApplication()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3,dataProvider="getLoginData")
	public void login(String user,String pwd)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][] {{"admin","manager"},
			{"admin","manager"},
			{"admin","manager"}};
	}
	
}
