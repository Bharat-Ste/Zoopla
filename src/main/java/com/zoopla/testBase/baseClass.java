package com.zoopla.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {

	public static WebDriver driver;
	public static Properties prop;
	FileInputStream fs;
	public baseClass()
	{
		System.out.println("testBase() CONST invoked - Invoked Prop");
		
		prop = new Properties();
		
		try 
		{
			fs = new FileInputStream("/Users/bharat/eclipse-workspace/Zoopla/src/main/java/com/zoopla/config/config.properties");
			
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		try 
		{
			prop.load(fs);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	public static void launchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","/Users/bharat/eclipse-workspace/Myntra/src/main/java/lib/chromedriver");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		wait_FourSEC();
		
		
	}
	
	public static void exitBrowser()
	{
		driver.quit();
	}
	
	public static void wait_twoSEC()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public static void wait_FourSEC()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
