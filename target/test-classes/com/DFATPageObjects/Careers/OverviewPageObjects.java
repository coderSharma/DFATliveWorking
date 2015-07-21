package com.DFATPageObjects.Careers;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.DFAT_Australia.BaseClass;


public class OverviewPageObjects extends BaseClass{
	public WebDriver driver;
	public String url="http://003.sitecore.dfat.uat.visualjazz.com.au/Careers/Overview.aspx";
	// The element is now looked up using the name attribute
	@FindBy(how = How.ID, using = "RegisterLinkStandalone")
	public WebElement RegistrationLink;

	
} 

