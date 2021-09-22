package com.sgtesting.automatiomdemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDemo6 {
public static WebDriver oBrowser=null;
	public static void main(String[] args) {
	//  launchBrowser-->navigate-->login-->createCustomer-->CreateProject-->modifyProject -->DeleteProject-->deleteCustomer-->logout -->closeApplication
			launchBrowser();
			navigate();
			login();
			createCustomer();
			createProject();
			modifyProject();
			deleteProject();
			deleteCustomer();
			logOut();
			closeApplication();

	}
static void launchBrowser()
	
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","H:\\ExampleAutomation\\Automation\\WebAutomation\\Library\\Driver\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void navigate()
	{
		try
		{
			oBrowser.manage().window().maximize();
			oBrowser.get("http://localhost:83/login.do");
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
			oBrowser.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	  static void createCustomer()
	     {
	    	 try
	    	 {
	    		 oBrowser.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[3]/a")).click();
	    		 Thread.sleep(1000);
	    		 oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[1]/div[2]/div")).click();
	    		 oBrowser.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
	    		 oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys("Prakash");
	    		 Thread.sleep(1000);
	    		 oBrowser.findElement(By.id("customerLightBox_commitBtn")).click();
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
	static void createProject()
	{
		try {
			oBrowser.findElement(By.xpath("//*[@id='cpTreeBlock']/div[2]/div[1]/div[2]/div/div[3]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("projectPopup_projectNameField")).sendKeys("SMIP");
			oBrowser.findElement(By.id("projectPopup_projectDescriptionField")).sendKeys("SMIP");
			oBrowser.findElement(By.xpath("//*[@id=\'projectPopup_commitBtn\']/div/span")).click();
			Thread.sleep(2000);
			System.out.println("Customer Project created successfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void modifyProject()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/textarea")).clear();
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/textarea")).sendKeys("Smart Metering Project");
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]")).click();
			Thread.sleep(2000);
			System.out.println("Project modified successfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	  static void deleteProject()
	     {
	    	 try
	    	 {
	    		 oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
	 			Thread.sleep(2000);
	 			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[3]/div/div/div[2]")).click();
	 			Thread.sleep(2000);
	 			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[4]/div/div[3]/div")).click();
	 			Thread.sleep(2000);
	 			oBrowser.findElement(By.xpath("//*[@id=\"projectPanel_deleteConfirm_submitBtn\"]/div")).click();
	 			Thread.sleep(2000);
	    		 
	    		 
	    	 }catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
	     static void deleteCustomer()
	     {
	    	 try
	    	 {
	    		 oBrowser.findElement(By.xpath("//*[@id=\"cpTreeBlock\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
	    		 Thread.sleep(1000);
	    		 oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[4]/div/div/div[2]")).click();
	    		 Thread.sleep(1000);
	    		 oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[4]/div/div[3]/div")).click();
	    		 oBrowser.findElement(By.xpath("//*[@id=\"customerPanel_deleteConfirm_submitTitle\"]")).click();
	    		
	    		 
	    	 }catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
	static void logOut()
    {
   	 try
   	 {
   		 Thread.sleep(20000);
   		 oBrowser.findElement(By.id("logoutLink")).click();
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
