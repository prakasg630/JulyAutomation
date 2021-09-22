package com.sgtesting.dataprovider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assgn4 {
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
	public void createCustomer()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[3]/a")).click();
			oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[1]/div[2]/div")).click();
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
			oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys("Prakash");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id=\"customerLightBox_commitBtn\"]")).click();
			 oBrowser.findElement(By.id("customerLightBoxCloseButton")).click();
    		 Alert obj=oBrowser.switchTo().alert();
 			String content=obj.getText();
 			System.out.println(content);
 			obj.accept();
    		 
			
			
		}catch(Exception e)
		{

		e.printStackTrace();
		}
	}
	@Test(priority=5)
	public void deleteCustomer()
	{
		try
		{

   		 oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
   		 Thread.sleep(1000);
   		 oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[4]/div/div")).click();
   		 Thread.sleep(1000);
   		 oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[4]")).click();
   		 oBrowser.findElement(By.xpath("//*[@id=\"customerPanel_deleteConfirm_submitBtn\"]/div")).click();
   		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=6)
	 public void deleteCustmer()
	  {
		  try
		  {
			  oBrowser.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr/td[3]/a")).click();
			  oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			  Thread.sleep(1000);
			  oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[4]/div/div")).click();
			  Thread.sleep(1000);
			  oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[4]/div/div[3]/div")).click();
			  Thread.sleep(1000);
			  oBrowser.findElement(By.xpath("//*[@id=\"customerPanel_deleteConfirm_submitBtn\"]/div")).click();
			  
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
	  }
	@Test(priority=7)
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
