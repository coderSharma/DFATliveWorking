package com.DFATPageObjects.MyApplications;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.DFAT_Australia.BaseClass;


public class Step5_ExtendedResponse_PageObjects extends BaseClass{
	public static WebDriver driver;
	static String specialText="This is <test> #1" ;
	String longText="This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again. ";
	String shortText="This is a test to make sure we can enter some random text over and over again.";
	String htmlInjection="<html><h1>this will appear supper big</html>";
	String sqlInjection;
	boolean Errorcheckresult;
	// The element is now looked up using the name/ID/XPATH attribute

	//Selection Criteria Section
	static List <WebElement> SelectionCriterias = new ArrayList<WebElement>(); 
	static List <WebElement> SelectionCriteriaDropBoxes = new ArrayList<WebElement>();
	static List <WebElement> SelectionCriteriaRadioButtons = new ArrayList<WebElement>();
	

	//Statistical Information Section
	@FindBy(how=How.ID,using="HearAboutEmploymentOnline")
	WebElement HearAboutusOnlineDropdown;
	@FindBy(how=How.ID,using="AboutDfatOnline")
	WebElement HeardAboutASISOnlineDropdown;
	@FindBy(how=How.XPATH,using="//label[@for='AboriginalTorres1']")
	WebElement YesAboriginalRadioButton;
	@FindBy(how=How.XPATH,using="//label[@for='AboriginalTorres2']")
	WebElement NoAboriginalRadioButton;
	@FindBy(how=How.XPATH,using="//label[@for='personWithDisability1']")
	WebElement YesDisabilityRadioButton;
	@FindBy(how=How.XPATH,using="//label[@for='personWithDisability2']")
	WebElement NoDisabilityRadioButton;
	@FindBy(how=How.XPATH,using="//label[@for='personFromCulturally1']")
	WebElement YesDiverserbackgroundRadioButton;
	@FindBy(how=How.XPATH,using="//label[@for='personFromCulturally2']")
	WebElement NoDiverserbackgroundRadioButton;
	@FindBy(how=How.XPATH,using="//label[@for='specialRequriments1']")
	WebElement YesSpecialRequirementsRadioButton;
	@FindBy(how=How.ID,using="WhatSpecialInterviewRequirement")
	WebElement SpecialRequirementTextbox;
	@FindBy(how=How.XPATH,using="//label[@for='specialRequriments2']")
	WebElement NoSpecialRequirementsRadioButton;
	@FindBy(how=How.ID,using="Comments")
	WebElement CommentsTextBox;





	@FindBy(how = How.XPATH, using = "//input[@value='Save & Continue']")
	public WebElement SaveAndContinueButton;

	public void fillSelectionCriteria(WebDriver Driver)
	{
		try{
		SelectionCriteriaDropBoxes= Driver.findElements(By.xpath("//select[contains(@title,'Selection Criteria')]"));
		for (WebElement DropBoxes : SelectionCriteriaDropBoxes)
		{
			Select mySelection = new Select(DropBoxes);
			mySelection.selectByIndex(1);
		}
		}
		catch (Exception e){
			System.out.println("no runtime Dropdowns found");
		}
		try{
			SelectionCriteriaRadioButtons= Driver.findElements(By.xpath("//label[contains(@for,'Criteria')]"));
			for (int i=0;i<SelectionCriteriaRadioButtons.size();i++)
			{
				if(i%2==0)
				SelectionCriteriaRadioButtons.get(i).click();
			}
			}
			catch (Exception e){
				System.out.println("no runtime Radio buttons found");
			}
		
		SelectionCriterias=Driver.findElements(By.xpath("//textarea[contains(@id,'Criteria')]"));	
		for (WebElement TextBoxes : SelectionCriterias)
		{
			enterText(TextBoxes,shortText);
		}
	}
	public void fillSelectionCriteriaHTML(WebDriver Driver)
	{
		SelectionCriterias=Driver.findElements(By.xpath("//textarea[contains(@id,'Criteria')]"));	
		for (WebElement TextBoxes : SelectionCriterias)
		{
			enterText(TextBoxes,htmlInjection);
		}
	}

	public boolean FillFormStandard(WebDriver Driver) throws InterruptedException
	{
		try{
			fillSelectionCriteria(Driver);
			selectDropDown(HearAboutusOnlineDropdown, "Facebook");
			selectDropDown(HeardAboutASISOnlineDropdown, "Facebook");
			click(NoAboriginalRadioButton);
			click(NoDisabilityRadioButton);
			click(NoDiverserbackgroundRadioButton);
			click(YesSpecialRequirementsRadioButton);
			enterText(SpecialRequirementTextbox,"Need to be interviewed after 5PM");
			friendlyProcesseRating(Driver);
			enterText(CommentsTextBox, shortText);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean FillFormSubStandard(WebDriver Driver) throws InterruptedException
	{
		try{
			fillSelectionCriteria(Driver);
			selectDropDown(HearAboutusOnlineDropdown, "Facebook");
			selectDropDown(HeardAboutASISOnlineDropdown, "Facebook");
			click(NoAboriginalRadioButton);
			click(NoDisabilityRadioButton);
			click(NoDiverserbackgroundRadioButton);
			click(YesSpecialRequirementsRadioButton);
			enterText(SpecialRequirementTextbox,specialText);
			friendlyProcesseRating(Driver);
			enterText(CommentsTextBox, specialText);
			click(SaveAndContinueButton);
			
			//Fill realData
			fillSelectionCriteria(Driver);
			selectDropDown(HearAboutusOnlineDropdown, "Facebook");
			selectDropDown(HeardAboutASISOnlineDropdown, "Facebook");
			click(NoAboriginalRadioButton);
			click(NoDisabilityRadioButton);
			click(NoDiverserbackgroundRadioButton);
			click(YesSpecialRequirementsRadioButton);
			enterText(SpecialRequirementTextbox,"Need to be interviewed after 5PM");
			friendlyProcesseRating(Driver);
			enterText(CommentsTextBox, shortText);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean FillFormReview() throws InterruptedException
	{
		
			Thread.sleep(1000);
			click(SaveAndContinueButton);
			System.out.println("Reviewed Extended Response Page");
			return true;
	
	}
	
	public boolean FillFormShort(WebDriver Driver) throws InterruptedException
	{
		try{
			fillSelectionCriteria(Driver);
			selectDropDown(HearAboutusOnlineDropdown, "Facebook");
			selectDropDown(HeardAboutASISOnlineDropdown, "Facebook");
			click(NoAboriginalRadioButton);
			click(NoDisabilityRadioButton);
			click(NoDiverserbackgroundRadioButton);
			click(NoSpecialRequirementsRadioButton);
			friendlyProcesseRating(Driver);
			enterText(CommentsTextBox, shortText);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean FillFormHtmlInjection(WebDriver Driver) throws InterruptedException
	{
		try{
			// Extended Response 
			fillSelectionCriteriaHTML(Driver);
			selectDropDown(HearAboutusOnlineDropdown, "Facebook");
			selectDropDown(HeardAboutASISOnlineDropdown, "Facebook");
			click(NoAboriginalRadioButton);
			click(NoDisabilityRadioButton);
			click(NoDiverserbackgroundRadioButton);
			click(YesSpecialRequirementsRadioButton);
			enterText(SpecialRequirementTextbox,"Need to be interviewed after 5PM");
			friendlyProcesseRating(Driver);
			enterText(CommentsTextBox, shortText);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void friendlyProcesseRating(WebDriver Driver)
	{
		Random r= new Random();
		int random=r.nextInt(9);
		click(Driver.findElement(By.xpath("//label[@for='friendlyProcess"+(random+1)+"']")));
		System.out.println("Rating Given:"+(random+1));
	}

	// Error Checking functions on a page
	public boolean errorChecker(WebDriver Driver,String Path,String Section,int Errors) throws IOException, InterruptedException
	{
		try
		{int count=0;
		click(SaveAndContinueButton);
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
			//	System.out.println("Error Text "+(count+1)+":"+errrors.getText());
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
	public boolean FillFormErrorChecker(WebDriver Driver,String Path,String Section, int Errors) throws InterruptedException, IOException
	{
		try{
			//Error Checker
			click(YesSpecialRequirementsRadioButton);
			Errorcheckresult=errorChecker(Driver,Path,Section,Errors);
			// Extended Response 
			fillSelectionCriteria(Driver);
			selectDropDown(HearAboutusOnlineDropdown, "Facebook");
			selectDropDown(HeardAboutASISOnlineDropdown, "Facebook");
			click(NoAboriginalRadioButton);
			click(NoDisabilityRadioButton);
			click(NoDiverserbackgroundRadioButton);
			click(YesSpecialRequirementsRadioButton);
			enterText(SpecialRequirementTextbox,"Need to be interviewed after 5PM");
			friendlyProcesseRating(Driver);
			enterText(CommentsTextBox, shortText);
			click(SaveAndContinueButton);
			
			if (!(Errorcheckresult)){
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


} 

