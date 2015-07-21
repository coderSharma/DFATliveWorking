package com.DFATPageObjects.MyApplications;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.DFAT_Australia.BaseClass;


public class Step6_ReviewAndSubmit_PageObjects extends BaseClass{
	public WebDriver driver;
	static String specialText="This is <test> #1" ;
	static List <WebElement> Expanders = new ArrayList<WebElement>();
	boolean Errorcheckresult;
	public String url="http://003.sitecore.dfat.uat.visualjazz.com.au/Careers/Roles-and-Vacancies.aspx";
	// The element is now looked up using the name/ID/XPATH attribute

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/Application/Step/Personal')]")
	public WebElement PersonalPageEditButton;
	@FindBy(how = How.XPATH, using = "//label[@for='Declaration']")
	public WebElement declarationPrivacyCheckbox;
	@FindBy(how = How.XPATH, using = "//label[@for='SecurityObligations']")
	public WebElement declarationSecurityCheckbox;
	@FindBy(how = How.XPATH, using = "//label[@for='Consent']")
	public WebElement generalConsentCheckbox;
	@FindBy(how = How.XPATH, using = "//input[@value='Finish & Submit Application']")
	public WebElement FinishAndSubmitApplicationButton;
	
	


	public boolean ReviewFormStandard(WebDriver Driver,String Path) throws InterruptedException, IOException
	{
		try{
			clickExpanders(Driver);
			click(declarationPrivacyCheckbox);
			click(declarationSecurityCheckbox);
			click(generalConsentCheckbox);
			Thread.sleep(2000);
			FileUtils.copyFile(screenshot(Driver), new File(Path+"/ApplicationScreenshot.png"));
			/*click(FinishAndSubmitApplicationButton);
			Thread.sleep(5000);
			FileUtils.copyFile(screenshot(Driver), new File(Path+"/SubmissionScreenshot.png"));
			Driver.get(url);*/
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean ReviewFullFormStandard(WebDriver Driver) throws InterruptedException, IOException
	{
		try{
			clickExpanders(Driver);
			click(PersonalPageEditButton);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public void clickExpanders(WebDriver Driver) throws InterruptedException
	{
		Expanders=Driver.findElements(By.xpath("//span[contains(.,'+ / -')]"));
		for(WebElement Icons: Expanders)
		{
			click(Icons);
			Thread.sleep(200);
		}
	}
	// Error Checking functions on a page
	public boolean errorChecker(WebDriver Driver,String Path,String Section,int Errors) throws IOException, InterruptedException
	{
		try
		{int count=0;
		click(FinishAndSubmitApplicationButton);
		Thread.sleep(1000);
		List <WebElement> ErrorList = new ArrayList<WebElement>(); 
		ErrorList=Driver.findElements(By.xpath("//span[contains(@id,'-error')]"));
		BaseClass.myWriteAppend(Path,"");
		BaseClass.myWriteAppend(Path,Section);
		BaseClass.myWriteAppend(Path,"");
		//System.out.println("Error Message list");
		for (WebElement errrors: ErrorList)
		{
			if (!errrors.getText().isEmpty())
			{
				BaseClass.myWriteAppend(Path,"Error Text "+(count+1)+":"+errrors.getText());
				//System.out.println("Error Text "+(count+1)+":"+errrors.getText());
				count=count+1;
			}
		}
		System.out.println("Expected "+Errors+" Errors and Found "+count);
		BaseClass.myWriteAppend(Path,"");
		BaseClass.myWriteAppend(Path,"Expected "+Errors+" Errors and Found "+count);
		if (!(count==Errors))
		{
			System.out.println("Number of error Messages Inconsistant.");
			return false;

		}
		BaseClass.myWriteAppend(Path,"***********************************");
		BaseClass.myWriteAppend(Path,"");
		return true;
		}
		catch (Exception e)
		{
			return false;
		}

	}
	public boolean FillFormErrorChecker(WebDriver Driver,String ErrorLog,String Path,String Section, int Errors) throws InterruptedException, IOException
	{
		try{
			//Error Checker
			clickExpanders(Driver);
			click(FinishAndSubmitApplicationButton);
			Errorcheckresult=errorChecker(Driver,ErrorLog,Section,Errors);
			//Filling Form
			click(generalConsentCheckbox);
			click(declarationPrivacyCheckbox);
			click(declarationSecurityCheckbox);
			Thread.sleep(2000);
			FileUtils.copyFile(screenshot(Driver), new File(Path+"/ApplicationScreenshot.png"));
			click(FinishAndSubmitApplicationButton);
			Thread.sleep(5000);
			FileUtils.copyFile(screenshot(Driver), new File(Path+"/SubmissionScreenshot.png"));
			if (!(Errorcheckresult)){
				return false;
			}
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}



} 

