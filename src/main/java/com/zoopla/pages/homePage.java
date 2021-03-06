package com.zoopla.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zoopla.testBase.baseClass;

public class homePage extends baseClass
{
	
	/**
	 *      PageFectory
	 */
	
	//Verify Logo
	
	@FindBy(xpath="//img[@class='icon--logo']") WebElement img_logo;
	
	@FindBy(xpath="//li[@id='mn-buy']/a") WebElement for_Sale;
	
	@FindBy(xpath="//input[@id='search-input-location']") WebElement inp_searchTxtBox;
	@FindBy(xpath="//a[@class='search-advanced-toggle link']") WebElement link_advancedOptions;
	
	//sort-by
	@FindBy(xpath="//select[@id='sort_by']") WebElement drp_sortBy;
	
	@FindBy(xpath="//button[@id='search-submit']") WebElement btn_submitSearch;
	
	
	@FindBys(@FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']/li")) private List<WebElement> propList;
	
	
	/**
	 *     Dynamic Locations for getting Price of th Property + GetLink + Get_title
	 */
	
	public String prop_price_preFix = "(//div[@class='listing-results-wrapper'])[";              // here you have to give index value
	public String prop__price_postFix ="]//a[@class='listing-results-price text-price']";
	
	public String prop_title_preFix="(//div[@class='listing-results-wrapper'])[";				// here you have to give index value
	public String prop_title_postFix="]//h2[@class='listing-results-attr']/a";
	
	
	
	// After Navigation, Landing Page tile test
	   // //h1[@class='ui-property-summary__title ui-title-subgroup']        /// verify tile with above saved title

	@FindBy(xpath="//h1[@class='ui-property-summary__title ui-title-subgroup']") WebElement landing_page_Title;
	
	
	
	
	public boolean verify_Logo()
	{
		wait_twoSEC();

		//boolean res= img_logo.isDisplayed();
		boolean res= driver.findElement(By.xpath("//img[@class='icon--logo']")).isDisplayed();
		return res;
		
	}
	
	
	public String verify_for_Sale()
	{
		
		return for_Sale.getText();
	}
	
	
	public List<WebElement> poropLi()
	{
		
		System.out.println("properties List size :" + propList.size());
		return propList;
	}
	
	public String getPrice(String xpath_price)
	{
		
		String h_price="";
		h_price = driver.findElement(By.xpath(xpath_price)).getText();
		return h_price;
	}
	
	public String getTtile(String xpath_title)
	{
		String h_title ="";
		h_title = driver.findElement(By.xpath(xpath_title)).getText();
		return h_title;
	}
	
	public void navigateToURL(String xpath_price)
	{
		
		driver.findElement(By.xpath(xpath_price)).click();
		wait_twoSEC();
	}
	

	public String get_LanginPage_Ttile()
	{
		String l_title ="";
		l_title =landing_page_Title.getText();
		return l_title;
	}
	
	
	public homePage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	

	
	public boolean verify_SerchTxtBox()
	{
		wait_twoSEC();
		boolean inp_searchTxtBox_=inp_searchTxtBox.isDisplayed();
		System.out.println("visibility of inp_searchTxtBox is : " + inp_searchTxtBox_);
		
		return inp_searchTxtBox_;
	}
	
	public boolean verify_link_advancedOptions()
	{
		wait_twoSEC();
		boolean link_advancedOptions_=link_advancedOptions.isDisplayed();
		System.out.println("visibility of link_advancedOptions_ is : " + link_advancedOptions_);
		return link_advancedOptions.isDisplayed();
	}
	
	public boolean verify_btn_submitSearch()
	{
		return inp_searchTxtBox.isDisplayed();
	}
	
    
	
	public void enter_Searchtext(String country)
	{
		inp_searchTxtBox.sendKeys(country);
		
	}
	
	public void click_advancedSearch()
	{
		link_advancedOptions.click();
	}
	
	public void select_dropdwnValue(int no)
	{
		Select drop= new Select(drp_sortBy);
		wait_twoSEC();
		drop.selectByIndex(no);
		wait_twoSEC();
	}
	
	
	public void click_SearchButton()
	{
		btn_submitSearch.click();
	}
	
	
	

}
