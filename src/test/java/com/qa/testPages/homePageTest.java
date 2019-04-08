package com.qa.testPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.pages.homePage;
import com.zoopla.testBase.baseClass;

public class homePageTest extends baseClass
{

	homePage homepage;
	
	
	
	public homePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void browweLaunch()
	{
		launchBrowser();
		
	}
	
//	@Test(priority=1)
//	public void validate_Eleemnts()
//	{
//		boolean logo_visible=homepage.verify_Logo();
//		boolean logo_SerchTxtBox=homepage.verify_SerchTxtBox();
//		boolean logo_link_advancedOptions=homepage.verify_link_advancedOptions();
//		boolean logo_btn_submitSearch=homepage.verify_btn_submitSearch();
//		
//		if(logo_visible==true & logo_SerchTxtBox==true & logo_link_advancedOptions==true & logo_btn_submitSearch==true)
//		{
//		   
//		}
//		else
//		{
//		   Assert.fail("Element not found, check validate_Eleemnts() in HomePageTest() class."); 
//		}
//	}
	@Test(priority=1)
	public void search_peroformed()
	{
		homepage=new homePage();
		
		homepage.enter_Searchtext("London");
		homepage.click_advancedSearch();
		wait_twoSEC();
		
		/**
		 *  0: Highest price
			1: Lowest price
			2: Most recent
			3: Most reduced
			4: Most popular
		 */
		
		homepage.select_dropdwnValue(0);

		wait_twoSEC();
		
		homepage.click_SearchButton();
		
		try 
		{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/**
		 *    //ul[@class='listing-results clearfix js-gtm-list']/li  -- get list count
		 *    
		 *    //ul[@class='listing-results clearfix js-gtm-list']/li/div/div[2]//a   // reached to mentioned Price 
		 *    
		 *    
		 */
		
		// Get all Property Listed in the page, where we wanna get the 5th item link, and click on it and verify
		// got to 5th Item
		// copy the name of the property.
		// get the link of the 5th item
		// navigate to this link, and match the name of the property with saved name.
		
		List<WebElement> prop = homepage.poropLi();
		System.out.println("available propperties are : " + prop.size());
	    
		for(int i=0;i<prop.size();i++)
		{
			if(i==5)
			{
				 
				// get title of the proprty and save it , to comapre later
				// naviagate to the link and match the price and title
				//System.out.println(driver.findElement(By.xpath(homepage.prop_preFix+i+homepage.prop_postFix)).getText());
				
				
				// get price of the property
				  String xpath_Navigate_url= homepage.prop_price_preFix+i+homepage.prop__price_postFix;
				  String xpath_price= homepage.prop_price_preFix+i+homepage.prop__price_postFix;
				  String xpath_title= homepage.prop_title_preFix+i+homepage.prop_title_postFix;
				  
				  
				  
				 String h_PagePrice = homepage.getPrice(xpath_price);
				 String h_page_tile = homepage.getTtile(xpath_title);
				 System.out.println("home page Property Price is :" +  h_PagePrice);
				 System.out.println("home page Property title is :" +  h_page_tile);
				 
				 /**
				  *      Navigate to 5th Property link
				  */
				 try 
				 {
				 homepage.navigateToURL(xpath_Navigate_url);
				 
				 
				 wait_FourSEC();
				 
				 String landing_pageTile= homepage.get_LanginPage_Ttile();
				 
				 System.out.println("landing_pageTile is : " + landing_pageTile);
				 
				 wait_twoSEC();
				 
				 Assert.assertEquals(h_page_tile.toLowerCase(), landing_pageTile.toLowerCase());
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
					 System.out.println("Failed to click on Price tag , xpath: " + xpath_Navigate_url);
					 
					 try 
					 {
					 
					 System.out.println("try to click on Title tag , xpath: " + xpath_title);
					 homepage.navigateToURL(xpath_title);
					 wait_FourSEC();
					 
					 String landing_pageTile= homepage.get_LanginPage_Ttile();
					 
					 System.out.println("landing_pageTile is : " + landing_pageTile);
					 
					 wait_twoSEC();
					 
					 Assert.assertEquals(h_page_tile.toLowerCase(), landing_pageTile.toLowerCase());
					 }
					 catch(Exception ex)
					 {
						 ex.printStackTrace();
					 }
				 }
				 
				
				
			}
		}
		
		
		
		
	}
	
	
	@AfterMethod
	public void exitSetup()
	{
		//driver.quit();
	}
	
	
}
