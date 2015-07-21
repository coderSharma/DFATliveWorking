package com.DFATPageObjects.Careers;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.DFAT_Australia.BaseClass;


public class Roles_Vacancies_IntelligenceOfficePageObjects extends BaseClass{
	WebDriver driver;
	public String url="http://003.sitecore.dfat.uat.visualjazz.com.au/Careers/Roles-and-Vacancies.aspx";
	// The element is now looked up using the name attribute
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Apply Now')]")
	public WebElement ApplyNowButton;

		
	
	public boolean ClickApplyNowButton() {

		click(ApplyNowButton);
		return true ;
	}

	
	
} 

