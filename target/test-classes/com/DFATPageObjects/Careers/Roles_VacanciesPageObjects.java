package com.DFATPageObjects.Careers;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.DFAT_Australia.BaseClass;


public class Roles_VacanciesPageObjects extends BaseClass{
	WebDriver driver;
	public String url="https://www.asis.gov.au/Careers/Roles-and-Vacancies.html";
	public String fullurl="https://www.asis.gov.au";
	/*public String url="http://124.47.154.22/Careers/Roles-and-Vacancies.html";
	public String fullurl="http://124.47.154.22/";*/
	//http://124.47.154.22/
	// The element is now looked up using the name attribute

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'mainsection_1_maincontent_0_bodycontent_1_VacancyBlock_JobRolesListing_ctl00_hypApply')]")
	public WebElement IntelligenceOfficerViewAndApplyButton;

	public boolean ClickViewAndApplyIOfficerButton() {
		
		click(IntelligenceOfficerViewAndApplyButton);
		return true ;
	}

	public WebDriver DFATPageChrome(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Chrome Browser");	
		Driver= browserSetup("chrome");
		try {
			Driver.get(url);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+url+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}
	public WebDriver DFATPageHeadless(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Headless Browser");	
		Driver= browserSetup("");
		try {
			Driver.get(url);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+url+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}
	public WebDriver DFATMainPageChrome(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Chrome Browser");	
		Driver= browserSetup("chrome");
		try {
			Driver.get(fullurl);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+fullurl+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}
	public WebDriver DFATMainPageHeadless(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Chrome Browser");	
		Driver= browserSetup("");
		try {
			Driver.get(fullurl);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+fullurl+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}
	public WebDriver DFATMainPageFirefox(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Firefox Browser");	
		Driver= browserSetup("firefox");
		try {
			Driver.get(fullurl);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+fullurl+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}
	
	public WebDriver DFATPageIE(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Chrome Browser");	
		Driver= browserSetup("ie");
		try {
			Driver.get(url);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+url+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}

	public WebDriver DFATPageFirefox(WebDriver Driver) throws InterruptedException
	{
		System.out.println("Settingup Firefox Browser");	
		Driver= browserSetup("firefox");
		try {
			Driver.get(url);
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println("Unable to get URL:"+url+", Environment may be unavailable. Aborting Test");
			System.exit(1);
		}
		return Driver;

	}


} 