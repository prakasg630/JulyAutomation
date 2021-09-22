package com.sgtesting.automatiomdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
public static WebDriver oBrowser=null;
	public static void main(String[] args) {
	launchBrowser();
	navigate();
	relativeXPathUsingTagNameAlone();
	}
	static void launchBrowser()
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
	
	static void navigate()
	{
		try
		{
			oBrowser.get("G:/HTML/Sample.html");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void relativeXPathUsingTagNameAlone()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[contains(@id,'pwd1pas')]")).sendKeys("DemoUser1");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
