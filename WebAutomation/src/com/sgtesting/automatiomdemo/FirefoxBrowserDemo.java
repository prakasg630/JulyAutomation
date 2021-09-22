package com.sgtesting.automatiomdemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxBrowserDemo {

public static WebDriver oBrowser=null;
		
		public static void main(String[] args) {
			launchBrowser();
			navigate();
			login();
			minimizeFlyOutWindow();
			creatUser();
			modifyUser();
			deleteUser();
			logout();
	        closeApplication();
		}
	
static void launchBrowser()
{
	try
	{
		
		System.setProperty("webdriver.gecko.driver","H:\\ExampleAutomation\\Automation\\WebAutomation\\Library\\Driver\\geckodriver.exe");
		oBrowser=new FirefoxDriver();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
static void navigate()
{
	try
	{
		oBrowser.get("http://localhost:83/login.do");
		Thread.sleep(3000);
		}catch(Exception e)
	{
		e.printStackTrace();
	}
}
static void login()
{
	try
	{
		oBrowser.findElement(By.id("username")).sendKeys("admin");
		oBrowser.findElement(By.name("pwd")).sendKeys("manager");
		oBrowser.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(2000);
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	static void minimizeFlyOutWindow()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
	    }	
   }
	static void creatUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[5]/a")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[2]/td[2]/div/div")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("pk");
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("gurikar");
			oBrowser.findElement(By.id("userDataLightBox_emailField")).sendKeys("pgstar06@gmail.com");
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys("pkgurikar");
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys("gurikar123");
			oBrowser.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("gurikar123");
			oBrowser.findElement(By.xpath("//*[@id=\"userDataLightBox_commitBtn\"]")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void modifyUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td/span[1]/table/tbody/tr[2]/td[1]/table")).click();
			Thread.sleep(3000);
			
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("prakash");
		
			oBrowser.findElement(By.xpath("/html/body/div[1]/div[10]/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	static void deleteUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td/span[1]/table/tbody/tr[2]/td[1]/table")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//*[@id=\"userDataLightBox_deleteBtn\"]")).click();
			Thread.sleep(2000);
			Alert obj=oBrowser.switchTo().alert();
			String content=obj.getText();
			System.out.println(content);
			obj.accept();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void logout()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\"logoutLink\"]")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void closeApplication()
	{
		try
		{
			oBrowser.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
